package csc305.metrorailabdullah.Passenger;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ManageLinkedUserViewController
{
    @javafx.fxml.FXML
    private TextField idOrNumberTextField;
    @javafx.fxml.FXML
    private TableView linkedUserTableView;
    @javafx.fxml.FXML
    private TableColumn userIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn phoneNumberTableColumn;
    @javafx.fxml.FXML
    private ComboBox paymentMethodComboBox;
    @javafx.fxml.FXML
    private TableColumn dependentNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn travelPermissionTableColumn;
    @javafx.fxml.FXML
    private TableColumn paymentMethodTableColumn;
    @javafx.fxml.FXML
    private ComboBox travelPermissionComboBox;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void addButtonOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void resetButtonOnAction(ActionEvent actionEvent) {
    }
}