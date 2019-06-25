class Pong {
  public static void main(String[] args) {
    String player1 = "p1";
    String player2 = "p2";

    GameController gameController = new GameController();
    Ball ball = new Ball("p1");

    gameController.setState(1);

    Player p1 = new Player(ball, player1, gameController.getState());
    Player p2 = new Player(ball, player2, gameController.getState());

    p1.setName(player1);
    p2.setName(player2);

    p1.setMate(p2);
    p2.setMate(p1);

    p1.start();
    p2.start();

    try {
      p1.join();
      p2.join();
    } catch (InterruptedException e) {
      System.out.println("Error");
      return;
    }
  }
}
