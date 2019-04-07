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

type alias WindowSettings =
    { width : Int
    , height : Int
    , focus : Bool
    }

type alias GameSettings =
    { x : Int
    , y : Int
    , width : Int
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
    , window : WindowSettings
    }

init : () -> ( Model, Cmd Msg )
init _ =
    let
        width = 1920
        height = 1080

    in
    ( Model 
        ( initPlayer 
            ( width // 2 - width // 4 + 30 ) 
            ( 50 ) 
        ) 
        ( initPlayer 
            ( width // 2 + width // 4 - 60 ) 
            ( 50 ) 
        )
        ( initGameSettings width height )
        ( initWindowSettings width height )
    , Cmd.none 
    )

initPlayer : Int -> Int -> Player
initPlayer x y = 
    Player x y 30 60 0

initGameSettings : Int -> Int -> GameSettings
initGameSettings width height =
    GameSettings 
        ( width // 2 - width // 4 ) 
        0 
        ( width // 2 ) 
        ( height // 2 ) 
        Play

initWindowSettings : Int -> Int -> WindowSettings
initWindowSettings width height =
    WindowSettings width height True

-- Update

type Key 
    = Left
    | Up
    | Right
    | Down
    | Space
    | None

type Msg 
    = KeyPressed Key
    | GameState State

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

        "Space" -> 
            KeyPressed Space
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
        [ Svg.Attributes.width ( String.fromInt ( model.window.width - model.window.width // 10) )
        , Svg.Attributes.height ( String.fromInt ( model.window.height - model.window.height // 7 ) )
        , Svg.Attributes.viewBox (
            String.join " " 
                [ "0"
                , "0"
                , ( String.fromInt ( model.window.width - model.window.width // 10 ) )
                , ( String.fromInt ( model.window.height - model.window.height // 7 ) )
                ]
        )
        ]
        [ drawBackground model.game
        , drawPlayer model.player1
        , drawPlayer model.player2
        ]    
        
drawBackground : GameSettings -> Svg.Svg Msg
drawBackground settings = 
    Svg.rect
        [ Svg.Attributes.x ( String.fromInt settings.x ) 
        , Svg.Attributes.y ( String.fromInt settings.y )
        , Svg.Attributes.rx "10"
        , Svg.Attributes.ry "10"
        , Svg.Attributes.width ( String.fromInt settings.width )
        , Svg.Attributes.height ( String.fromInt settings.height )
        ] []

drawPlayer : Player -> Svg.Svg Msg
drawPlayer player =
    Svg.rect
        [ Svg.Attributes.x ( String.fromInt player.x ) 
        , Svg.Attributes.y ( String.fromInt player.y )
        , Svg.Attributes.rx "10"
        , Svg.Attributes.ry "10"
        , Svg.Attributes.width ( String.fromInt player.width )
        , Svg.Attributes.height ( String.fromInt player.height )
        , Svg.Attributes.fill "white"
        ] []
