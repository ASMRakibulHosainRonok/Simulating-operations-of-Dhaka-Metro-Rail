package csc305.metrorailabdullah.TicketingStaff;

import csc305.metrorailabdullah.AppendableObjectOutputStream;
import csc305.metrorailabdullah.ModelClasses.SpecialTravelCard;
import csc305.metrorailabdullah.ModelClasses.TravelCard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.time.LocalDate;
import java.util.Random;

public class GenerateSpecialPassViewController
{
    @javafx.fxml.FXML
    private TableColumn<SpecialTravelCard, String> cardIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn<SpecialTravelCard, LocalDate> finalDateTableColumn;
    @javafx.fxml.FXML
    private TableView<SpecialTravelCard> specialPassTableView;
    @javafx.fxml.FXML
    private TableColumn<SpecialTravelCard, String> eligibilityTableColumn;
    @javafx.fxml.FXML
    private CheckBox studentsCheckBox;
    @javafx.fxml.FXML
    private CheckBox seniorsCheckBox;
    @javafx.fxml.FXML
    private DatePicker finalDatePicker;
    @javafx.fxml.FXML
    private TableColumn<SpecialTravelCard, Float> balanceTableColumn;
    @javafx.fxml.FXML
    private Label cardIdLabel;
    @javafx.fxml.FXML
    private TableColumn<SpecialTravelCard, String> passengerNameTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> eligibilityComboBox;
    private ObservableList<SpecialTravelCard> specialCardList;
    private ObservableList<TravelCard> travelCardList;
    @javafx.fxml.FXML
    private Label eligibilityLabel;
    @javafx.fxml.FXML
    private CheckBox corporateCheckBox;
    @javafx.fxml.FXML
    private TextField cardIdTextField;

    @javafx.fxml.FXML
    public void initialize() {
        specialCardList = FXCollections.observableArrayList();
        travelCardList = FXCollections.observableArrayList();
        eligibilityComboBox.getItems().addAll("Student", "Senior", "Corporate");
        cardIdLabel.setText(this.generateId());

        cardIdTableColumn.setCellValueFactory(new PropertyValueFactory<SpecialTravelCard, String>("cardId"));
        passengerNameTableColumn.setCellValueFactory(new  PropertyValueFactory<SpecialTravelCard, String>("passengerName"));
        eligibilityTableColumn.setCellValueFactory(new PropertyValueFactory<SpecialTravelCard, String>("status"));
        balanceTableColumn.setCellValueFactory(new  PropertyValueFactory<SpecialTravelCard, Float>("balance"));
        finalDateTableColumn.setCellValueFactory(new PropertyValueFactory<SpecialTravelCard, LocalDate>("finalDate"));
    }

    public void setTravelCardList(ObservableList<TravelCard> travelCardList) {
        this.travelCardList = travelCardList;
    }

    @javafx.fxml.FXML
    public void eligibilityComboBoxOnAction(ActionEvent actionEvent) {
        String eligibilty = eligibilityComboBox.getValue();
        if(eligibilty.equals("Student")) {
            studentsCheckBox.setDisable(false);
            eligibilityLabel.setText(eligibilty);
        }
        if(eligibilty.equals("Senior")) {
            seniorsCheckBox.setDisable(false);
            eligibilityLabel.setText(eligibilty);
        }
        if(eligibilty.equals("Corporate")) {
            corporateCheckBox.setDisable(false);
            eligibilityLabel.setText(eligibilty);
        }
    }

    @javafx.fxml.FXML
    public void resetButtonOnAction(ActionEvent actionEvent) {
        specialPassTableView.getItems().clear();
    }

    @javafx.fxml.FXML
    public void generateSpecialPassButtonOnAction(ActionEvent actionEvent) {
        String specialCardId = cardIdLabel.getText();
        String eligibility = eligibilityLabel.getText();
        File oldCardFile = new File("Updated Travel Cards after replacement by Ticketing Staff.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            if(oldCardFile.exists()) {
                fis = new FileInputStream(oldCardFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    try {
                        TravelCard oldCard = (TravelCard) ois.readObject();
                        travelCardList.add(oldCard);
                    }
                    catch (EOFException e) {
                        System.out.println("File read successfully");
                        ois.close();
                        break;
                    }
                }
            }
            else {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Not Found");
                a.setContentText("Sorry the file could not be found");
                a.showAndWait();
            }
        }
        catch (IOException | ClassNotFoundException e) {

        }
        String cardId = cardIdTextField.getText();
        float discount = 0;
        if(!studentsCheckBox.isDisabled() && studentsCheckBox.isSelected()) {
            discount = 10 / 100;
        }
        if(!seniorsCheckBox.isDisabled() && seniorsCheckBox.isSelected()) {
            discount = 10 / 100;
        }
        if(!corporateCheckBox.isDisabled() && corporateCheckBox.isSelected()) {
            discount = 5 / 100;
        }
        LocalDate finalDate = finalDatePicker.getValue();
        File specialCardFile = new File("Special Travel Cards.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if(specialCardFile.exists()) {
                fos = new FileOutputStream(specialCardFile, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(specialCardFile);
                oos = new ObjectOutputStream(fos);
            }
            for(TravelCard card: travelCardList) {
                if(card.getCardId().equals(cardId)) {
                    String name = card.getPassengerName();
                    float amount = card.getBalance();
                    boolean isMonthly = card.isMonthly();
                    SpecialTravelCard newCard = new SpecialTravelCard(cardId, name, amount, isMonthly, eligibility, discount, finalDate);
                    specialCardList.add(newCard);
                    oos.writeObject(newCard);
                }
            }
            oos.close();
        }
        catch (Exception e) {

        }
        specialPassTableView.setItems(specialCardList);
        eligibilityComboBox.setValue(null);
        cardIdLabel.setText(this.generateId());
        cardIdTextField.clear();
        studentsCheckBox.setSelected(false);
        studentsCheckBox.setDisable(true);
        seniorsCheckBox.setSelected(false);
        seniorsCheckBox.setDisable(true);
        corporateCheckBox.setSelected(false);
        corporateCheckBox.setDisable(true);
        finalDatePicker.setValue(null);
    }

    private String generateId() {
        Random random = new Random();
        String id = Integer.toString(random.nextInt(1000, 9999));
        return id;
    }

}