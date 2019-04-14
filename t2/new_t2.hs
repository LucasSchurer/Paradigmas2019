import Text.Printf

-- Definição dos tipos.

type Point =
    ( Float, Float )

type Colour = 
    ( Float, Float, Float )

type Rect =
    ( Point, Float, Float, Colour )

type Circle =
    ( Point, Float, Colour )

-- Funções matemáticas auxiliares.

degreesToRad :: Float -> Float
degreesToRad degrees =
    degrees * ( pi / 180 )


-- Funções para gerar cores.

getColour :: Int -> Colour
getColour x
    | x == 1 = ( 255, 0, 0 ) -- Vermelho
    | x == 2 = ( 0, 0, 255 ) -- Verde
    | x == 3 = ( 0, 0, 255 ) -- Azul
    | otherwise = ( 0, 0, 0 ) -- Preto


-- Geração das formas geométricas utilizadas em cada caso.

genRects :: Int -> Int -> [Rect]
genRects c l =
    [ ( 
    ( x * ( width + gap )
    , y * ( height + gap ) )
    , width
    , height
    , ( r, g, b ) ) 
    | x <- [ 1 .. fromIntegral (c-1) ]
    , y <- [ 1 .. fromIntegral (l-1) ] ] 

    where 
        ( width, height ) = ( 50, 50 )
        gap = 10
        ( r, g, b ) = ( 100, 100, 100 )


-- Geração das strings contendo as figuras em SVG.

svgRects :: Rect -> String
svgRects ( ( x, y ), w, h, ( r, g, b) ) =
    printf "<rect x = '%.2f' y = '%.2f' width = '%.2f' height = '%.2f' style = 'fill:rgb(%.2f, %.2f, %.2f)'/>" x y w h r g b


-- Geração das strings contendo elementos básicos em SVG.

svgBegin :: Float -> Float -> String
svgBegin w h =
    printf "<svg width='%.2f' height='%.2f' xmlns='http://www.w3.org/2000/svg'>\n" w h

svgEnd :: String
svgEnd =
    "</svg>"


-- Casos

case1 :: IO ()
case1 = do
    writeFile "case1.svg" $ svgstrs
    where
        svgstrs = svgBegin w h ++ svgrects ++ svgEnd
        svgrects = concat $ map svgRects $ genRects 10 5
        ( w, h ) = ( 1920, 1080 )