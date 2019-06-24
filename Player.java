class Player extends Thread {
  private int gameState;
  private Ball ball;
  private Player mate;
  private String player;

  Player(Ball ball, String player, int gameState) {
    setBall(ball);
    setPlayer(player);
    setGameState(gameState);
  }

  public void setGameState(int gameState) {
    this.gameState = gameState;
  }

  public void setBall(Ball ball) {
    this.ball = ball;
  }

  public void setMate(Player mate) {
    this.mate = mate;
  }

  public void setPlayer(String player) {
    this.player = player;
  }

  public int getGameState() {
    return this.gameState;
  }

  public Ball getBall() {
    return this.ball;
  }

  public Player getMate() {
    return this.mate;
  }

  public String getPlayer() {
    return this.player;
  }

  public void run() {
    while (gameState == 1) {
      try {
        this.ball.waitTurn(this.getPlayer());
        Thread.sleep(1000);
        this.ball.setTurn(this.mate.getPlayer());
        System.out.println(getPlayer());
      } catch (InterruptedException e) {}
    }
  }
}
