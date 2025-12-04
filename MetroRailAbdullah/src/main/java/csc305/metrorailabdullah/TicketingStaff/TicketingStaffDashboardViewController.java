package csc305.metrorailabdullah.TicketingStaff;

import csc305.metrorailabdullah.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;

public class TicketingStaffDashboardViewController
{
    @javafx.fxml.FXML
    private ImageView ticketingStaffImageView;
    @javafx.fxml.FXML
    private BorderPane ticketingStaffDashboardBorderPane;
    @javafx.fxml.FXML
    private Label greetLabel;
    private TicketingStaff staff;

    @javafx.fxml.FXML
    public void initialize() {
    }

    public void setTicketingStaff(TicketingStaff staff) {
        this.staff = staff;
        greetLabel.setText("Welcome " + staff.getName());
    }

    @javafx.fxml.FXML
    public void monitorGatesButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TicketingStaff/MonitorGatesView.fxml"));
            ticketingStaffDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void specialPassButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TicketingStaff/GenerateSpecialPassView.fxml"));
            ticketingStaffDashboardBorderPane.setCenter(fxmlLoader.load());
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
    public void reconciliationReportButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TicketingStaff/GenerateReconciliationReportView.fxml"));
            ticketingStaffDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void complaintsButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TicketingStaff/CheckComplaintView.fxml"));
            ticketingStaffDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void replaceTravelCardsButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TicketingStaff/ReplaceTravelCardView.fxml"));
            ticketingStaffDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void rechargeTravelCardsButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TicketingStaff/RechargeTravelCardByTicketingStaffView.fxml"));
            ticketingStaffDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void ticketButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TicketingStaff/GenerateTicketView.fxml"));
            ticketingStaffDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void salesReportButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TicketingStaff/GenerateSalesReportView.fxml"));
            ticketingStaffDashboardBorderPane.setCenter(fxmlLoader.load());
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void dashboardButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TicketingStaff/TicketingStaffDashboardView.fxml"));
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