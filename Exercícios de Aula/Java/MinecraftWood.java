import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class MinecraftWood extends Application {
  private int pos = 0;

  public static void main(String[] args) {
    Application.launch(args);
  }

  public ArrayList<Image> getImages() {
    ArrayList<Image> img = new ArrayList<Image>();
    img.add(new Image("img/acacia.png"));
    img.add(new Image("img/carvalho.png"));
    img.add(new Image("img/carvalhoescuro.png"));
    img.add(new Image("img/eucalipto.png"));
    img.add(new Image("img/pinheiro.png"));
    img.add(new Image("img/selva.png"));
    img.add(new Image("img/steve.jpg"));

    return img;
  }

  public Image getNextImage(ArrayList<Image> list) {
    int aux;

    if (pos == list.size() - 1)
      aux = 0;
    else
      aux = pos + 1;

    this.pos = aux;

    Image image = list.get(aux);
    return image;
  }

  public Image getPreviousImage(ArrayList<Image> list) {
    int aux;

    if (pos == 0)
      aux = list.size() - 1;
    else
      aux = pos - 1;

    this.pos = aux;

    Image image = list.get(aux);
    return image;
  }

  public void start(Stage stage) {
    ArrayList<Image> imgs = getImages();
    Image image = imgs.get(0);
    ImageView imageView = new ImageView(image);

    Button btn1 = new Button("<");
    btn1.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
        imageView.setImage(getPreviousImage(imgs));
      }
    });

    Button btn2 = new Button(">");
    btn2.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
        imageView.setImage(getNextImage(imgs));
      }
    });

    BorderPane border = new BorderPane();
    border.setAlignment(btn1, Pos.CENTER);
    border.setLeft(btn1);
    border.setAlignment(btn2, Pos.CENTER);
    border.setRight(btn2);
    border.setCenter(imageView);

    stage.setScene(new Scene(border, 800, 600));
    stage.show();
  }
}
