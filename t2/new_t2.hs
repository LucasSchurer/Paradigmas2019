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
