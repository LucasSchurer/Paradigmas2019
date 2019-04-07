{-
   Programa em Haskell para validar os digitos de um CPF
   Mais info em: http://pt.wikipedia.org/wiki/Cadastro_de_Pessoas_F%C3%ADsicas

   O código dos slides possuí uma função auxiliar para o cálculo dos dígitos, com a quantidade dos dígitos sendo passada por uma outra função.
-}
import Data.Char

isCpfOk :: [Int] -> Bool
isCpfOk cpf = dv1 == cpf !! 9 && dv2 == cpf !! 10
  where digitos1 = take 9 cpf
        expr1 = (sum $ zipWith (*) digitos1 [10, 9 .. 2]) `mod` 11
        dv1 = if expr1 < 2 then 0 else 11 - expr1

        digitos2 = digitos1 ++ [dv1]
        expr2 = (sum $ zipWith (*) digitos2 [11, 10 .. 2]) `mod` 11
        dv2 = if expr2 < 2 then 0 else 11 - expr2

main :: IO()
main = do
  putStr "CPF: "
  cpf <- getLine
  let digits = (map digitToInt cpf)
  putStrLn (if isCpfOk digits then "OK" else "Not Ok")


cpfValid :: [Int] -> Bool
cpfValid cpf = dv1 == cpf !! 9 && dv2 == cpf !! 10
 where digits = take 9 cpf
       dv1 = cpfDV digits [10,9..]
       dv2 = cpfDV (digits ++ [dv1]) [11,10..]

cpfDV :: [Int] -> [Int] -> Int
cpfDV digits mults =
 let expr = (sum $ zipWith (*) digits mults) `mod` 11
 in if expr < 2 then 0 else 11-expr

main2 :: IO()
main2 = do
  putStr "CPF: "
  cpf <- getLine
  let digits = (map digitToInt cpf)
  putStrLn (if cpfValid digits then "OK" else "Not Ok")
