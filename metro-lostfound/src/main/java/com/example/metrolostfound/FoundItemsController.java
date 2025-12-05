package com.example.metrolostfound;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class FoundItemsController {
    ArrayList<FoundItem> foundItemlist = new ArrayList<>();

    @javafx.fxml.FXML
    private TextField colorFieldFound;
    @javafx.fxml.FXML
    private TextField locationFieldFound;
    @javafx.fxml.FXML
    private TableColumn<FoundItem,String> FoundItemLocationCol;
    @javafx.fxml.FXML
    private TableColumn<FoundItem,String> FoundItemColorCol;
    @javafx.fxml.FXML
    private TableColumn<FoundItem,String> FoundItemDescCol;
    @javafx.fxml.FXML
    private TextField descFieldFound;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TableView FoundItemtable;

    @javafx.fxml.FXML
    public void initialize() {
        FoundItemColorCol.setCellValueFactory(new PropertyValueFactory<>("color"));
        FoundItemLocationCol.setCellValueFactory(new PropertyValueFactory<>("locationFound") );
        FoundItemDescCol.setCellValueFactory(new PropertyValueFactory<>("description"));
    }

    @javafx.fxml.FXML
    public void AddFoundItemButton(ActionEvent actionEvent) {

        String Locationfound = locationFieldFound.getText();
        String color = colorFieldFound.getText();
        String description = descFieldFound.getText();

        FoundItem foundItem = new FoundItem(Locationfound, color,description );

        foundItemlist.add(foundItem);

        statusLabel.setText("Item added");

        FoundItemtable.getItems().clear();
        FoundItemtable.getItems().addAll(foundItemlist);
    }


    @javafx.fxml.FXML
    public void MainMenuButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader Fxmlload = new FXMLLoader(getClass().getResource("LostAndFoundManager.fxml"));
        Scene Lostscene = new Scene(Fxmlload.load());
        Stage stage = new Stage();
        stage.setScene(Lostscene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void GotoLostItemsButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader Fxmlload = new FXMLLoader(getClass().getResource("LostItems.fxml"));
        Scene Lostscene = new Scene(Fxmlload.load());
        Stage stage = new Stage();
        stage.setScene(Lostscene);
        stage.show();
    }
}
