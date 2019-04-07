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
            if ( player.x - 10 < 20 ) then 
                ( player
                , Cmd.none 
                )
            else 
                ( { player | x = player.x - 10 }
                , Cmd.none
                )
        
        KeyPressed Up ->
            if ( player.y - 10 < 20 ) then 
                ( player
                , Cmd.none 
                )
            else 
                ( { player | y = player.y - 10 }
                , Cmd.none
                )

        KeyPressed Right ->
            if ( player.x + 10 > 400 ) then 
                ( player
                , Cmd.none 
                )
            else 
                ( { player | x = player.x + 10 }
                , Cmd.none
                )

        KeyPressed Down ->
            if ( player.y + 10 > 600 ) then 
                ( player
                , Cmd.none 
                )
            else 
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
    Sub.batch 
        [ Browser.Events.onKeyDown keyDecoder
        ]

-- View

view : Player -> Svg.Svg Msg
view player = 
    Svg.svg 
        [ Svg.Attributes.width "800"
        , Svg.Attributes.height "800"
        , Svg.Attributes.viewBox "0 0 800 800"
        ]
        [ drawBackground
        , drawPlayer player
        ]    
        
    

drawPlayer : Player -> Svg.Svg Msg
drawPlayer player =
     Svg.circle 
        [ Svg.Attributes.cx ( String.fromInt player.x ) 
        , Svg.Attributes.cy ( String.fromInt player.y )
        , Svg.Attributes.r  ( String.fromInt player.r )
        , Svg.Attributes.fill "red"   
        ]
        []

drawBackground : Svg.Svg Msg
drawBackground = 
    Svg.rect
        [ Svg.Attributes.x "10" 
        , Svg.Attributes.y "10"
        , Svg.Attributes.rx "10"
        , Svg.Attributes.ry "10"
        , Svg.Attributes.width "400"
        , Svg.Attributes.height "600"
        ] []
