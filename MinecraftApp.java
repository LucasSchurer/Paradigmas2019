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

public class MinecraftApp extends Application {

  public class DataEntry {
    private SimpleStringProperty first;
    private SimpleStringProperty second;
    private SimpleStringProperty third;

    private DataEntry(String a, String b, String c)
    {
      this.first = new SimpleStringProperty(a);
      this.second = new SimpleStringProperty(b);
      this.third = new SimpleStringProperty(c);
    }

    public SimpleStringProperty firstProperty()
    {
      return first;
    }

    public String getFirst()
    {
      return first.get();
    }

    public void setFirst(String a)
    {
      first.set(a);
    }

    public SimpleStringProperty secondProperty()
    {
      return second;
    }

    public String getSecond()
    {
      return second.get();
    }

    public void setSecond(String a)
    {
      second.set(a);
    }

    public SimpleStringProperty thirdProperty()
    {
      return third;
    }

    public String getThird()
    {
      return third.get();
    }

    public void setThird(String a)
    {
      third.set(a);
    }

  }

  private final ObservableList<DataEntry> data =
    FXCollections.observableArrayList(
      new DataEntry("Madeira", "Não", "10")
    );

  public static void main(String[] args)
  {
    Application.launch(args);
  }

  public void start(Stage stage)
  {

    // Define as tabelas
    TableView table = new TableView();
    TableColumn fstCol = new TableColumn("Nome");
    TableColumn sndCol = new TableColumn("Transparência");
    TableColumn trdCol = new TableColumn("Resistência a Explosão");

    fstCol.setCellValueFactory(
      new PropertyValueFactory<DataEntry, String>("first"));

    sndCol.setCellValueFactory(
      new PropertyValueFactory<DataEntry, String>("second"));

    trdCol.setCellValueFactory(
      new PropertyValueFactory<DataEntry, String>("third"));

    table.setItems(data);
    table.getColumns().addAll(fstCol, sndCol, trdCol);


    TextField nameTxtFld = new TextField();
    TextField transparencyTxtFld = new TextField();
    TextField resistanceTxtFld = new TextField();

    Button btnAdd = new Button("Adicionar bloco");
    btnAdd.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
        data.add(new DataEntry(nameTxtFld.getText(), transparencyTxtFld.getText(), resistanceTxtFld.getText()));
      }
    });

    Button btnDel = new Button("Remover bloco");
    btnDel.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
        int selectedIndex =
          table.getSelectionModel().getSelectedIndex();

        data.remove(selectedIndex);
      }
    });

    Button btnModify = new Button("Modificar bloco");
    btnModify.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {

        DataEntry selectedItem = (DataEntry) table.getSelectionModel().getSelectedItem();

        selectedItem.setFirst(nameTxtFld.getText());
        selectedItem.setSecond(transparencyTxtFld.getText());
        selectedItem.setThird(resistanceTxtFld.getText());

      }
    });

    VBox vbox = new VBox();
    vbox.getChildren().addAll(table, nameTxtFld, transparencyTxtFld, resistanceTxtFld, btnAdd, btnDel, btnModify);


    stage.setScene(new Scene(vbox, 800, 400));
    stage.show();
  }




}
