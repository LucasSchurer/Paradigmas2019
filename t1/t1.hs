import Data.Char

-- 1.
-- Verifica se um caracter é uma vogal ou não.
isVowel :: Char -> Bool
isVowel char
   | char == 'A' = True
   | char == 'I' = True
   | char == 'U' = True
   | char == 'E' = True
   | char == 'O' = True
   | char == 'a' = True
   | char == 'i' = True
   | char == 'u' = True
   | char == 'e' = True
   | char == 'o' = True
   | otherwise = False

-- 2.
-- Adiciona uma vírgula no final de cada string contida em uma lista.
addComma :: [String] -> [String]
addComma lis = map (\x -> x ++ ",") lis

-- 3.
-- Recebe uma lista de string e retorna as strings formatadas em HTML.
-- Sem função anônima
htmlListItems :: [String] -> [String]
htmlListItems lis = map htmlListItemsAux lis

htmlListItemsAux :: String -> String
htmlListItemsAux str = "<LI>" ++ str ++ "</LI>"

-- Com função anônima
htmlListItems2 :: [String] -> [String]
htmlListItems2 lis = map (\x -> "<LI>" ++ x ++ "</LI>") lis

-- 4.
-- Recebe uma string e retorna outra retirando todas as vogais.
-- Sem função anônima
semVogais :: String -> String
semVogais str = filter isVowel str

-- Com função anônima
semVogais2 :: String -> String
semVogais2 str = filter (\x -> not (x == 'A' || x == 'I' || x == 'U' || x == 'E' || x == 'O' || x == 'a' || x == 'i' || x == 'u' || x == 'e' || x == 'o')) str

-- 5.
-- Recebe uma string que possivelmente contém espaços, substituindo todos os caracteres diferents de espaço por "-"
-- Sem função anônima
codifica :: String -> String
codifica str = map changeChar str

-- Troca um caracter que não é espaço por "-"
changeChar :: Char -> Char
changeChar char
    | char /= ' ' = '-'
    | otherwise = ' '

-- Com função anônima
-- Arrumar
codifica2 :: String -> String
codifica2 str = map (\x -> '-') str

-- 6.
-- Função que retorna o primeiro nome de uma pessoa.
firstName :: String -> String
firstName name = takeWhile (/= ' ') name

-- 7.
-- Verifica se uma dada string só contém dígitos de 0 a 9.
isInt :: String -> Bool
isInt str = isIntAux2 (map isIntAux str)

isIntAux :: Char -> Bool
isIntAux char
    | char == '1' = True
    | char == '2' = True
    | char == '3' = True
    | char == '4' = True
    | char == '5' = True
    | char == '6' = True
    | char == '7' = True
    | char == '8' = True
    | char == '9' = True
    | char == '0' = True
    | otherwise = False

isIntAux2 :: [Bool] -> Bool
isIntAux2 lis = if filter (\x -> x == False) lis /= [] then False else True

-- 8.
-- Função que retorna o último nome de uma pessoa.
lastName :: String -> String
lastName last_name = filter (\x -> x /= ' ') (dropWhile (/= ' ') last_name)

-- 9.
-- Retorna um nome de usuário formado pela primeira letra do nome do usuário + o sobrenome, tudo em minúsculas.
userName :: String -> String
userName name = map toLower ([head (firstName name)] ++ lastName name)

-- 10.
-- Arrumar a questão do u = 00
-- Substitui vogais em uma string, seguindo as regras: a = 4, e = 3, i = 1, o = 0, u = 00.
encodeName :: String -> String
encodeName name = map encodeNameAux name

encodeNameAux :: Char -> Char
encodeNameAux char
    | char == 'a' = '4'
    | char == 'e' = '3'
    | char == 'i' = '1'
    | char == 'o' = '0'
    | char == 'u' = '0'
    | otherwise = char

-- 11.
-- Substitui vogais em uma string, seguindo as regras: a = 4, e = 3, i = 1, o = 0, u = 00.
betterEncodeName :: String -> String
betterEncodeName name = encodeName (map toLower name)

-- 12.
-- Dada uma lista de strings, aquelas com mais de 10 caracteres são truncadas, e aquelas com menos são completadas com '.'
func :: [String] -> [String]
func lis = lis


funcAux :: String -> String
funcAux str = if length str < 10 then funcAux (str ++ ".") else str
