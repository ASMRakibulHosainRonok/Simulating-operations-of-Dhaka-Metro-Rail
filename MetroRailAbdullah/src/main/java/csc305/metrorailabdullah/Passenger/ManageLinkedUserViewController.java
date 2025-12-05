package csc305.metrorailabdullah.Passenger;

import csc305.metrorailabdullah.AppendableObjectOutputStream;
import csc305.metrorailabdullah.ModelClasses.Dependent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ManageLinkedUserViewController
{
    @javafx.fxml.FXML
    private TextField idOrNumberTextField;
    @javafx.fxml.FXML
    private TableView<Dependent> linkedUserTableView;
    @javafx.fxml.FXML
    private TableColumn<Dependent, String> userIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Dependent, String> phoneNumberTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> paymentMethodComboBox;
    @javafx.fxml.FXML
    private TableColumn<Dependent, String> dependentNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Dependent, String> travelPermissionTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Dependent, String> paymentMethodTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> travelPermissionComboBox;
    private ObservableList<Passenger> passengerList;
    private ObservableList<Dependent> dependentList;

    @javafx.fxml.FXML
    public void initialize() {
        passengerList = FXCollections.observableArrayList();
        dependentList = FXCollections.observableArrayList();

        travelPermissionComboBox.getItems().addAll("Yes", "No");
        paymentMethodComboBox.getItems().addAll("Cash", "Credit Card");

        userIdTableColumn.setCellValueFactory(new PropertyValueFactory<Dependent, String>("id"));
        phoneNumberTableColumn.setCellValueFactory(new PropertyValueFactory<Dependent, String>("phoneNo"));
        dependentNameTableColumn.setCellValueFactory(new PropertyValueFactory<Dependent, String>("name"));
        travelPermissionTableColumn.setCellValueFactory(new PropertyValueFactory<Dependent, String>("travelPermission"));
        paymentMethodTableColumn.setCellValueFactory(new PropertyValueFactory<Dependent, String>("paymentMethod"));
    }

    @javafx.fxml.FXML
    public void addButtonOnAction(ActionEvent actionEvent) {
        linkedUserTableView.getItems().clear();
        String identifier = idOrNumberTextField.getText();
        String travelPermission = travelPermissionComboBox.getValue();
        String paymentMethod = paymentMethodComboBox.getValue();
        File dependentFile = new File("Dependents.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if(dependentFile.exists()) {
                fos = new FileOutputStream(dependentFile, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(dependentFile);
                oos = new ObjectOutputStream(fos);
            }
            for(Passenger p: passengerList) {
                if(p.getId().equals(identifier) || p.getPhoneNo().equals(identifier)) {
                    String id = p.getId();
                    String name = p.getName();
                    String email = p.getEmail();
                    String password = p.getPassword();
                    String phoneNo = p.getPhoneNo();
                    Dependent user = new Dependent(id, name, email, password, phoneNo, travelPermission, paymentMethod);
                    dependentList.add(user);
                    oos.writeObject(user);
                }
            }
            oos.close();
            linkedUserTableView.setItems(dependentList);
        }
        catch (Exception e) {

        }
        idOrNumberTextField.clear();
        travelPermissionComboBox.setValue(null);
        paymentMethodComboBox.setValue(null);
    }

    @javafx.fxml.FXML
    public void resetButtonOnAction(ActionEvent actionEvent) {
        linkedUserTableView.getItems().clear();
    }
}