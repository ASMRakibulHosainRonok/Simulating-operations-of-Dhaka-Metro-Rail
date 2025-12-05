package csc305.metrorailabdullah.Passenger;

import csc305.metrorailabdullah.AppendableObjectOutputStream;
import csc305.metrorailabdullah.ModelClasses.TravelCard;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Random;

public class RechargeTravelCardViewController
{
    @javafx.fxml.FXML
    private TextField idTextField;
    @javafx.fxml.FXML
    private TableColumn<TravelCard, String> cardIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn<TravelCard, Float> amountTableColumn;
    @javafx.fxml.FXML
    private CheckBox monthlyAmountCheckBox;
    @javafx.fxml.FXML
    private CheckBox monthlyCheckBox;
    @javafx.fxml.FXML
    private TableColumn<TravelCard, String> passengerNameTableColumn;
    @javafx.fxml.FXML
    private TextField amountTextField;
    @javafx.fxml.FXML
    private TableColumn<TravelCard, Boolean> isMonthlyTableColumn;
    @javafx.fxml.FXML
    private TableView<TravelCard> travelCardTableView;
    @javafx.fxml.FXML
    private Label indicationLabel;
    private ObservableList<TravelCard> travelCardList;

    @javafx.fxml.FXML
    public void initialize() {
        indicationLabel.setText("No");

        cardIdTableColumn.setCellValueFactory(new PropertyValueFactory<TravelCard, String>("cardId"));
        passengerNameTableColumn.setCellValueFactory(new PropertyValueFactory<TravelCard, String>("passengerName"));
        isMonthlyTableColumn.setCellValueFactory(new PropertyValueFactory<TravelCard, Boolean>("isMonthly"));
        amountTableColumn.setCellValueFactory(new  PropertyValueFactory<TravelCard, Float>("balance"));
    }

    public void setTravelCardList(ObservableList<TravelCard> travelCardList) {
        this.travelCardList = travelCardList;
    }

    @javafx.fxml.FXML
    public void resetButtonOnAction(ActionEvent actionEvent) {
        travelCardTableView.getItems().clear();
    }

    @javafx.fxml.FXML
    public void monthlyCheckBoxOnAction(ActionEvent actionEvent) {
        monthlyAmountCheckBox.setDisable(false);
        amountTextField.setDisable(true);
        indicationLabel.setText("Yes");
    }

    @javafx.fxml.FXML
    public void rechargeTravelCardButtonOnAction(ActionEvent actionEvent) {
        String id = idTextField.getText();
        String indicate = indicationLabel.getText();
        float amount = 0;
        LocalDate finalTravelDate = null;
        if(monthlyCheckBox.isSelected() && monthlyAmountCheckBox.isSelected()) {
            amount = 500;
        }
        else {
            amount = Float.parseFloat(amountTextField.getText());
        }
        for(TravelCard card: travelCardList) {
            if(card.getCardId().equals(id)) {
                card.setBalance(amount);
            }
        }
        travelCardTableView.setItems(travelCardList);
        File travelCardFile = new File("Updated Travel Cards by Passenger");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if(travelCardFile.exists()) {
                fos = new FileOutputStream(travelCardFile, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(travelCardFile);
                oos = new ObjectOutputStream(fos);
            }
            for(TravelCard card: travelCardList) {
                oos.writeObject(card);
            }
            oos.close();
        }
        catch (Exception e) {

        }
        idTextField.clear();
        if(monthlyCheckBox.isSelected()) {
            monthlyCheckBox.setSelected(false);
            amountTextField.setDisable(false);
            monthlyAmountCheckBox.setSelected(false);
            monthlyAmountCheckBox.setDisable(true);
            indicationLabel.setText("No");
        }
        else {
            amountTextField.clear();
        }
    }

}