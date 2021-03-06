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
semVogais str = filter (not . isVowel) str

-- Com função anônima
semVogais2 :: String -> String
semVogais2 str = filter (\x -> not (x == 'A' || x == 'I' || x == 'U' || x == 'E' || x == 'O' || x == 'a' || x == 'i' || x == 'u' || x == 'e' || x == 'o')) str

-- 5.
-- Recebe uma string que possivelmente contém espaços, substituindo todos os caracteres diferentes de espaço por '-''
-- Sem função anônima
codifica :: String -> String
codifica str = map changeChar str

-- Troca um caracter que não é espaço por '-''
changeChar :: Char -> Char
changeChar char
    | char /= ' ' = '-'
    | otherwise = ' '

-- Com função anônima
codifica2 :: String -> String
codifica2 str = map (\x -> if x /= ' ' then '-' else ' ') str

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
lastName last_name = last (words last_name)

-- 9.
-- Retorna um nome de usuário formado pela primeira letra do nome do usuário + o sobrenome, tudo em minúsculas.
userName :: String -> String
userName name = map toLower ([head (firstName name)] ++ lastName name)

-- 10.
-- Substitui vogais em uma string, seguindo as regras: a = 4, e = 3, i = 1, o = 0, u = 00.
encodeName :: String -> String
encodeName name = map encodeNameAux name

encodeNameAux :: Char -> Char
encodeNameAux char
    | char == 'a' = '4'
    | char == 'e' = '3'
    | char == 'i' = '2'
    | char == 'o' = '1'
    | char == 'u' = '0'
    | char == 'A' = '4'
    | char == 'E' = '3'
    | char == 'I' = '2'
    | char == 'O' = '1'
    | char == 'U' = '0'
    | otherwise = char

-- 11.
-- Substitui vogais em uma string, seguindo as regras: a = 4, e = 3, i = 1, o = 0, u = 00.
betterEncodeName :: String -> String
betterEncodeName name = concat (map betterEncodeNameAux (splitString name))

-- Separa a string em uma lista de strings.
splitString :: String -> [String]
splitString str = map (\x -> [x]) str

betterEncodeNameAux :: String -> String
betterEncodeNameAux str
    | str == "a" = "4"
    | str == "e" = "3"
    | str == "i" = "1"
    | str == "o" = "0"
    | str == "u" = "00"
    | str == "A" = "4"
    | str == "E" = "3"
    | str == "I" = "1"
    | str == "O" = "0"
    | str == "U" = "00"
    | otherwise = str

-- 12.
-- Dada uma lista de strings, aquelas com mais de 10 caracteres são truncadas, e aquelas com menos são completadas com '.'
-- Sem função anônima
func :: [String] -> [String]
func lis = map funcAux lis

funcAux :: String -> String
funcAux str = if length str > 10 then take 10 str else funcAux (str ++ "..........")

-- Com função anônima
func2 :: [String] -> [String]
func2 lis = map (\x -> take 10 (x ++ "..........")) lis

