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

public class LostItemController {
    ArrayList<LostItem> LostItemList = new ArrayList<>();

    @javafx.fxml.FXML
    private TextField descFieldLost;
    @javafx.fxml.FXML
    private TableColumn<LostItem,String> LostItemColorCol;
    @javafx.fxml.FXML
    private TableColumn<LostItem,String> LostItemDescCol;
    @javafx.fxml.FXML
    private TableColumn<LostItem,String> LostItemLocationCol;
    @javafx.fxml.FXML
    private TableView LostItemtable;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TextField locationFieldLost;
    @javafx.fxml.FXML
    private TextField colorFieldLost;

    @javafx.fxml.FXML
    public void initialize() {
        LostItemColorCol.setCellValueFactory(new PropertyValueFactory<>("color"));
        LostItemLocationCol.setCellValueFactory(new PropertyValueFactory<>("station"));
        LostItemDescCol.setCellValueFactory(new PropertyValueFactory<>("description"));
    }

    @javafx.fxml.FXML
    public void GotoFoundItemsButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader Fxmlload = new FXMLLoader(getClass().getResource("FoundItems.fxml"));
        Scene Lostscene = new Scene(Fxmlload.load());
        Stage stage = new Stage();
        stage.setScene(Lostscene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void AddLostItemButton(ActionEvent actionEvent) {
        String color = colorFieldLost.getText();
        String Location= locationFieldLost.getText();
        String description = descFieldLost.getText();

        LostItem lostItem = new LostItem(Location,color,description);

        LostItemList.add(lostItem);
        statusLabel.setText("Lost Item Added");


        LostItemtable.getItems().clear();
        LostItemtable.getItems().addAll(LostItemList);
    }

    @javafx.fxml.FXML
    public void MainMenuButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader Fxmlload = new FXMLLoader(getClass().getResource("LostAndFoundManager.fxml"));
        Scene Lostscene = new Scene(Fxmlload.load());
        Stage stage = new Stage();
        stage.setScene(Lostscene);
        stage.show();
    }

}