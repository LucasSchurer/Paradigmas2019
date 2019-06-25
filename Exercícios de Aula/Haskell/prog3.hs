-- 1.
-- Usando list comprehension cria uma função que adiciona 10 para todos os elementos de uma lista.

add10toall :: [Int] -> [Int]
add10toall lis = [x+10 | x <- [1..(length lis)]]

-- 2.
-- Usando list comprehension cria uma função que multiplica todos os elementos de uma lista lis por um valor N
multN :: Int -> [Int] -> [Int]
multN n lis = [x*n | x <- [1..(length lis)]]

-- 3.
-- Usando list comprehension cria uma função que aplica a equação (3*x+2) para cada elemento x de uma lista lis.
applyExpr :: [Int] -> [Int]
applyExpr lis = [3*x+2 | x <- [1..(length lis)]]

-- 4.
-- Usando list comprehension cria uma função que adiciona um sufixo para uma lista lis de strings.
addSuffix :: String -> [String] -> [String]
addSuffix suffix lis = [x ++ suffix | x <- lis]

-- 5.
-- Usando list comprehension cria uma função que seleciona apenas os valores maiores que 5 de uma lista lis.
selectgt5 :: [Int] -> [Int]
selectgt5 lis = [x | x <- lis, x > 5]

-- 6.
-- Usando list comprehension realiza a soma de todos os valores ímpares de uma lista lis.
sumOdds :: [Int] -> Int
sumOdds lis = sum (selectOdds lis)

-- Seleciona apenas os elementos ímpares de uma lista lis.
selectOdds :: [Int] -> [Int]
selectOdds lis = [x | x <- lis, (mod x 2) == 1]

-- 7.
-- Usando list comprehension seleciona apenas os elementos pares entre 20 e 50 de uma lista lis.
selectExpr :: [Int] -> [Int]
selectExpr lis = [x | x <- (selectEvens lis), x > 20 && x < 50]

-- Seleciona apenas os valores pares de uma lista lis.
selectEvens :: [Int] -> [Int]
selectEvens lis = [x | x <- lis, (mod x 2) == 0]

-- 8.
-- Usando list comprehension informa o número de palavras que possuem menos de 5 letras em uma lista lis de strings.
countShorts :: [String] -> Int
countShorts lis = length [x | x <- lis, length x < 5]

-- 9.
-- Usando list comprehension resolve a equação (x^2/2) para cada elemento x de uma lista lis e retorna uma outra lista apenas com os valores maiores que 10.
calcExpr :: [Float] -> [Float]
calcExpr lis = [x^2/2 | x <- lis, (x^2/2) > 10]

-- 10.
-- Usando list comprehension troca ' ' por '-' de uma string str.
trSpaces :: String -> String
trSpaces str = [if x == ' ' then '-' else x | x <- str]

-- 11.
-- Qual será o resultado de cada expressão abaixo?

-- [ (x,y) | x <- [1..5], even x, y <- [(x + 1)..6], odd y ]
-- Caso x seja par, y = [(x + 1), .. 6] caso y seja ímpar.
-- x = [1, 2, 3, 4, 5]
-- x = [2, 4]
-- y = [3, 4, 5, 6] = [3, 5]
-- y = [5, 6] = [5]
-- [(2, 3), (2, 5), (4, 5)]

-- [ a ++ b | a <- ["lazy","big"], b <- ["frog", "dog"]]
-- ["lazyfrog", "lazydog", "bigfrog", "bigdog"]


-- concat [ [a,'-'] | a <- "paralelepipedo", not (elem a "aeiou")]
-- [ [a,'-'] | a <- "paralelepipedo", not (elem a "aeiou")]
-- (elem a "aeiou") mostra apenas os elementos que possuem "aeiou"
-- not (elem a "aeiou")] mostra todos os elementos que não possuem "aeiou"
-- Mostra todos os elementos da palavra paralelepipedo que não possuem "aeiou"
-- Troca "aeiou" por '-'?
-- p-r-l-l-p-p-d-


-- 12.
-- Usando list compreehension, seleciona apenas os segundos elementos de uma lista (a, b) de tuplas.
selectSnd :: [(Int, Int)] -> [Int]
selectSnd lis = [(snd x) | x <- lis]

-- 13.
-- Usando a função zip com list comprehension calcula o somatório dos produtos dos pares de elementos de duas listas.
dotProd :: [Int] -> [Int] -> Int
dotProd lis1 lis2 = sum [((fst x)*(snd x)) | x <- (zip lis1 lis2)]

-- 14.
-- Nesta questão você também deverá usar list comprehension. Suponha que um retângulo seja representado por uma tupla (Float,Float,Float,Float), contendo respectivamente as coordenadas x e y do ponto no seu canto superior esquerdo, seguidas das suas medidas de largura e altura. Sabendo que o eixo x cresce de cima para baixo e o eixo y da esquerda para direita, crie uma função genRects :: Int -> (Int,Int) -> [(Float,Float,Float,Float)] que receba um número N e um ponto (x,y) e gere uma sequência de N retângulos não sobrepostos. Os retângulos devem ser alinhados pelos seus topos, a partir do ponto dado, com largura e altura constantes.
genRects :: Int -> (Int, Int) -> [(Float, Float, Float, Float)]
genRects n tuple = [(fromIntegral (fst x) + (5.5*y), 0, 5.5, 5.5) | x <- [tuple], y <- [1..10]]


-- 15.
-- Utilziando zipWith para produzir os mesmos resultados da questão 13.
dotProd' :: [Int] -> [Int] -> Int
dotProd' lis1 lis2 = sum (zipWith (*) lis1 lis2)
