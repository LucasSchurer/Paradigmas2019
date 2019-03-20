-- Checa se uma letra é diferente ao espaço.
differentLetter :: Char -> Bool
differentLetter l1 = l1 == ' '

-- Remove todas as letras diferentes de espaço de uma palavra.
removeLetter :: [Char] -> [Char]
removeLetter word = filter differentLetter word

-- Retorna a quantidade de espaços em uma palavra.
numberLetter :: [Char] -> Int
numberLetter word = length (removeLetter word)

-- Retorna o primeiro elemento de uma lista.
firstList :: [Int] -> Int
firstList lis = head lis

-- Calcula o quadrado de um número.
square :: Int -> Int
square x = x^2

-- Calcula a soma dos quadrados de dois números.
sumSquares :: Int -> Int -> Int
sumSquares x y = square x + square y

-- Verifica se duas listas possuem o primeiro elemento.
hasEqHeads :: [Int] -> [Int] -> Bool
hasEqHeads lis1 lis2 = firstList lis1 == firstList lis2

-- Cria uma lista que adiciona "Super" na frente de uma palavra.
superMe :: [Char] -> [Char]
superMe word = "Super " ++ word

superMeList :: [String] -> [String]
superMeList lis = map superMe lis

-- Calcula 3*n^2 + 2/n + 1 para cada elemento da lista.
equation :: [Float] -> [Float]
equation list = map (\n -> 3*n^2 + 2/n + 1) list

-- Retorna apenas os números negativos de uma lista.
returnNegative :: [Int] -> [Int]
returnNegative numbers = filter (\x -> x < 0) numbers

-- Retorna números de uma lista entre x(1) e y(100), com eles inclusos.
returnNumbersBetweenXY :: [Int] -> [Int]
returnNumbersBetweenXY numbers = filter (\x -> x > 0 && x < 101) numbers

-- Retorna apenas as idades das pessoas que nasceram depois de 1980.
returnAge :: [Int] -> [Int]
returnAge numbers = filter (\x -> 2019 - 1980 < x) numbers;

-- Retorna apenas os números pares de uma lista.
returnEven :: [Int] -> [Int]
returnEven numbers = filter (\x -> mod x 2 == 0) numbers;

-- Verifica se x (char) está contido em y (string).
charFound :: Char -> [Char] -> Bool
charFound letter word = filter (\x -> letter == x) word /= ""

-- Checa se a última letra de uma palavra é a.
checkNameA :: [Char] -> Bool
checkNameA name = last name == 'a'

-- Retorna apenas os nomes que terminem com a letra a.
returnNamesA :: [String] -> [String]
returnNamesA names = filter checkNameA names

-- Retira o sobrenome de uma pessoa.
removeLastName :: [Char] -> [Char]
removeLastName name = takeWhile (/=' ') name;
