package csc305.metrorailabdullah.TicketingStaff;

import csc305.metrorailabdullah.AppendableObjectOutputStream;
import csc305.metrorailabdullah.ModelClasses.SalesReport;
import csc305.metrorailabdullah.ModelClasses.Schedule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class GenerateSalesReportViewController
{
    @javafx.fxml.FXML
    private TableColumn<SalesReport, String> routeOptionTableColumn;
    @javafx.fxml.FXML
    private TableColumn<SalesReport, Integer> ticketsSoldNoTableColumn;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private TableColumn<SalesReport, Integer> usageNoTableColumn;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private TableColumn<SalesReport, String> reportIdTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> routeOptionComboBox;
    @javafx.fxml.FXML
    private ComboBox<String> counterIdComboBox;
    @javafx.fxml.FXML
    private TableColumn<SalesReport, LocalDate> reportDateTableColumn;
    @javafx.fxml.FXML
    private TableView<SalesReport> salesReportTableView;
    @javafx.fxml.FXML
    private TableColumn<SalesReport, String> counterIdTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> chooseComboBox;
    @javafx.fxml.FXML
    private TableColumn<SalesReport, String> staffNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<SalesReport, Float> revenuesTableColumn;
    private ObservableList<SalesReport> reportList;
    private ObservableList<SalesReport> filteredReportList;

    @javafx.fxml.FXML
    public void initialize() {
        reportList = FXCollections.observableArrayList();
        filteredReportList = FXCollections.observableArrayList();

        chooseComboBox.getItems().addAll("Route Option", "Counter Id");
        routeOptionComboBox.getItems().addAll("A", "B", "C");
        counterIdComboBox.getItems().addAll("001", "002", "003", "004", "005");

        reportIdTableColumn.setCellValueFactory(new PropertyValueFactory<SalesReport, String>("reportId"));
        staffNameTableColumn.setCellValueFactory(new PropertyValueFactory<SalesReport, String>("staffName"));
        routeOptionTableColumn.setCellValueFactory(new PropertyValueFactory<SalesReport, String>("routeOption"));
        counterIdTableColumn.setCellValueFactory(new PropertyValueFactory<SalesReport, String>("counterId"));
        ticketsSoldNoTableColumn.setCellValueFactory(new PropertyValueFactory<SalesReport, Integer>("noOfTicketsSold"));
        revenuesTableColumn.setCellValueFactory(new PropertyValueFactory<SalesReport, Float>("revenues"));
        usageNoTableColumn.setCellValueFactory(new PropertyValueFactory<SalesReport, Integer>("noOfUsage"));
        reportDateTableColumn.setCellValueFactory(new PropertyValueFactory<SalesReport, LocalDate>("reportDate"));
    }

    @javafx.fxml.FXML
    public void resetButtonOnAction(ActionEvent actionEvent) {
        salesReportTableView.getItems().clear();
        salesReportTableView.setItems(reportList);
    }

    @javafx.fxml.FXML
    public void chooseComboBoxOnAction(ActionEvent actionEvent) {
        String chooseOption = chooseComboBox.getValue();
        if(chooseOption.equals("Route Option")) {
            routeOptionComboBox.setDisable(false);
        }
        else if(chooseOption.equals("Counter Id")) {
            counterIdComboBox.setDisable(false);
        }
    }

    @javafx.fxml.FXML
    public void filterButtonOnAction(ActionEvent actionEvent) {
        salesReportTableView.getItems().clear();
        filteredReportList.clear();
        if(counterIdComboBox.isDisabled()) {
            String routeOption = routeOptionComboBox.getValue();
            LocalDate from = fromDatePicker.getValue();
            LocalDate to = toDatePicker.getValue();
            for(SalesReport report: reportList) {
                if(report.getRouteOption().equals(routeOption) && ((report.getReportDate().isEqual(from) | report.getReportDate().isAfter(from)) && (report.getReportDate().isEqual(to) | report.getReportDate().isBefore(to)))) {
                    filteredReportList.add(report);
                }
            }
            salesReportTableView.setItems(filteredReportList);
            chooseComboBox.setValue(null);
            routeOptionComboBox.setValue(null);
            routeOptionComboBox.setDisable(true);
            fromDatePicker.setValue(null);
            toDatePicker.setValue(null);
        }
        else if(routeOptionComboBox.isDisabled()) {
            String counterId = counterIdComboBox.getValue();
            LocalDate from = fromDatePicker.getValue();
            LocalDate to = toDatePicker.getValue();
            for(SalesReport report: reportList) {
                if(report.getCounterId().equals(counterId) && ((report.getReportDate().isEqual(from) || report.getReportDate().isAfter(from)) && (report.getReportDate().isEqual(to) || report.getReportDate().isBefore(to)))) {
                    filteredReportList.add(report);
                }
            }
            salesReportTableView.setItems(filteredReportList);
            chooseComboBox.setValue(null);
            counterIdComboBox.setValue(null);
            counterIdComboBox.setDisable(true);
            fromDatePicker.setValue(null);
            toDatePicker.setValue(null);
        }
    }

    @javafx.fxml.FXML
    public void exportButtonOnAction(ActionEvent actionEvent) {
        File salesReportFile = new File("Filtered Sales Report.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if(salesReportFile.exists()) {
                fos = new FileOutputStream(salesReportFile, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(salesReportFile);
                oos = new ObjectOutputStream(fos);
            }
            for(SalesReport report: filteredReportList) {
                oos.writeObject(report);
            }
            oos.close();
        }
        catch (Exception e) {

        }
    }
}