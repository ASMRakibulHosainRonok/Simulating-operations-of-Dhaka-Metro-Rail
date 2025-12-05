package csc305.metrorailabdullah.Passenger;

import csc305.metrorailabdullah.AppendableObjectOutputStream;
import csc305.metrorailabdullah.ModelClasses.History;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class SeeHistoryViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> routeComboBox;
    @javafx.fxml.FXML
    private DatePicker journeyToDatePicker;
    @javafx.fxml.FXML
    private DatePicker purchaseFromDatePicker;
    @javafx.fxml.FXML
    private DatePicker journeyFromDatePicker;
    @javafx.fxml.FXML
    private TextField faresTextField;
    @javafx.fxml.FXML
    private TableColumn<History, String> routeTableColumn;
    @javafx.fxml.FXML
    private TableColumn<History, LocalDate> journeyDateTableColumn;
    @javafx.fxml.FXML
    private DatePicker purchaseToDatePicker;
    @javafx.fxml.FXML
    private TableColumn<History, String> ticketIdTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> paymentMethodComboBox;
    @javafx.fxml.FXML
    private TableColumn<History, Float> fareTableColumn;
    @javafx.fxml.FXML
    private TableColumn<History, LocalDate> purchaseDateTableColumn;
    @javafx.fxml.FXML
    private TableView<History> historyTableView;
    @javafx.fxml.FXML
    private TableColumn<History, String> paymentTableColumn;
    @javafx.fxml.FXML
    private TableColumn<History, String> passengerIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn<History, String> historyIdTableColumn;
    private ObservableList<History> historyList;
    private ObservableList<History> filteredHistoryList;

    @javafx.fxml.FXML
    public void initialize() {
        historyList = FXCollections.observableArrayList();
        filteredHistoryList = FXCollections.observableArrayList();
        paymentMethodComboBox.getItems().addAll("Cash", "Credit Card");
        routeComboBox.getItems().addAll("A", "B", "C", "D", "E", "F", "G", "H");

        historyIdTableColumn.setCellValueFactory(new PropertyValueFactory<History, String>("historyId"));
        ticketIdTableColumn.setCellValueFactory(new PropertyValueFactory<History, String>("id"));
        passengerIdTableColumn.setCellValueFactory(new  PropertyValueFactory<History, String>("passengerId"));
        routeTableColumn.setCellValueFactory(new PropertyValueFactory<History, String>("route"));
        journeyDateTableColumn.setCellValueFactory(new PropertyValueFactory<History, LocalDate>("journeyDate"));
        fareTableColumn.setCellValueFactory(new PropertyValueFactory<History, Float>("fares"));
        paymentTableColumn.setCellValueFactory(new PropertyValueFactory<History, String>("paymentMethod"));
        purchaseDateTableColumn.setCellValueFactory(new PropertyValueFactory<History, LocalDate>("purchaseDate"));
    }

    @javafx.fxml.FXML
    public void downloadButtonOnAction(ActionEvent actionEvent) {
        File historyFile = new File("Travel History.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if(historyFile.exists()) {
                fos = new FileOutputStream(historyFile, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(historyFile);
                oos = new ObjectOutputStream(fos);
            }
            for(History h: historyList) {
                oos.writeObject(h);
            }
            oos.close();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void logsButtonOnAction(ActionEvent actionEvent) {
        filteredHistoryList.clear();
        historyTableView.getItems().clear();
        float fares = Float.parseFloat(faresTextField.getText());
        String paymentMethod = paymentMethodComboBox.getValue();
        LocalDate fromDate = purchaseFromDatePicker.getValue();
        LocalDate toDate = purchaseToDatePicker.getValue();
        for(History h: historyList) {
            if((h.getPaymentMethod().equals(paymentMethod) && h.getFares() >= fares) && ((h.getPurchaseDate().isEqual(fromDate) || h.getPurchaseDate().isAfter(fromDate)) && (h.getPurchaseDate().isBefore(toDate) || h.getPurchaseDate().isEqual(toDate)))) {
                filteredHistoryList.add(h);
            }
        }
        historyTableView.setItems(filteredHistoryList);
        faresTextField.clear();
        paymentMethodComboBox.setValue(null);
        purchaseFromDatePicker.setValue(null);
        purchaseFromDatePicker.setValue(null);
    }

    @javafx.fxml.FXML
    public void journeysButtonOnAction(ActionEvent actionEvent) {
        filteredHistoryList.clear();
        historyTableView.getItems().clear();
        String route = routeComboBox.getValue();
        LocalDate fromDate = journeyFromDatePicker.getValue();
        LocalDate toDate = journeyToDatePicker.getValue();
        for(History h: historyList) {
            if(h.getRoute().equals(route) && ((h.getJourneyDate().isEqual(fromDate) || h.getJourneyDate().isAfter(fromDate)) && (h.getJourneyDate().isBefore(toDate) || h.getJourneyDate().isEqual(toDate)))) {
                filteredHistoryList.add(h);
            }
        }
        historyTableView.setItems(filteredHistoryList);
        routeComboBox.setValue(null);
        journeyFromDatePicker.setValue(null);
        journeyToDatePicker.setValue(null);
    }

    @javafx.fxml.FXML
    public void resetButtonOnAction(ActionEvent actionEvent) {
        historyTableView.getItems().clear();
        historyTableView.setItems(historyList);
    }
}