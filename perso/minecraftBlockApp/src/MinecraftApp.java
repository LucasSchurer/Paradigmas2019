import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.stage.Stage;

public class MinecraftApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage stage) {
        // StoneFX stone = new StoneFX();
        ImageView imageView = new ImageView(new Image("stone.png"));
        Button b1 = new Button("me ajuda");

        BorderPane bPane = new BorderPane();
        bPane.setCenter(imageView);
        bPane.setRight(b1);

        stage.setScene(new Scene(bPane, 800, 400));
        stage.show();
    }
}
