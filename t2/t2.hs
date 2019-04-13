import Text.Printf

type Point =
    ( Float, Float )

type Rect =
    ( Point, Float, Float )

type Circle =
    ( Point, Float )

-- Geração das formas geométricas utilizadas em cada caso.

genRects :: [Rect]
genRects =
    [ ( ( 10, 10 ), 10, 10 )
    , ( ( 30, 10 ), 10, 10 )
    , ( ( 50, 10 ), 10, 10 )
    , ( ( 70, 10 ), 10, 10 ) ]



-- Geração das strings contendo as figuras em SVG

svgRects :: Rect -> String
svgRects ( ( x, y ), w, h ) =
    printf "<rect x = '%.2f' y = '%.2f' width = '%.2f' height = '%.2f' style = 'fill:rgb(0, 0, 255)'/>" x y w h



-- Geração das strings contendo os elementos básicos em SVG

svgBegin :: Float -> Float -> String
svgBegin w h =
    printf "<svg width='%.2f' height='%.2f' xmlns='http://www.w3.org/2000/svg'>\n" w h


svgEnd :: String
svgEnd =
    "</svg>"


case1 :: IO ()
case1 = do
    writeFile "case1.svg" $ svgstrs
    where
        svgstrs = svgBegin w h ++ svgrects ++ svgEnd
        svgrects = concat $ map svgRects genRects
        (w, h) = (1920, 1080)


        