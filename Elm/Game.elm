import Browser
import Html exposing (..)
import Html.Attributes exposing (src, width, height)
import Html.Events


main = 
    Browser.sandbox { init = init, update = update, view = view}

-- Inputs 

type alias Movement =
    { left  : Bool
    , up    : Bool
    , right : Bool
    , down  : Bool
    }

type alias Input =
    { space : Bool
    , movement : Movement
    }


-- Model

type alias Model = 
    { gameWidth : Int
    , gameHeight : Int
    }


init : Model
init = 
    Model 800 400
    


-- Update

type Msg = Play | Pause

update : Msg -> Model -> Model
update msg model = 
    case msg of 
        Play ->
          model

        Pause ->
          model


-- View

view : Model -> Html.Html Msg
view model = 
        img [ src "src/image1.png", width 1000, height 800] []