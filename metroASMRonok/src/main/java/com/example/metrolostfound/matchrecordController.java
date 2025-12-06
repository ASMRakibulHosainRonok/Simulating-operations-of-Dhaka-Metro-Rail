package com.example.metrolostfound;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

public class matchrecordController {

    @FXML
    private TableView<LostItem> lostTable;

    @FXML
    private TableView<FoundItem> foundTable;

    @FXML
    private void checkMatch() {

        LostItem selectedLost = lostTable.getSelectionModel().getSelectedItem();
        FoundItem selectedFound = foundTable.getSelectionModel().getSelectedItem();

    }


    public void SearchButton(ActionEvent actionEvent) {

    }
}

