package csc305.metrorailabdullah;

import csc305.metrorailabdullah.Passenger.Passenger;
import csc305.metrorailabdullah.TicketingStaff.TicketingStaff;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class CreateAccountViewController
{
    @javafx.fxml.FXML
    private TextField phoneNoTextField;
    @javafx.fxml.FXML
    private ComboBox<String> typeComboBox;
    @javafx.fxml.FXML
    private Label idLabel;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private PasswordField passwordPasswordField;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextField contactTextField;
    private ObservableList<Passenger> passengerList;
    private ObservableList<TicketingStaff> ticketingStaffList;

    @javafx.fxml.FXML
    public void initialize() {
        typeComboBox.getItems().addAll("Passenger", "TicketingStaff");
        passengerList = FXCollections.observableArrayList();
        ticketingStaffList = FXCollections.observableArrayList();
    }

    @javafx.fxml.FXML
    public void loginButtonOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LoginView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            LoginViewController loginController = fxmlLoader.getController();
            loginController.setPassengerList(passengerList);
            loginController.setTicketingStaffList(ticketingStaffList);
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            currentStage.setTitle("Login");
            currentStage.setScene(scene);
            currentStage.show();
        }
        catch(Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void createAccountButtonOnAction(ActionEvent actionEvent) {
        String id = idLabel.getText();
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordPasswordField.getText();
        String phoneNo = phoneNoTextField.getText();
        String emergencyContact = " ";
        boolean flag = true;
        String error = " ";
        if(id.length() == 7) {
            emergencyContact = contactTextField.getText();
        }
        if(name.isBlank()) {
            flag = false;
            error += "Name is not given.\n";
        }
        if(password.length() < 6) {
            flag = false;
            error += "Password is less than 6.\n";
        }
        if(!flag) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Wrong Input");
            a.setContentText(error);
            a.showAndWait();
            return;
        }
        else {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Congrats!");
            File objectf1, objectf2;
            FileOutputStream fos1, fos2 = null;
            ObjectOutputStream oos1, oos2 = null;
            objectf1 = new File("Passenger Accounts.bin:");
            objectf2 = new File("Ticketing Staff Accounts.bin");
            try {
                if(objectf1.exists()) {
                    fos1 = new FileOutputStream(objectf1, true);
                    oos1 = new AppendableObjectOutputStream(fos1);
                }
                else {
                    fos1 = new FileOutputStream(objectf1);
                    oos1 = new ObjectOutputStream(fos1);
                }
                if(objectf2.exists()) {
                    fos2 = new FileOutputStream(objectf2, true);
                    oos2 = new AppendableObjectOutputStream(fos2);
                }
                else {
                    fos2 = new FileOutputStream(objectf2);
                    oos2 = new ObjectOutputStream(fos2);
                }
                if(id.length() == 7) {
                    Passenger p = new Passenger(id, name, email, password, phoneNo, emergencyContact);
                    passengerList.add(p);
                    a.setContentText("Your account is successfully created.");
                    a.showAndWait();
                    oos1.writeObject(p);
                    oos1.close();
                    contactTextField.clear();
                }
                if(id.length() == 4) {
                    TicketingStaff staff = new TicketingStaff(id, name, email, password, phoneNo);
                    ticketingStaffList.add(staff);
                    a.setContentText("Your account is successfully created.");
                    a.showAndWait();
                    oos2.writeObject(staff);
                    oos2.close();
                }
            }
            catch (Exception e) {

            }
            typeComboBox.setValue(null);
            idLabel.setText("Label");
            nameTextField.clear();
            emailTextField.clear();
            passwordPasswordField.clear();
            phoneNoTextField.clear();
        }

    }

    @javafx.fxml.FXML
    public void accountTypeComboBoxOnAction(ActionEvent actionEvent) {
        Random random = new Random();
        String type = typeComboBox.getValue();
        String id = " ";
        if(type.equals("Passenger")) {
            id = Integer.toString(random.nextInt(1000000, 9999999));
        }
        else if(type.equals("TicketingStaff")) {
            id = Integer.toString(random.nextInt(1000, 9999));
            contactTextField.setDisable(false);
        }
        idLabel.setText(id);
    }

}