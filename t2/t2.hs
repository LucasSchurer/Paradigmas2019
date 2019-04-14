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

    | option == 7 = Colour         -- Vermelho-Azul
                        ( 255 - nObject * colourVariation )
                        ( 0 )
                        ( 0 + nObject * colourVariation )

    | option == 8 = Colour         -- Vermelho-Verde
                        ( 255 - nObject * colourVariation )
                        ( 0 + nObject * colourVariation )
                        ( 0 )

    | option == 9 = Colour         -- Verde-Azul
                        ( 0 )
                        ( 255 - nObject * colourVariation )
                        ( 0 + nObject * colourVariation )

    | option == 10 = Colour        -- Verde-Vermelho
                        ( 0 + nObject * colourVariation )
                        ( 255 - nObject * colourVariation )
                        ( 0 )

    | option == 11 = Colour        -- Azul-Vermelho
                        ( 0 + nObject * colourVariation )
                        ( 0 )
                        ( 255 - nObject * colourVariation )

    | option == 12 = Colour        -- Azul-Verde
                        ( 0 )
                        ( 0 + nObject * colourVariation )
                        ( 255 - nObject * colourVariation )

    | option == 13 = Colour        -- 
                        ( 255/2 - nObject * ( colourVariation/8 ) )
                        ( 255/4 + nObject * ( colourVariation/4 ) )
                        ( 255/4 + nObject * ( colourVariation/2 ) )

    | option == 14 = Colour        -- 
                        ( 255/2 - nObject * ( colourVariation/2 ) )
                        ( 0 + nObject * colourVariation )
                        (( 255/4 + nObject * ( colourVariation/4 ) ))

    | option == 15 = Colour        -- 
                        ( 255 - nObject * ( colourVariation ) )
                        ( 255/4 + nObject * ( colourVariation/4 ) )
                        ( 255/2 + nObject * ( colourVariation/2 ) )

    | option == 16 = Colour        -- 
                        ( 255/4 + nObject * ( colourVariation/4 ) )
                        ( 255/6 + nObject * ( colourVariation/4 ) )
                        ( 255/2 - nObject * ( colourVariation/2 ) )

    | option == 17 = Colour        -- 
                        ( 255/4 + nObject * ( colourVariation/4 ) )
                        ( 255/6 - nObject * ( colourVariation/6 ) )
                        ( 255/2 + nObject * ( colourVariation/2 ) )

    | otherwise = Colour 0 0 0 -- Preto

    where 
        colourVariation = 255 / fromIntegral nObjects

-- Geração das formas geométricas utilizadas em cada caso.

genRects :: Int -> Int -> Int -> [Shape]
genRects c l colourOption =
    [ Rect
    ( Point 
        ( x * ( width + gap ) )
        ( y * ( height + gap ) ) )
    ( width )
    ( height )
    ( getColour colourOption ( c+l ) ( x+y ) )
    | x <- [ 1 .. fromIntegral ( c-1 ) ]
    , y <- [ 1 .. fromIntegral ( l-1 ) ] ]

    where
        width = 50 :: Float
        height = 50 :: Float
        cvar = 255 / fromIntegral (c+l)
        gap = 10 :: Float

genCircles :: Int -> Int -> Int -> [Shape]
genCircles n greaterCircleRadius colourOption =
    [ Circle 
    ( Point
        ( cos ( degreesToRad ( a * angle ) ) * gr + aux )
        ( sin ( degreesToRad ( a * angle ) ) * gr + aux ) )
    ( r )
    ( getColour colourOption n a )
    | a <- [ 0 .. fromIntegral ( n+1 ) ] ]

    where
        gr = fromIntegral greaterCircleRadius
        r = gr / ( fromIntegral n / 2 )
        angle = fromIntegral $ div 360 n
        aux = 1.5 * gr
        cvar = 255 / fromIntegral n

genRectCircles :: Int -> Int -> (Int, Int, Int) -> Float -> [Shape]
genRectCircles c l (cO1, cO2, cO3) r =
    genRectCircles' ( 0 )       ( 0 )      ( r ) ( c ) ( l ) ( cO1 ) ++
    genRectCircles' ( -0.75*r ) ( 0.75*r ) ( r ) ( c ) ( l ) ( cO2 ) ++
    genRectCircles' ( 0.75*r )  ( 0.75*r ) ( r ) ( c ) ( l ) ( cO3 )

genRectCircles' :: Float -> Float -> Float -> Int -> Int -> Int -> [Shape]
genRectCircles' oX oY r c l colourOption =
    [ Circle
    ( Point 
        ( x * ( r + gap ) + oX )
        ( y * ( r + gap ) + oY ) )
    ( r )
    ( getColour colourOption ( c+l ) ( x+y ) )
    | x <- [ 1 .. fromIntegral ( c-1 ) ]
    , y <- [ 1 .. fromIntegral ( l-1 ) ] ]

    where
        gap = 3.5*r

genSinusoids :: Int -> Int -> Int -> [Shape]
genSinusoids nSinusoids nCircles variation =
    concat [ genSinusoid ( 100 * fromIntegral i ) nCircles variation ( i+5 ) | i <- [ 0 .. nSinusoids ] ]

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
    "; mix-blend-mode: screen;'/>"

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
        svgrects = concat $ map svgRects $ genRects 10 10 14
        ( w, h ) = ( 1920, 1080 )

case2 :: IO ()
case2 = do
    writeFile "case2.svg" $ svgstrs
    where
        svgstrs = svgBegin w h ++ svgcircles ++ svgEnd
        svgcircles = concat $ map svgCircles $ genCircles 60 200 16
        ( w, h ) = ( 1920, 1080 )   

case3 :: IO ()
case3 = do
    writeFile "case3.svg" $ svgstrs
    where
        svgstrs = svgBegin w h ++ svgcircles ++ svgEnd
        svgcircles = concat $ map svgCircles $ genRectCircles 10 10 (1, 2, 3) 10
        ( w, h ) = ( 1920, 1080 )
        
case4 :: IO ()
case4 = do
    writeFile "case4.svg" $ svgstrs
    where
        svgstrs = svgBegin w h ++ svgsinusoid ++ svgEnd
        svgsinusoid = concat $ map svgCircles $ genSinusoids 10 90 17850
        ( w, h ) = ( 1920, 1080 )
    