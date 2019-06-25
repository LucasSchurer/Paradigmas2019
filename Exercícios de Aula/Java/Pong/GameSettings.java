class GameSettings {
  class Resolution {
    private float width;
    private float height;

    Resolution(float width, float height) {
      setResolution(width, height);
    }

    public void setResolution(float width, float height) {
      setWidth(width);
      setHeight(height);
    }

    public void setWidth(float width) {
      this.width = width;
    }

    public void setHeight(float height) {
      this.height = height;
    }

    public Resolution getResolution() {
      return this;
    }

    public float getWidth() {
      return this.width;
    }

    public float getHeight() {
      return this.height;
    }
  }

  private Resolution mainScreenRes;
  private float scale;
  private int fps;

  GameSettings() {

  }

  public void setMainScreenRes() {
    mainScreenRes = new Resolution(1280, 720);
  }

  public void setScale() {
    this.scale =
      ( this.mainScreenRes.getWidth() + this.mainScreenRes.getHeight() ) /
      ( 1280 + 720 );
  }

  public void setFPS(int fps) {
    this.fps = fps;
  }

  public Resolution getMainScreenRes() {
    return this.mainScreenRes;
  }

  public float getScale() {
    return this.scale;
  }

  public int getFPS() {
    return this.fps;
  }
}
