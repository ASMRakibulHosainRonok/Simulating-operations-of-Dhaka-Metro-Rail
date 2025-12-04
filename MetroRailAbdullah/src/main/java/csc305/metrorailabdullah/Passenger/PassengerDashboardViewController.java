package csc305.metrorailabdullah.Passenger;

import csc305.metrorailabdullah.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;

public class PassengerDashboardViewController
{
    @javafx.fxml.FXML
    private Label greetLabel;
    @javafx.fxml.FXML
    private BorderPane passengerDashboardBorderPane;
    @javafx.fxml.FXML
    private ImageView passengerImageVIew;
    private Passenger pass;

    @javafx.fxml.FXML
    public void initialize() {
    }

    public void setPassenger(Passenger pass) {
        this.pass = pass;
        greetLabel.setText("Welcome" + pass.getName());
    }

    @javafx.fxml.FXML
    public void linkedUserButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Passenger/ManageLinkedUserView.fxml"));
            passengerDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void historyButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Passenger/SeeHistoryView.fxml"));
            passengerDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void logoutButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.setTitle("Login");
            currentStage.setScene(scene);
            currentStage.show();
        }
        catch(Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void routesAndFaresButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Passenger/CheckRoutesAndFaresView.fxml"));
            passengerDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void feedbackButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Passenger/ProvideFeedbackView.fxml"));
            passengerDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void scheduleButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Passenger/CheckLiveStatusView.fxml"));
            passengerDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void rechargeTravelCardButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Passenger/RechargeTravelCardView.fxml"));
            passengerDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void reportButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Passenger/ApplyForRefundView.fxml"));
            passengerDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void dashboardButtonOnAction(ActionEvent actionEvent) {
        try {
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

    @javafx.fxml.FXML
    public void ticketButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("PurchaseTicketView.fxml"));
            passengerDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {

        }
    }
}