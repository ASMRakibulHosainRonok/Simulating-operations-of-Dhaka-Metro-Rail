package csc305.metrorailabdullah.TicketingStaff;

import csc305.metrorailabdullah.AppendableObjectOutputStream;
import csc305.metrorailabdullah.ModelClasses.ReconciliationReport;
import csc305.metrorailabdullah.ModelClasses.SalesReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class GenerateReconciliationReportViewController
{
    @javafx.fxml.FXML
    private TableColumn<ReconciliationReport, Float> balanceTableColumn;
    @javafx.fxml.FXML
    private DatePicker fromDatePicker;
    @javafx.fxml.FXML
    private TableView<ReconciliationReport> reconciliationReportTableView;
    @javafx.fxml.FXML
    private DatePicker toDatePicker;
    @javafx.fxml.FXML
    private TableColumn<ReconciliationReport,Float> refundsTableColumn;
    @javafx.fxml.FXML
    private TableColumn<ReconciliationReport, String> reconciliationReportIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn<ReconciliationReport, LocalDate> reportDateTableColumn;
    @javafx.fxml.FXML
    private TableColumn<ReconciliationReport, String> staffNameTableColumn;
    private ObservableList<ReconciliationReport> reconciliationReportList;
    private ObservableList<ReconciliationReport> filteredReconciliationReportList;
    @javafx.fxml.FXML
    private TableColumn<ReconciliationReport, String> salesReportIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn<ReconciliationReport, Float> physicalCashTableColumn;
    @javafx.fxml.FXML
    private TableColumn<ReconciliationReport, Float> onlineCashTableColumn;

    @javafx.fxml.FXML
    public void initialize() {
        reconciliationReportList = FXCollections.observableArrayList();
        filteredReconciliationReportList = FXCollections.observableArrayList();

        reconciliationReportIdTableColumn.setCellValueFactory(new PropertyValueFactory<ReconciliationReport, String>("reconReportId"));
        staffNameTableColumn.setCellValueFactory(new PropertyValueFactory<ReconciliationReport, String>("staffName"));
        salesReportIdTableColumn.setCellValueFactory(new PropertyValueFactory<ReconciliationReport, String>("salesReportId"));
        physicalCashTableColumn.setCellValueFactory(new  PropertyValueFactory<ReconciliationReport, Float>("physicalCash"));
        onlineCashTableColumn.setCellValueFactory(new  PropertyValueFactory<ReconciliationReport, Float>("onlineCash"));
        refundsTableColumn.setCellValueFactory(new PropertyValueFactory<ReconciliationReport, Float>("refunds"));
        balanceTableColumn.setCellValueFactory(new PropertyValueFactory<ReconciliationReport, Float>("balance"));
        reportDateTableColumn.setCellValueFactory(new PropertyValueFactory<ReconciliationReport, LocalDate>("reportDate"));
    }

    @javafx.fxml.FXML
    public void resetButtonOnAction(ActionEvent actionEvent) {
        reconciliationReportTableView.getItems().clear();
        reconciliationReportTableView.setItems(reconciliationReportList);
    }

    @javafx.fxml.FXML
    public void submitReportButtonOnAction(ActionEvent actionEvent) {
        File reconciliationReportFile = new File("Filtered Reconciliation Report.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if(reconciliationReportFile.exists()) {
                fos = new FileOutputStream(reconciliationReportFile, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(reconciliationReportFile);
                oos = new ObjectOutputStream(fos);
            }
            for(ReconciliationReport report: filteredReconciliationReportList) {
                oos.writeObject(report);
            }
            oos.close();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void filterButtonOnAction(ActionEvent actionEvent) {
        reconciliationReportTableView.getItems().clear();
        filteredReconciliationReportList.clear();
        LocalDate from = fromDatePicker.getValue();
        LocalDate to = toDatePicker.getValue();
        for(ReconciliationReport report: reconciliationReportList) {
            if((report.getReportDate().isEqual(from) || report.getReportDate().isAfter(from)) && (report.getReportDate().isEqual(to) && report.getReportDate().isBefore(to))) {
                filteredReconciliationReportList.add(report);
            }
        }
        reconciliationReportTableView.setItems(filteredReconciliationReportList);
        fromDatePicker.setValue(null);
        toDatePicker.setValue(null);
    }
}