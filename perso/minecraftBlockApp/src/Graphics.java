package entity;

import javafx.scene.image.Image;

abstract class Graphics {
    private Image image;

    public void setImage(String path) {
        this.image = new Image(path, 200, 200, false, false);
    }

    public Image getImage() {
        return this.image;
    }
}