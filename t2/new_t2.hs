import Text.Printf

-- Definição dos tipos.

data Point = 
    Point
    { x :: Float
    , y :: Float
    }

data Colour = 
    Colour
    { red :: Float
    , green :: Float
    , blue :: Float 
    }

data Shape =
    Rect
    { point :: Point
    , width :: Float
    , height :: Float
    , colour :: Colour
    } |
    
    Circle
    { point :: Point
    , r :: Float
    , colour :: Colour
    }


-- Funções matemáticas auxiliares.

degreesToRad :: Float -> Float
degreesToRad degrees =
    degrees * ( pi / 180 )
    
-- Função para geração de cores.

getColour :: Int -> Int -> Float -> Colour
getColour option nObjects nObject
    | option == 1 = Colour 255 0 0 -- Vermelho
    
    | option == 2 = Colour 0 255 0 -- Verde
    
    | option == 3 = Colour 0 0 255 -- Azul

    | option == 4 = Colour         -- Vermelho-Preto
                        ( 255 - nObject * colourVariation )
                        ( 0 )
                        ( 0 )
    
    | option == 5 = Colour         -- Verde-Preto
                        ( 0 )
                        ( 255 - nObject * colourVariation )
                        ( 0 )

    | option == 6 = Colour         -- Azul-Preto
                        ( 0 )
                        ( 0 )
                        ( 255 - nObject * colourVariation )

    | otherwise = Colour 0 0 0 -- Preto

    where 
        colourVariation = 255 / fromIntegral nObjects

-- Geração das formas geométricas utilizadas em cada caso.

genRects :: Int -> Int -> [Shape]
genRects c l =
    [ Rect
    ( Point 
        ( x * ( width + gap ) )
        ( y * ( height + gap ) ) )
    ( width )
    ( height )
    ( Colour
        ( 255 - ( cvar * ( x + y ) ) )
        ( 0 )
        ( 0 + ( cvar * ( x + y ) ) ) )
    | x <- [ 1 .. fromIntegral ( c-1 ) ]
    , y <- [ 1 .. fromIntegral ( l-1 ) ] ]

    where
        width = 50 :: Float
        height = 50 :: Float
        cvar = 255 / fromIntegral (c+l)
        gap = 10

genCircles :: Int -> Int -> [Shape]
genCircles n greaterCircleRadius =
    [ Circle 
    ( Point
        ( cos ( degreesToRad ( a * angle ) ) * gr + aux )
        ( sin ( degreesToRad ( a * angle ) ) * gr + aux ) )
    ( r )
    ( Colour 
        ( 255 - ( cvar * a ) )
        ( 255/4 + ( cvar/4 * a ) )
        ( 255/2 + ( cvar/2 * a ) ) )
    | a <- [ 0 .. fromIntegral ( n+1 ) ] ]

    where
        gr = fromIntegral greaterCircleRadius
        r = gr / ( fromIntegral n / 2 )
        angle = fromIntegral $ div 360 n
        aux = 1.5 * gr
        cvar = 255 / fromIntegral n

genSinusoids :: Int -> Int -> Int -> [Shape]
genSinusoids nSinusoids nCircles variation =
    genSinusoid 0 nCircles variation 12

genSinusoid :: Float -> Int -> Int -> Int -> [Shape]
genSinusoid height n variation colourOption =
    [ Circle
    ( Point
        ( size * a + 2 * r )
        ( sin ( degreesToRad ( a * angle ) ) * size + aux + height ) )
    ( r )
    ( getColour colourOption n a )
    | a <- [ 0 .. fromIntegral ( n+1 ) ] ]

    where
        size = 20
        r = 6
        angle = fromIntegral $ div variation n
        aux = 1.5 * size

-- Geração das strings contendo as figuras em SVG.

svgRects :: Shape -> String
svgRects rect =
    printf "<rect x = '%.2f' y = '%.2f' width = '%.2f' height = '%.2f' " x' y' w h ++ svgStyle rect

    where 
        points = point rect 
        x' = x points
        y' = y points
        h = height rect
        w = width rect

svgCircles :: Shape -> String
svgCircles circle =
    printf "<circle cx = '%.2f' cy = '%.2f' r = '%.2f' " x' y' r' ++ svgStyle circle

    where
        points = point circle
        x' = x points
        y' = y points
        r' = r circle

svgStyle :: Shape -> String
svgStyle shape =
    "style = 'fill:rgb" ++
    show (r, g, b) ++
    "'/>"

    where
        colours = colour shape
        r = red colours
        g = green colours
        b = blue colours

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
        svgrects = concat $ map svgRects $ genRects 20 10
        (w, h) = (1920, 1080)

case2 :: IO ()
case2 = do
    writeFile "case2.svg" $ svgstrs
    where
        svgstrs = svgBegin w h ++ svgcircles ++ svgEnd
        svgcircles = concat $ map svgCircles $ genCircles 60 200
        (w, h) = (1920, 1080)   

case4 :: IO ()
case4 = do
    writeFile "case4.svg" $ svgstrs
    where
        svgstrs = svgBegin w h ++ svgsinusoid ++ svgEnd
        svgsinusoid = concat $ map svgCircles $ genSinusoids 3 40 1800
        (w, h) = (1920, 1080)
    