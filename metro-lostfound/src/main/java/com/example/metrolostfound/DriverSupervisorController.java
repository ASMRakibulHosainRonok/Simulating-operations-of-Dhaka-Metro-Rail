package com.example.metrolostfound;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class DriverSupervisorController {
    ArrayList<DriverSupervisor> DriverList = new ArrayList();

    @javafx.fxml.FXML
    private TableColumn<DriverSupervisor,String> CarNumberCol;
    @javafx.fxml.FXML
    private TableColumn<DriverSupervisor,String> DriverNameCol;
    @javafx.fxml.FXML
    private TableColumn<DriverSupervisor,String> DriverContactCol;
    @javafx.fxml.FXML
    private TextField CarNumberField;
    @javafx.fxml.FXML
    private TextField DriverNameField;
    @javafx.fxml.FXML
    private TextField DriverContactField;
    @javafx.fxml.FXML
    private TableView DrivereTable;

    @javafx.fxml.FXML
    public void initialize() {
        DriverContactCol.setCellValueFactory(new PropertyValueFactory<>("contactInfo"));
        DriverNameCol.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        CarNumberCol.setCellValueFactory(new PropertyValueFactory<>("carNumber"));
    }

    @javafx.fxml.FXML
    public void AddRecordButton(ActionEvent actionEvent) {
        String driverName = DriverNameField.getText();
        String contactInfo = DriverContactField.getText();
        String carNumber = CarNumberField.getText();

        DriverSupervisor Driver = new DriverSupervisor(driverName,contactInfo,carNumber);

        DriverList.add(Driver);

        DrivereTable.getItems().addAll(DriverList);
    }
}