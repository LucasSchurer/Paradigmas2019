import Browser
import Html exposing (..)
import Html.Attributes
import Html.Events
import Svg exposing (..)
import Svg.Attributes exposing (..)

main = 
    Browser.element
      { init = init
      , view = view
      , update = update
      , subscriptions = subscriptions
      }
    
-- Model

type Direction 
    = Left
    | Up
    | Right
    | Down
    | Other

type alias Model = 
    { x   : Int
    , y   : Int
    , mov : Direction
    }

init : () -> (Model, Cmd Msg)
init _ =
    ( Model 0 0 Other
    , Cmd.none)

-- Update

type Msg 
    = Moving Direction
    | Idle


update : Msg -> Model -> (Model, Cmd Msg)
update msg model = 
    case msg of
      Moving direction ->
        case direction of 
          Left ->
            (Model (model.x - 5) model.y Other, Cmd.none)

          Up -> 
            (Model model.x (model.y + 5) Other, Cmd.none)

          Right -> 
            (Model (model.x +5) model.y Other, Cmd.none)

          Down -> 
            (Model model.x (model.y - 5) Other, Cmd.none)

          Other ->
            (model, Cmd.none)

      Idle ->
        (model, Cmd.none)

-- Subscriptions

subscriptions : Model -> Sub Msg
subscriptions model = 
    Sub.none

-- View

view : Model -> Html Msg
view model =    
    drawPlayer model

drawPlayer : Model -> Html Msg
drawPlayer model = 
    svg 
    [ width "800"
    , height "800"
    , viewBox "0 0 800 800"
    ] 
    [ rect [x (String.fromInt model.x), y (String.fromInt model.y), width "100", height "100", rx "15", ry "15"] []
    ]    
