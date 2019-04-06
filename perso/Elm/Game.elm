import Browser
import Browser.Events
import Json.Decode
import Html exposing (div)

-- Main
main = 
    Browser.element
        { init = init
        , view = view
        , update = update
        , subscriptions = subscriptions
        }

-- Model

type alias Player =    
    Int

init : () -> ( Player, Cmd Msg )
init _ =
    ( 0
    , Cmd.none 
    )

-- Update

type Direction 
    = Left
    | Up
    | Right
    | Down
    | None

type Msg 
    = KeyPressed Direction

update : Msg -> Player -> ( Player, Cmd Msg )
update msg player = 
    case msg of
        KeyPressed _ ->
            ( player
            , Cmd.none
            )

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

subscriptions : Player -> Sub Msg
subscriptions _ =
    Browser.Events.onKeyDown keyDecoder

-- View

view : Player -> Html.Html Msg
view _ = 
    div [] []
    