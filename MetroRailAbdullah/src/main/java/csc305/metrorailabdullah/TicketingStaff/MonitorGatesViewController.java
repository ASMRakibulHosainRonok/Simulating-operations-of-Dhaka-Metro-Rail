package csc305.metrorailabdullah.TicketingStaff;

import csc305.metrorailabdullah.AppendableObjectOutputStream;
import csc305.metrorailabdullah.ModelClasses.Gate;
import csc305.metrorailabdullah.ModelClasses.ReconciliationReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Random;

public class MonitorGatesViewController
{
    @javafx.fxml.FXML
    private DatePicker accessDateDatePicker;
    @javafx.fxml.FXML
    private TableColumn<Gate, String> accessTimeTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> accessTimeComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> gateNoComboBox;
    @javafx.fxml.FXML
    private TableView<Gate> gatesTableView;
    @javafx.fxml.FXML
    private Label isMalfunctionedLabel;
    @javafx.fxml.FXML
    private TableColumn<Gate, LocalDate> accessDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Gate, Integer> failedScansTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Gate, Boolean> malfunctionedTableColumn;
    @javafx.fxml.FXML
    private Label successfulScansLabel;
    @javafx.fxml.FXML
    private Label failedScansLabel;
    @javafx.fxml.FXML
    private TableColumn<Gate, Integer> successfulScansTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Gate, String> gateNoTableColumn;
    private ObservableList<Gate> gateList;
    private ObservableList<Gate> anomalyGateList;

    @javafx.fxml.FXML
    public void initialize() {
        gateList = FXCollections.observableArrayList();
        anomalyGateList = FXCollections.observableArrayList();

        successfulScansLabel.setText(this.generateId());
        failedScansLabel.setText(this.generateId());
        isMalfunctionedLabel.setText(this.isGateMalfunctioned());

        gateNoComboBox.getItems().addAll("01", "02", "03", "04", "05", "06");
        accessTimeComboBox.getItems().addAll("6 am", "9 am", "12 pm", "3 pm", "6 pm");

        gateNoTableColumn.setCellValueFactory(new PropertyValueFactory<Gate, String>("gateNo"));
        accessTimeTableColumn.setCellValueFactory(new PropertyValueFactory<Gate, String>("accessTime"));
        accessDateTableColumn.setCellValueFactory(new PropertyValueFactory<Gate, LocalDate>("accessDate"));
        successfulScansTableColumn.setCellValueFactory(new PropertyValueFactory<Gate, Integer>("noOfSuccessfulScans"));
        failedScansTableColumn.setCellValueFactory(new PropertyValueFactory<Gate, Integer>("noOfFailedScans"));
        malfunctionedTableColumn.setCellValueFactory(new PropertyValueFactory<Gate, Boolean>("isMalfunctioned"));
    }

    @javafx.fxml.FXML
    public void detectAnomaliesButtonOnAction(ActionEvent actionEvent) {
        anomalyGateList.clear();
        gatesTableView.getItems().clear();
        for(Gate g: gateList) {
            if(g.isMalfunctioned() == true) {
                anomalyGateList.add(g);
            }
        }
        gatesTableView.setItems(anomalyGateList);
    }

    @javafx.fxml.FXML
    public void contactSecurityButtonOnAction(ActionEvent actionEvent) {
        System.out.println("Urgent message: a gate needs fixing");
    }

    @javafx.fxml.FXML
    public void generateGateReportButtonOnAction(ActionEvent actionEvent) {
        File gateFile = new File("Gate Report.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if(gateFile.exists()) {
                fos = new FileOutputStream(gateFile, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(gateFile);
                oos = new ObjectOutputStream(fos);
            }
            for(Gate g: gateList) {
                oos.writeObject(g);
            }
            oos.close();
        }
        catch (Exception e) {

        }
    }

    private String generateId() {
        Random random = new Random();
        String id = Integer.toString(random.nextInt());
        return id;
    }

    private String isGateMalfunctioned() {
        int noOfSuccessfulScans = Integer.parseInt(successfulScansLabel.getText());
        int noOfFailedScans = Integer.parseInt(failedScansLabel.getText());
        int difference = noOfSuccessfulScans - noOfFailedScans;
        if(difference >= 0) {
            return "False";
        }
        else {
            return "True";
        }
    }

    @javafx.fxml.FXML
    public void addButtonOnAction(ActionEvent actionEvent) {
        gatesTableView.getItems().clear();
        String gateNo = gateNoComboBox.getValue();
        String accessTime = accessTimeComboBox.getValue();
        LocalDate accessDate = accessDateDatePicker.getValue();
        int noOfSuccessfulScans = Integer.parseInt(successfulScansLabel.getText());
        int noOfFailedScans = Integer.parseInt(failedScansLabel.getText());
        boolean isMalfunctioned = Boolean.parseBoolean(isMalfunctionedLabel.getText());
        Gate g = new Gate(gateNo, accessTime, accessDate, isMalfunctioned, noOfSuccessfulScans, noOfFailedScans);
        gateList.add(g);
        gatesTableView.setItems(gateList);
        gateNoComboBox.setValue(null);
        accessTimeComboBox.setValue(null);
        accessDateDatePicker.setValue(null);
        successfulScansLabel.setText(this.generateId());
        failedScansLabel.setText(this.generateId());
        isMalfunctionedLabel.setText(this.isGateMalfunctioned());
    }

    @javafx.fxml.FXML
    public void resetButtonOnAction(ActionEvent actionEvent) {
        gatesTableView.getItems().clear();
        gatesTableView.setItems(gateList);
    }
}