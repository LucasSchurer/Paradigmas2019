import Browser
import Browser.Events
import Json.Decode
import Svg
import Svg.Attributes

-- Main
main = 
    Browser.element
        { init = init
        , view = view
        , update = update
        , subscriptions = subscriptions
        }

-- Model

type State 
    = Play
    | Pause

type alias GameSettings =
    { width : Int
    , height : Int
    , state : State
    }

type alias Player =    
    { x : Int
    , y : Int
    , width : Int
    , height : Int
    , score : Int
    }

type alias Model = 
    { player1 : Player
    , player2 : Player
    , game : GameSettings
    }

init : () -> ( Model, Cmd Msg )
init _ =
    let
        width = 600
        height = 400

    in
    ( Model 
        ( initPlayer 
            ( width//2 + 10 ) 
            ( height//2 + 10 ) 
        ) 
        ( initPlayer 
            ( width//2 + 10 ) 
            ( height//2 + 10 ) 
        )
        ( initGameSettings width height )
    , Cmd.none 
    )

initPlayer : Int -> Int -> Player
initPlayer x y = 
    Player x y 0 0 0

initGameSettings : Int -> Int -> GameSettings
initGameSettings width height =
    GameSettings width height Play

-- Update

type Direction 
    = Left
    | Up
    | Right
    | Down
    | None

type Msg 
    = KeyPressed Direction

update : Msg -> Model -> ( Model, Cmd Msg )
update msg model = 
    ( model, Cmd.none )
    

-- Subscriptions

keyDecoder : Json.Decode.Decoder Msg
keyDecoder = 
    Json.Decode.map toDirection (Json.Decode.field "key" Json.Decode.string)

toDirection : String -> Msg
toDirection string = 
    case string of
        "ArrowLeft" -> 
            KeyPressed Left
        
        "ArrowUp" ->
            KeyPressed Up
        
        "ArrowRight" ->
            KeyPressed Right

        "ArrowDown" ->
            KeyPressed Down

        _ -> 
            KeyPressed None

subscriptions : Model -> Sub Msg
subscriptions _ =
    Sub.batch 
        [ Browser.Events.onKeyDown keyDecoder
        ]

-- View

view : Model -> Svg.Svg Msg
view model = 
    Svg.svg 
        [ Svg.Attributes.width "800"
        , Svg.Attributes.height "800"
        , Svg.Attributes.viewBox "0 0 800 800"
        ]
        [ drawBackground
        ]    
        
drawBackground : Svg.Svg Msg
drawBackground = 
    Svg.rect
        [ Svg.Attributes.x "10" 
        , Svg.Attributes.y "10"
        , Svg.Attributes.rx "10"
        , Svg.Attributes.ry "10"
        , Svg.Attributes.width "400"
        , Svg.Attributes.height "600"
        ] []
