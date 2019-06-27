import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

class StoneFX extends Stone {
    private Image image;

    StoneFX() {
        setImage();
    }

    public void setImage() {
        this.image = new Image("../img/3d/stone.png");
    }

    public Image getImage() {
        return this.image;
    }

}