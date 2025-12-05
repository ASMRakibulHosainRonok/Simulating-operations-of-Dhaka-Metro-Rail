package csc305.metrorailabdullah.TicketingStaff;

import csc305.metrorailabdullah.AppendableObjectOutputStream;
import csc305.metrorailabdullah.ModelClasses.TravelCard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.imageio.IIOException;
import java.io.*;
import java.util.Random;

public class ReplaceTravelCardViewController
{
    @javafx.fxml.FXML
    private TableColumn<TravelCard, String> oldCardPassengerNameTableColumn;
    @javafx.fxml.FXML
    private TableColumn<TravelCard, Float> newCardAmountTableColumn;
    @javafx.fxml.FXML
    private TableColumn<TravelCard, String> oldCardIdTableColumn;
    @javafx.fxml.FXML
    private Label newAmountLabel;
    @javafx.fxml.FXML
    private TableView<TravelCard> newCardTableView;
    @javafx.fxml.FXML
    private TableColumn<TravelCard, Float> oldCardAmountTableColumn;
    @javafx.fxml.FXML
    private TableColumn<TravelCard, String> newCardIdTableColumn;
    @javafx.fxml.FXML
    private TextField oldIdTextField;
    @javafx.fxml.FXML
    private Label newIdLabel;
    @javafx.fxml.FXML
    private Label oldAmountLabel;
    @javafx.fxml.FXML
    private TableView<TravelCard> oldCardTableVIew;
    @javafx.fxml.FXML
    private TableColumn<TravelCard, String> newCardPassengerNameTableColumn;
    private ObservableList<TravelCard> oldCardList;
    private ObservableList<TravelCard> newCardList;


    @javafx.fxml.FXML
    public void initialize() {
        newIdLabel.setText(this.generateId());

        oldCardList = FXCollections.observableArrayList();
        newCardList = FXCollections.observableArrayList();

        oldCardIdTableColumn.setCellValueFactory(new PropertyValueFactory<TravelCard, String>("cardId"));
        oldCardPassengerNameTableColumn.setCellValueFactory(new PropertyValueFactory<TravelCard, String>("passengerName"));
        oldCardAmountTableColumn.setCellValueFactory(new PropertyValueFactory<TravelCard, Float>("balance"));

        newCardIdTableColumn.setCellValueFactory(new PropertyValueFactory<TravelCard, String>("cardId"));
        newCardPassengerNameTableColumn.setCellValueFactory(new PropertyValueFactory<TravelCard, String>("passengerName"));
        newCardAmountTableColumn.setCellValueFactory(new PropertyValueFactory<TravelCard, Float>("balance"));
    }

    @javafx.fxml.FXML
    public void issueNewCardButtonOnAction(ActionEvent actionEvent) {
        String oldCardId = oldIdTextField.getText();
        File oldCardFile = new File("Updated Travel Cards by Ticketing Staff.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            if(oldCardFile.exists()) {
                fis = new FileInputStream(oldCardFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    try {
                        TravelCard oldCard = (TravelCard) ois.readObject();
                        oldCardList.add(oldCard);
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
        oldCardTableVIew.setItems(oldCardList);
        String passengerName = "";
        float amount = 0;
        boolean isMonthly = false;
        for(TravelCard card: oldCardList) {
            if(card.getCardId().equals(oldCardId)) {
                passengerName = card.getPassengerName();
                amount = card.getBalance();
                isMonthly = card.isMonthly();
                card.setDamagedOrLost(true);
                card.setActivated(false);
                oldCardList.remove(card);

            }
        }
        String newCardId = newIdLabel.getText();
        TravelCard newCard = new TravelCard(newCardId, passengerName, amount, isMonthly);
        newCardList.add(newCard);
        newCardTableView.setItems(newCardList);
        File newCardFile = new File("Updated Travel Cards after replacement by Ticketing Staff.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if(newCardFile.exists()) {
                fos = new FileOutputStream(newCardFile);
                oos = new AppendableObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(newCardFile);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(newCard);
            oos.close();
        }
        catch (Exception e) {

        }
        oldIdTextField.clear();
        oldAmountLabel.setText("Label");
        newIdLabel.setText(this.generateId());
        newAmountLabel.setText("Label");
    }

    private String generateId() {
        Random random = new Random();
        String id = Integer.toString(random.nextInt(1000, 9999));
        return id;
    }

    @javafx.fxml.FXML
    public void resetAllButtonOnAction(ActionEvent actionEvent) {
        oldCardTableVIew.getItems().clear();
        newCardTableView.getItems().clear();
    }
}