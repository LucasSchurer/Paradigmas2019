import Text.Printf

type Point =
    ( Float, Float )

type Rect =
    ( Point, Float, Float )

type Circle =
    ( Point, Float )

-- Funções matemáticas auxiliares

radToDegrees :: Float -> Float
radToDegrees rad =
    rad * ( 180/pi )

degreesToRad :: Float -> Float
degreesToRad degrees =
    degrees * ( pi/180 )

-- Geração das formas geométricas utilizadas em cada caso.

genRects :: Int -> Int -> [Rect]
genRects c l =
    [ ( ( x * ( width + gap ), y * ( height + gap ) ), width, height ) | x <- [ 1 .. fromIntegral (c-1) ], y <- [ 1 .. fromIntegral (l-1) ] ] 
    
    where 
        (width, height) = (50, 50)
        gap = 10

genCircles :: Int -> [Circle]
genCircles n r1=
    [ ( ( ( cos ( degreesToRad ( a * fromIntegral ( div 360 n ) ) ) * r1 + 2*r1), ( sin ( degreesToRad ( a * fromIntegral ( div 360 n ) ) ) * r1 + 2*r1 ) ), r) | a <- [ 0 .. fromIntegral (n+1) ] ]

    where
        r = 10
        angle = fromIntegral $ div 360 n

genCircles' :: [(Circle, Circle, Circle)]
genCircles' =
    [ ( ( ( 100, 125 ), 50 ), ( ( 125, 100 ), 50 ), ( ( 100, 125 ), 50 ) ) ]

-- Geração das strings contendo as figuras em SVG

svgRects :: Rect -> String
svgRects ( ( x, y ), w, h ) =
    printf "<rect x = '%.2f' y = '%.2f' width = '%.2f' height = '%.2f' style = 'fill:rgb(0, 0, 255)'/>" x y w h

svgCircles :: Circle -> String
svgCircles ( ( x, y ), r ) =
    printf "<circle cx = '%.2f' cy = '%.2f' r = '%.2f' style = 'fill:rgb(0, 0, 255)'/>" x y r   

-- Geração das strings contendo os elementos básicos em SVG

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
        (w, h) = (1920, 1080)


case2 :: IO ()
case2 = do
    writeFile "case2.svg" $ svgstrs
    where
        svgstrs = svgBegin w h ++ svgcircles ++ svgEnd
        svgcircles = concat $ map svgCircles $ genCircles 12
        (w, h) = (1920, 1080)


{--case3 :: IO ()
case3 = do
    writeFile "case3.svg" $ svgstrs
    where
        svgstrs = svgBegin w h ++ svgcircles' ++ svgEnd
        svgcircles' = concat $ map svgCircles genCircles
        (w, h) = (1920, 1080)
--}

case4 :: IO ()
case4 = do
    writeFile "case4.svg" $ svgstrs
    where
        svgstrs = svgBegin w h ++ svgEnd
        (w, h) = (1920, 1080)

        