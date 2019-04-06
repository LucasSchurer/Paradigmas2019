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

type alias Player = 
    { x     : Float
    , y     : Float
    , speed : Float
    }

type alias Model = 
    { gameWidth     : Int
    , gameHeight    : Int
    , snake         : Player
    }


init : Model
init = 
    let 
      gameWidth = 800
      gameHeight = 400
      snake = Player 5.0 5.0 1.0
    
    in
    Model gameWidth gameHeight snake
    


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
        img [ src "src/img1.png", width 1000, height 800] []