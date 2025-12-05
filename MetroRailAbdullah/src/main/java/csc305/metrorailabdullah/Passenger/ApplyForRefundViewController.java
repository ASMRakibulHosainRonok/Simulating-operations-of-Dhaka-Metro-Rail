package csc305.metrorailabdullah.Passenger;

import csc305.metrorailabdullah.AppendableObjectOutputStream;
import csc305.metrorailabdullah.ModelClasses.IssueReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class ApplyForRefundViewController
{
    @javafx.fxml.FXML
    private TableColumn<IssueReport, String> ticketIdTableColumn;
    @javafx.fxml.FXML
    private TextArea issueTextArea;
    @javafx.fxml.FXML
    private TableView<IssueReport> reportTableView;
    @javafx.fxml.FXML
    private TableColumn<IssueReport, String> passengerNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<IssueReport, String> reportIdTableColumn;
    @javafx.fxml.FXML
    private Label reportIdLabel;
    @javafx.fxml.FXML
    private TableColumn<IssueReport, String> issueTableColumn;
    private ObservableList<IssueReport> reportList;
    @javafx.fxml.FXML
    private TextField ticketIdTextField;
    @javafx.fxml.FXML
    private TextField passengerNameTextField;

    @javafx.fxml.FXML
    public void initialize() {
        reportList = FXCollections.observableArrayList();

        reportIdLabel.setText(this.generateId());

        reportIdTableColumn.setCellValueFactory(new PropertyValueFactory<IssueReport, String>("reportId"));
        ticketIdTableColumn.setCellValueFactory(new PropertyValueFactory<IssueReport, String>(> "ticketId"));
        passengerNameTableColumn.setCellValueFactory(new PropertyValueFactory<IssueReport, String>("passengerName"));
        issueTableColumn.setCellValueFactory(new PropertyValueFactory<IssueReport, String>("issue"));
    }

    @javafx.fxml.FXML
    public void resetButtonOnAction(ActionEvent actionEvent) {
        reportTableView.getItems().clear();
    }

    @javafx.fxml.FXML
    public void continueButtonOnAction(ActionEvent actionEvent) {
        reportTableView.getItems().clear();
        String reportId = reportIdLabel.getText();
        String ticketId = ticketIdTextField.getText();
        String passengerName = passengerNameTextField.getText();
        String issue = issueTextArea.getText();
        File reportFile = new File("Issue Reports.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if(reportFile.exists()) {
                fos = new FileOutputStream(reportFile, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(reportFile);
                oos = new ObjectOutputStream(fos);
            }
            IssueReport report = new IssueReport(reportId, ticketId, passengerName, issue);
            reportList.add(report);
            oos.writeObject(report);
            oos.close();
        }
        catch (Exception e) {

        }
        reportIdLabel.setText(this.generateId());
        ticketIdTextField.clear();
        passengerNameTextField.clear();
        issueTextArea.clear();
    }

    private String generateId() {
        Random random = new Random();
        String id = Integer.toString(random.nextInt(1000, 9999));
        return id;
    }
}