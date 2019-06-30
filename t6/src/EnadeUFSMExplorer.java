import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.stage.Stage;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class EnadeUFSMExplorer extends Application {

    public class DataEntry {
        private SimpleStringProperty first;
        private SimpleStringProperty second;
        private SimpleStringProperty third;
        private SimpleStringProperty fourth;
        private SimpleStringProperty fifth;
        private SimpleStringProperty sixth;
        private SimpleStringProperty seventh;
        private SimpleStringProperty eighth;
        private SimpleStringProperty ninth;

        private DataEntry(String a, String b, String c, String d, String e, String f, String g, String h, String i) {
            this.first = new SimpleStringProperty(a);
            this.second = new SimpleStringProperty(b);
            this.third = new SimpleStringProperty(c);
            this.fourth = new SimpleStringProperty(d);
            this.fifth = new SimpleStringProperty(e);
            this.sixth = new SimpleStringProperty(f);
            this.seventh = new SimpleStringProperty(g);
            this.eighth = new SimpleStringProperty(h);
            this.ninth = new SimpleStringProperty(i);
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

    private final ObservableList<DataEntry> data = FXCollections
            .observableArrayList(new DataEntry("-", "-", "-", "-", "-", "-", "-", "-", "-"));

    private void setData() {
        try {
            CSVFileHandler csvHandler = new CSVFileHandler("enade1.csv");
            this.data.remove(0);

            for (int i = 1; i < csvHandler.getCSVData().size(); i++) {
                CourseData element = new CourseData(csvHandler.getCSVData().get(i));
                this.data.add(new DataEntry(element.getYear(), element.getTest(), element.getQuestionType(),
                        element.getQuestionID(), element.getObject(), element.getCourseSuccesses(),
                        element.getRegionSuccesses(), element.getCountrySuccesses(),
                        element.getCountryCourseSuccessesDifference()));
            }

        } catch (IOException e) {
            return;
        }
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

        VBox vbox = new VBox();
        vbox.getChildren().addAll(table);

        stage.setScene(new Scene(vbox, 800, 400));
        stage.show();
    }
}
