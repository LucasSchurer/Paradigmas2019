import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EnadeUFSMExplorer extends Application {

    private String url = "https://docs.google.com/spreadsheets/d/e/2PACX-1vTO06Jdr3J1kPYoTPRkdUaq8XuslvSD5--FPMht-ilVBT1gExJXDPTiX0P3FsrxV5VKUZJrIUtH1wvN/pub?gid=0&single=true&output=csv";

    public class DataEntry {
        private CourseData element;
        private SimpleStringProperty first;
        private SimpleStringProperty second;
        private SimpleStringProperty third;
        private SimpleStringProperty fourth;
        private SimpleStringProperty fifth;
        private SimpleStringProperty sixth;
        private SimpleStringProperty seventh;
        private SimpleStringProperty eighth;
        private SimpleStringProperty ninth;

        private DataEntry(String a, String b, String c, String d, String e, String f, String g, String h, String i,
                CourseData element) {
            this.first = new SimpleStringProperty(a);
            this.second = new SimpleStringProperty(b);
            this.third = new SimpleStringProperty(c);
            this.fourth = new SimpleStringProperty(d);
            this.fifth = new SimpleStringProperty(e);
            this.sixth = new SimpleStringProperty(f);
            this.seventh = new SimpleStringProperty(g);
            this.eighth = new SimpleStringProperty(h);
            this.ninth = new SimpleStringProperty(i);

            setCourseData(element);
        }

        public void setCourseData(CourseData element) {
            this.element = element;
        }

        public CourseData getCourseData() {
            return this.element;
        }

        public SimpleStringProperty firstProperty() {
            return first;
        }

        public String getFirst() {
            return first.get();
        }

        public void setFirst(String a) {
            first.set(a);
        }

        public SimpleStringProperty secondProperty() {
            return second;
        }

        public String getSecond() {
            return second.get();
        }

        public void setSecond(String a) {
            second.set(a);
        }

        public SimpleStringProperty thirdProperty() {
            return third;
        }

        public String getThird() {
            return third.get();
        }

        public void setThird(String a) {
            third.set(a);
        }

        public SimpleStringProperty fourthProperty() {
            return fourth;
        }

        public String getfourth() {
            return fourth.get();
        }

        public void setfourth(String a) {
            fourth.set(a);
        }

        public SimpleStringProperty fifthProperty() {
            return fifth;
        }

        public String getfifth() {
            return fifth.get();
        }

        public void setfifth(String a) {
            fifth.set(a);
        }

        public SimpleStringProperty sixthProperty() {
            return sixth;
        }

        public String getsixth() {
            return sixth.get();
        }

        public void setsixth(String a) {
            sixth.set(a);
        }

        public SimpleStringProperty seventhProperty() {
            return seventh;
        }

        public String getseventh() {
            return seventh.get();
        }

        public void setseventh(String a) {
            seventh.set(a);
        }

        public SimpleStringProperty eighthProperty() {
            return eighth;
        }

        public String geteighth() {
            return eighth.get();
        }

        public void seteighth(String a) {
            eighth.set(a);
        }

        public SimpleStringProperty ninthProperty() {
            return ninth;
        }

        public String getninth() {
            return ninth.get();
        }

        public void setninth(String a) {
            ninth.set(a);
        }
    }

    private final ObservableList<DataEntry> data = FXCollections.observableArrayList();

    private void setData() {
        try {
            CSVFileHandler csvHandler;

            try {
                csvHandler = new CSVFileHandler("enade.csv", url);
            } catch (IOException e) {
                csvHandler = new CSVFileHandler("enade.csv", url);
            }

            for (int i = 1; i < csvHandler.getCSVData().size(); i++) {
                CourseData element = new CourseData(csvHandler.getCSVData().get(i));
                this.data.add(new DataEntry(element.getYear(), element.getTest(), element.getQuestionType(),
                        element.getQuestionID(), element.getObject(), element.getCourseSuccesses(),
                        element.getRegionSuccesses(), element.getCountrySuccesses(),
                        element.getCountryCourseSuccessesDifference(), element));
            }

        } catch (IOException e) {
            return;
        }
    }

    public void setURL(String url) {
        this.url = url;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    @SuppressWarnings("unchecked")
    public void start(Stage stage) {
        setData();

        // Define as tabelas
        TableView table = new TableView();
        TableColumn firstCol = new TableColumn("Ano");
        TableColumn secondCol = new TableColumn("Prova");
        TableColumn thirdCol = new TableColumn("Tipo Questão");
        TableColumn fourthCol = new TableColumn("ID Questão");
        TableColumn fifthCol = new TableColumn("Objeto");
        TableColumn sixthCol = new TableColumn("Acertos Curso");
        TableColumn seventhCol = new TableColumn("Acertos Região");
        TableColumn eighthCol = new TableColumn("Acertos Brasil");
        TableColumn ninthCol = new TableColumn("Dif.(Curso-Brasil)");

        firstCol.setCellValueFactory(new PropertyValueFactory<DataEntry, String>("first"));
        secondCol.setCellValueFactory(new PropertyValueFactory<DataEntry, String>("second"));
        thirdCol.setCellValueFactory(new PropertyValueFactory<DataEntry, String>("third"));
        fourthCol.setCellValueFactory(new PropertyValueFactory<DataEntry, String>("fourth"));
        fifthCol.setCellValueFactory(new PropertyValueFactory<DataEntry, String>("fifth"));
        sixthCol.setCellValueFactory(new PropertyValueFactory<DataEntry, String>("sixth"));
        seventhCol.setCellValueFactory(new PropertyValueFactory<DataEntry, String>("seventh"));
        eighthCol.setCellValueFactory(new PropertyValueFactory<DataEntry, String>("eighth"));
        ninthCol.setCellValueFactory(new PropertyValueFactory<DataEntry, String>("ninth"));

        table.setItems(data);

        table.getColumns().addAll(firstCol, secondCol, thirdCol, fourthCol, fifthCol, sixthCol, seventhCol, eighthCol,
                ninthCol);

        table.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {

                    DataEntry selectedItem = (DataEntry) table.getSelectionModel().getSelectedItem();
                    CourseData element = selectedItem.getCourseData();

                    Stage infoQuestionStage = new Stage();
                    infoQuestionStage.initModality(Modality.APPLICATION_MODAL);

                    VBox infoQuestionScene = new VBox();

                    Text txt = new Text(element.toString());
                    txt.setWrappingWidth(600);

                    infoQuestionScene.getChildren().add(txt);

                    if (!element.getImage().equals("---")) {
                        try {
                            File fImage = new File("image.jpg");
                            fImage.delete();

                            CSVFileHandler.download(element.getImage(), "image.jpg");

                            ImageView image = new ImageView(new Image("image.jpg", 100, 200, false, false));

                            image.fitWidthProperty().bind(infoQuestionScene.widthProperty());
                            // image.fitHeightProperty().bind(infoQuestionScene.heightProperty());

                            infoQuestionScene.getChildren().add(image);

                        } catch (IOException e) {
                            System.out.println("Unable to download image.");
                        }
                    }

                    infoQuestionStage.setScene(new Scene(infoQuestionScene, 600, 650));
                    infoQuestionStage.show();
                }
            }
        });

        // Criação da MenuBar
        // File -> Reload
        MenuItem menuItemReload = new MenuItem("Reload");
        menuItemReload.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                File file = new File("enade.csv");
                file.delete();
                data.clear();
                setData();

                System.out.println(data.get(2).element.toString());
            }
        });

        // File -> Source
        MenuItem menuItemSource = new MenuItem("Source");
        menuItemSource.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                TextField txtField = new TextField();
                Button changeButton = new Button("Change URL");
                changeButton.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        setURL(txtField.getText());
                    }
                });

                VBox vbox = new VBox();
                Stage stage = new Stage();

                vbox.getChildren().addAll(txtField, changeButton);
                stage.setScene(new Scene(vbox, 300, 100));
                stage.show();
            }
        });

        // File -> Exit
        MenuItem menuItemExit = new MenuItem("Exit");
        menuItemExit.setOnAction(e -> Platform.exit());

        // Help -> About
        MenuItem menuItemAbout = new MenuItem("About");
        menuItemAbout.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Label aboutLbl = new Label("Enade UFSM Explorer\nAuthor: Lucas Schurer");
                VBox vbox = new VBox();
                Stage stage = new Stage();

                vbox.getChildren().add(aboutLbl);
                stage.setScene(new Scene(vbox, 300, 100));
                stage.show();
            }
        });

        // File
        Menu menuFile = new Menu("File");
        menuFile.getItems().addAll(menuItemReload, menuItemSource, menuItemExit);

        // Help
        Menu menuHelp = new Menu("Help");
        menuHelp.getItems().add(menuItemAbout);

        // Finalização da MenuBar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuFile, menuHelp);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(menuBar, table);

        stage.setScene(new Scene(vbox, 800, 600));
        stage.show();
    }
}
