import java.util.ArrayList;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.stage.Stage;

public class MinecraftApp extends Application {
    ArrayList<Block> availableBlocks;
    ArrayList<Tool> availableTools;

    public void setAvailableBlocks() {
        ArrayList<Block> blocks = new ArrayList<Block>();

        for (int i = 0; i < 30; i++) {
            blocks.add(Controller.getBlock(i));
        }

        this.availableBlocks = blocks;
    }

    public void setAvailableTools() {
        ArrayList<Tool> tools = new ArrayList<Tool>();

        for (int i = 270; i < 280; i++) {
            tools.add(Controller.getTool(i));
        }

        this.availableTools = tools;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage stage) {
        this.setAvailableBlocks();
        this.setAvailableTools();

        Block selectedBlock;
        Tool selectedTool;

        selectedBlock = this.availableBlocks.get(2);
        selectedTool = this.availableTools.get(0);

        Button toolButton = new Button("",
                new ImageView(new Image("file:../img/2d/diamond_pickaxe.png", 50, 50, false, false)));

        Button infoButton = new Button("", new ImageView(new Image("file:../img/info.png", 50, 50, false, false)));

        toolButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                VBox vbox = new VBox();
                Stage stage = new Stage();

                stage.setScene(new Scene(vbox, 400, 400));
                stage.show();
            }
        });

        BorderPane bPane = new BorderPane();

        toolButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                Label lbl = new Label("teste");
                bPane.setLeft(lbl);
            }
        });

        toolButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                bPane.setLeft(infoButton);
            }
        });

        ImageView imageView = new ImageView(selectedTool.getImage());

        System.out.println(selectedTool.getName());

        bPane.setCenter(imageView);
        bPane.setRight(toolButton);
        bPane.setLeft(infoButton);

        stage.setScene(new Scene(bPane, 800, 600));
        stage.show();
    }
}
