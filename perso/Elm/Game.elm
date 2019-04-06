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
    { x : Int
    , y : Int
    , r : Int
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
        KeyPressed Left ->
            ( { player | x = player.x - 10 }
            , Cmd.none
            )
        
        KeyPressed Up ->
            ( { player | y = player.y - 10 }
            , Cmd.none
            )

        KeyPressed Right ->
            ( { player | x = player.x + 10 }
            , Cmd.none
            )

        KeyPressed Down ->
            ( { player | y = player.y + 10 }
            , Cmd.none
            )

        KeyPressed None ->
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
    svg [ width "800"
        , height "800"
        , viewBox "0 0 800 800"
        ]
        [ circle 
            [ cx ( String.fromInt player.x ) 
            , cy ( String.fromInt player.y )
            , r  ( String.fromInt player.r )  
            ]
            []
        ]
