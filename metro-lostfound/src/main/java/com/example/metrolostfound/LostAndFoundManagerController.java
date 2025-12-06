package com.example.metrolostfound;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LostAndFoundManagerController {

    private static LostAndFoundManagerController instance;

    private List<LostItem> lostItems = new ArrayList<>();
    private List<FoundItem> foundItems = new ArrayList<>();

    public LostAndFoundManagerController() {}

    public static LostAndFoundManagerController getInstance() {
        if (instance == null) {
            instance = new LostAndFoundManagerController();
        }
        return instance;
    }

    public void addLostItem(LostItem item) {
        lostItems.add(item);
    }

    public List<LostItem> getLostItems() {
        return lostItems;
    }

    public void addFoundItem(FoundItem item) {
        foundItems.add(item);
    }

    public List<FoundItem> getFoundItems() {
        return foundItems;
    }

    @FXML
    public void MatchRecordButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader Fxmlload = new FXMLLoader(getClass().getResource("match-record.fxml"));
        Scene Matchscene = new Scene(Fxmlload.load());
        Stage stage = new Stage();
        stage.setScene(Matchscene);
        stage.show();
        //Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

    }

    @FXML
    public void RegisterLostitemButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader Fxmlload = new FXMLLoader(getClass().getResource("LostItems.fxml"));
        Scene Lostscene = new Scene(Fxmlload.load());
        Stage stage = new Stage();
        stage.setScene(Lostscene);
        stage.show();


    }

    @FXML
    public void RegisterFounditemButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader Fxmlload = new FXMLLoader(getClass().getResource("FoundItems.fxml"));
        Scene Lostscene = new Scene(Fxmlload.load());
        Stage stage = new Stage();
        stage.setScene(Lostscene);
        stage.show();
    }
}

