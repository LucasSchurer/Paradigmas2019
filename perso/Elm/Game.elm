import Browser
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

subscriptions : Player -> Sub Msg
subscriptions _ =
    Sub.none


-- View

view : Player -> Html.Html Msg
view _ = 
    div [] []
    