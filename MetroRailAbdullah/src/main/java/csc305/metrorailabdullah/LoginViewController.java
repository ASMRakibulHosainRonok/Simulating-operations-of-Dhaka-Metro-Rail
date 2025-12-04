package csc305.metrorailabdullah;

import csc305.metrorailabdullah.Passenger.Passenger;
import csc305.metrorailabdullah.TicketingStaff.TicketingStaff;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        passengerList.add(new Passenger("0001000", "Afreen Maliat", "passenger@gmail.com", "123456", "0123456789", "01792889897"));
        ticketingStaffList.add(new TicketingStaff("0010", "Abdullah Al Nahiyan", "staff@gmail.com", "123456", "0123456789"));
    }

    public void setPassengerList(ObservableList<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public void setTicketingStaffList(ObservableList<TicketingStaff> ticketingStaffList) {
        this.ticketingStaffList = ticketingStaffList;
    }

    @javafx.fxml.FXML
    public void loginButtonOnAction(ActionEvent actionEvent) {
        String id = idTextField.getText();
        String password = passwordPasswordField.getText();
        Alert success = new Alert(Alert.AlertType.CONFIRMATION);
        success.setTitle("Login Successful!");
        if(id.length() == 7 && password.length() >= 6) {
            for(Passenger p: passengerList) {
                if(p.getId().equals(id) && p.getPassword().equals(password)) {
                    try {
                        success.setContentText("Welcome! " + p.getName());
                        success.showAndWait();
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Passenger/PassengerDashboardView.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                        currentStage.setTitle("Passenger Dashboard");
                        currentStage.setScene(scene);
                        currentStage.show();
                    }
                    catch(Exception e) {

                    }
                }
            }
        }
        else if(id.length() == 4 && password.length() >= 6) {
            for(TicketingStaff staff: ticketingStaffList) {
                if(staff.getId().equals(id) && staff.getPassword().equals(password)) {
                    try {
                        success.setContentText("Welcome! " + staff.getName());
                        success.showAndWait();
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TicketingStaff/TicketingStaffView.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                        currentStage.setTitle("Ticketing Staff Dashboard");
                        currentStage.setScene(scene);
                        currentStage.show();
                    }
                    catch(Exception e) {

                    }
                }
            }
        }
        else {
            Alert fail = new Alert(Alert.AlertType.ERROR);
            fail.setTitle("Login Failed!");
            fail.setContentText("User not found.\nCheck id and password again.");
            fail.showAndWait();
        }
    }

    @javafx.fxml.FXML
    public void createAccountButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CreateAccountView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.setTitle("Create Account");
            currentStage.setScene(scene);
            currentStage.show();
        }
        catch(Exception e) {

        }
    }
}