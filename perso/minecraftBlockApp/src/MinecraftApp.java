
// JavaFX imports

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

// Entity imports

import entity.*;

import entity.block.nonsolid.*;
import entity.block.solid.mineral.*;
import entity.block.solid.nonmineral.*;

import entity.tool.combat.sword.*;

import entity.tool.axe.*;
import entity.tool.hoe.*;
import entity.tool.pickaxe.*;

// Java
import java.util.ArrayList;

public class MinecraftApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("resources/minecraftApp.fxml"));

        stage.setScene(new Scene(root, 1280, 720));
        stage.show();
    }

}
