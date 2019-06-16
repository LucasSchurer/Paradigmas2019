import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        final String fileName = "/0.txt";

        final RandomPicker randomPicker = new RandomPicker("/0.txt");

        // Label
        final Label randomElementLbl = new Label("I can't shuffle an empty list :(");

        // TextArea
        final TextArea textArea = new TextArea("");
        randomPicker.setStringList(new ArrayList<String>());

        textArea.setMinHeight(650);
        textArea.textProperty().addListener((obs, old, niu) -> {
            String newText = textArea.getText();
            ArrayList<String> newStringList = new ArrayList<String>(Arrays.asList(newText.split("\n")));
            randomPicker.setStringList(newStringList);

            if (!randomPicker.checkStringListEmpty())
                randomElementLbl.setText("You need to shuffle the list in order to see an element.");
        });

        // Butttons
        final Button btnShuffle = new Button("Shuffle");
        final Button btnNext = new Button("Next");

        btnShuffle.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                textArea.setDisable(true);
                btnShuffle.setDisable(true);
                btnNext.setDisable(false);

                randomPicker.shuffle();

                randomElementLbl.setText(randomPicker.getFirstElementStringList());
            }
        });

        btnNext.setDisable(true);
        btnNext.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (randomPicker.checkStringListEmpty()) {
                    btnNext.setDisable(true);
                    btnShuffle.setDisable(false);
                    textArea.setDisable(false);

                    randomPicker.setStringList(new ArrayList<String>(Arrays.asList(textArea.getText().split("\n"))));

                    randomElementLbl.setText("You need to shuffle the list in order to see an element.");

                } else {
                    randomElementLbl.setText(randomPicker.getFirstElementStringList());
                }
            }
        });

        // Criação da MenuBar
        // File -> Open
        final FileChooser fileChooser = new FileChooser();

        final MenuItem menuItemOpen = new MenuItem("Open");
        menuItemOpen.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                File file = fileChooser.showOpenDialog(stage);
                if (file != null) {
                    String fileName = file.getAbsolutePath();
                    textArea.setText(getStringGivenTextFile(new TextFile(fileName)));
                    randomPicker.setStringList(new ArrayList<String>(Arrays.asList(textArea.getText().split("\n"))));
                }
            }
        });

        // File -> Exit
        final MenuItem menuItemExit = new MenuItem("Exit");
        menuItemExit.setOnAction(e -> Platform.exit());

        // Help -> About
        final MenuItem menuItemAbout = new MenuItem("About");
        menuItemAbout.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Label aboutLbl = new Label("Random Picker\nAuthor: Lucas Schurer");
                VBox vbox = new VBox();
                Stage stage = new Stage();

                vbox.getChildren().add(aboutLbl);
                stage.setScene(new Scene(vbox, 300, 100));
                stage.show();
            }
        });

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
        vbox.getChildren().addAll(menuBar, textArea, btnShuffle, btnNext, randomElementLbl);

        stage.setScene(new Scene(vbox, 600, 800));
        stage.show();
    }
}
