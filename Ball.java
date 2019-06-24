class Ball {
  private String turn;

  Ball(String turn) {
    setTurn(turn);
  }

  public synchronized void setTurn(String turn) {
    this.turn = turn;
    this.notifyAll();
  }

  public String getTurn() {
    return this.turn;
  }

  public synchronized void waitTurn(String turn) {
    while (!this.turn.equals(turn)) {
      try {
        this.wait();
      } catch (InterruptedException e) {}
    }
  }
}
