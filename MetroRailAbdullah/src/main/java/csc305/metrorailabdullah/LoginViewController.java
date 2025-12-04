package csc305.metrorailabdullah;

import csc305.metrorailabdullah.Passenger.Passenger;
import csc305.metrorailabdullah.TicketingStaff.TicketingStaff;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginViewController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private PasswordField passwordPasswordField;
    private ObservableList<Passenger> passengerList;
    private ObservableList<TicketingStaff> ticketingStaffList;

    @javafx.fxml.FXML
    public void initialize() {
    }

    public void setPassengerList(ObservableList<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public void setTicketingStaffList(ObservableList<TicketingStaff> ticketingStaffList) {
        this.ticketingStaffList = ticketingStaffList;
    }

    @javafx.fxml.FXML
    public void loginButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void createAccountButtonOnAction(ActionEvent actionEvent) {
    }
}