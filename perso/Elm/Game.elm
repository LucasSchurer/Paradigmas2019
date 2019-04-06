import Browser
import Html exposing (..)
import Html.Attributes exposing (src, width, height)
import Html.Events


main = 
    Browser.sandbox { init = defaultGame, update = updateGame, view = view}

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

type State = Play | Pause

type alias Background = 
    { gameWidth     : Int
    , gameHeight    : Int
    }

type alias Player = 
    { x         : Float
    , y         : Float
    , speed     : Float
    , direction : Int
    }

type alias Point =
    { x : Float
    , y : Float
    }

type alias Game = 
    { state         : State
    , background    : Background
    , snake         : Player
    , fruit         : Point
    , score         : Int
    }


defaultGame : Game
defaultGame = 
    let 
      state = Play
      background = Background 800 600
      snake = Player 5.0 5.0 1.0 0
      fruit = Point 10.0 10.0
      score = 0
    
    in
    Game state background snake fruit score
    


-- Update

updateGame : Input -> Game -> Game
updateGame input game = 
    case input of 
        space ->
          game
        
-- View

view : Game -> Html Input
view game = 
        img [ src "src/img1.png", width 1000, height 800] []