import java.util.ArrayList;

import java.io.File;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class RandomPickerGUI extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    public static String getStringGivenTextFile(TextFile textFile) {
        ArrayList<String> arrayList = textFile.getFileContent();
        StringBuffer sb = new StringBuffer();

        for (String s : arrayList) {
            s = s + "\n";
            sb.append(s);
        }

        return sb.toString();
    }

    public void start(Stage stage) {
        final String fileName = "teste.txt";

        final RandomPicker randomPicker = new RandomPicker(fileName);

        // TextArea
        String fileText = getStringGivenTextFile(randomPicker.getTextFile());

        final TextArea textArea = new TextArea(fileText);
        textArea.setMinHeight(650);

        // Butttons
        final Button btnShuffle = new Button("Shuffle");
        btnShuffle.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                randomPicker.shuffle();
                String fileTextAux = getStringGivenTextFile(randomPicker.getTextFile());
                textArea.setText(fileTextAux);
            }
        });

        final Button btnNext = new Button("Next");

        // Criação da MenuBar
        // File -> Open
        final FileChooser fileChooser = new FileChooser();

        final MenuItem menuItemOpen = new MenuItem("Open");
        menuItemOpen.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                File file = fileChooser.showOpenDialog(stage);
                if (file != null) {
                    String fileName = file.getName();
                    randomPicker.setTextFile(fileName);

                    String fileTextAux = getStringGivenTextFile(randomPicker.getTextFile());
                    textArea.setText(fileTextAux);
                }
            }
        });

        // File -> Exit
        final MenuItem menuItemExit = new MenuItem("Exit");
        menuItemExit.setOnAction(e -> Platform.exit());

        // Help -> About
        final MenuItem menuItemAbout = new MenuItem("About");

        // File
        final Menu menuFile = new Menu("File");
        menuFile.getItems().addAll(menuItemOpen, menuItemExit);

        // Help
        final Menu menuHelp = new Menu("Help");
        menuHelp.getItems().add(menuItemAbout);

        // Finalização da MenuBar
        final MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuFile, menuHelp);

        // VBox
        final VBox vbox = new VBox();
        vbox.getChildren().addAll(menuBar, textArea, btnShuffle, btnNext);

        stage.setScene(new Scene(vbox, 600, 800));
        stage.show();
    }
}
