class GameController {
  private int state;

  GameController() {
    setState(0);
  }

  public void setState(int state) {
    this.state = state;
  }

  public int getState() {
    return this.state;
  }
}
