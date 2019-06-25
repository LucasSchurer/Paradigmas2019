class Point {
  private float x;
  private float y;

  Point(float x, float y) {
    setPoint(x, y);
  }

  public void setX(float x) {
    this.x = x;
  }

  public void setY(float y) {
    this.y = y;
  }

  public void setPoint(float x, float y) {
    setX(x);
    setY(y);
  }

  public float getX() {
    return this.x;
  }

  public float getY() {
    return this.y;
  }

  public Point getPoint() {
    return this;
  }

}
