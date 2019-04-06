import Browser
import Html exposing (..)
import Html.Attributes
import Html.Events
import Svg exposing (..)
import Svg.Attributes exposing (..)
import Keyboard

main = 
    Browser.element
      { init = init
      , view = view
      , update = update
      , subscriptions = subscriptions
      }
    
-- Model

type alias Model = 
    { x   : Int
    , y   : Int
    , mov : Int
    }

init : () -> (Model, Cmd Msg)
init _ =
    ( Model 0 0 0
    , Cmd.none)

-- Update

type Msg 
    = Increment
    | Decrement

update : Msg -> Model -> (Model, Cmd Msg)
update msg model = 
    (model, Cmd.none)


-- Subscriptions

subscriptions : Model -> Sub Msg
subscriptions model = 
    Sub.none

-- View

view : Model -> Html Msg
view model =    
    svg 
    [ width "800"
    , height "800"
    , viewBox "0 0 800 800"
    ] 
    [ rect [x (String.fromInt model.x), y (String.fromInt model.y), width "100", height "100", rx "15", ry "15"] []
    ]