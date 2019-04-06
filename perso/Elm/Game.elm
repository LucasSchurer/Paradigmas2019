import Browser
import Browser.Events
import Json.Decode
import Html
import Svg exposing (svg, circle)
import Svg.Attributes exposing (cx, cy, r, width, height, viewBox)


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
    { x : Float
    , y : Float
    , r : Float
    }

init : () -> ( Player, Cmd Msg )
init _ =
    ( Player 20 20 10
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
view player = 
    drawPlayer player
    

drawPlayer : Player -> Html.Html Msg
drawPlayer player =
    svg []
        [ circle 
            [ cx ( String.fromFloat player.x ) 
            , cy ( String.fromFloat player.y )
            , r  ( String.fromFloat player.r )  
            ]
            []
        ]
