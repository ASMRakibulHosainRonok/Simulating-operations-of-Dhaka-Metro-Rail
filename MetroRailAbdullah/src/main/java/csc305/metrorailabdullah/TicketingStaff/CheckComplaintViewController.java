package csc305.metrorailabdullah.TicketingStaff;

import csc305.metrorailabdullah.ModelClasses.Complaint;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CheckComplaintViewController
{
    @javafx.fxml.FXML
    private TableView<Complaint> complaintsTableView;
    @javafx.fxml.FXML
    private Label transactionStatusLabel;
    @javafx.fxml.FXML
    private Label complaintIdLabel;
    @javafx.fxml.FXML
    private TableColumn<Complaint, String> transactionStatusTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Complaint, String> complaintIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Complaint, String> ticketIdTableColumn;
    @javafx.fxml.FXML
    private TextField ticketIdTextField;
    private ObservableList<Complaint> complaintList;
    private ObservableList<Complaint> filteredComplaintList;
    private Complaint check;

    @javafx.fxml.FXML
    public void initialize() {
        complaintList = FXCollections.observableArrayList();
        filteredComplaintList = FXCollections.observableArrayList();

        complaintIdTableColumn.setCellValueFactory(new PropertyValueFactory<Complaint, String>("complaintId"));
        ticketIdTableColumn.setCellValueFactory(new PropertyValueFactory<Complaint, String>("ticketId"));
        transactionStatusTableColumn.setCellValueFactory(new PropertyValueFactory<Complaint, String>("transactionStatus"));
    }

    @javafx.fxml.FXML
    public void updateButtonOnAction(ActionEvent actionEvent) {
        complaintsTableView.getItems().clear();
        complaintsTableView.setItems(complaintList);
    }

    @javafx.fxml.FXML
    public void requestRefundButtonOnAction(ActionEvent actionEvent) {
        String transactionStatus = check.getTransactionStatus();
        for(Complaint complaint: filteredComplaintList) {
            if(complaint.getTransactionStatus().equals(transactionStatus)) {
                complaint.setTransactionStatus("Refunded");
                complaintList.remove(complaint);
                filteredComplaintList.remove(complaint);
                complaintsTableView.getItems().clear();
                complaintIdLabel.setText("Label");
                transactionStatusLabel.setText("Label");
            }
        }
    }

    @javafx.fxml.FXML
    public void nextStepButtonOnAction(ActionEvent actionEvent) {
        String transactionStatus = check.getTransactionStatus();
        for(Complaint complaint: filteredComplaintList) {
            if(complaint.getTransactionStatus().equals(transactionStatus)) {
                complaint.setTransactionStatus("Valid");
                complaintList.remove(complaint);
                filteredComplaintList.remove(complaint);
                complaintsTableView.getItems().clear();
                complaintIdLabel.setText("Label");
                transactionStatusLabel.setText("Label");
            }
        }
    }

    @javafx.fxml.FXML
    public void filterButtonOnAction(ActionEvent actionEvent) {
        filteredComplaintList.clear();
        complaintsTableView.getItems().clear();
        String ticketId = ticketIdTextField.getText();
        for(Complaint complaint: complaintList) {
            if(complaint.getTicketId().equals(ticketId)) {
                filteredComplaintList.add(complaint);
                complaintIdLabel.setText(complaint.getComplaintId());
                transactionStatusLabel.setText(complaint.getTransactionStatus());
                check = new Complaint(complaint.getComplaintId(), ticketId, complaint.getTransactionStatus());
            }
        }
        complaintsTableView.setItems(filteredComplaintList);
        ticketIdTextField.clear();
    }
}