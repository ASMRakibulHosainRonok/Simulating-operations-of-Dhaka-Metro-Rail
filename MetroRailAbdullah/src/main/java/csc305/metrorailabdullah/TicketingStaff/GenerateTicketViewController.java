package csc305.metrorailabdullah.TicketingStaff;

import csc305.metrorailabdullah.AppendableObjectOutputStream;
import csc305.metrorailabdullah.ModelClasses.Ticket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Random;

public class GenerateTicketViewController
{
    @javafx.fxml.FXML
    private DatePicker travelDatePicker;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TableColumn<Ticket, String> ticketIdTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Ticket, LocalDate> travelDateTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> destinationStationComboBox;
    @javafx.fxml.FXML
    private TableColumn<Ticket, String> sourceStationTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> sourceStationComboBox;
    @javafx.fxml.FXML
    private TableColumn<Ticket, String> destinationStationTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Ticket, String> passengerNameTableColumn;
    @javafx.fxml.FXML
    private Label idLabel;
    @javafx.fxml.FXML
    private TableView<Ticket> ticketTableView;
    @javafx.fxml.FXML
    private Label purchaseDateLabel;
    @javafx.fxml.FXML
    private TableColumn<Ticket, LocalDate> purchaseDateTableColumn;
    private ObservableList<Ticket> ticketList;

    @javafx.fxml.FXML
    public void initialize() {
        idLabel.setText(this.generateId());
        ticketList = FXCollections.observableArrayList();

        destinationStationComboBox.getItems().addAll("Uttara North", "Uttara Central", "Uttara South", "Agargaon", "Karwan Bazar", "Farmgate", "Motijheel");
        sourceStationComboBox.setItems(destinationStationComboBox.getItems());

        ticketIdTableColumn.setCellValueFactory(new PropertyValueFactory<Ticket, String>("id"));
        passengerNameTableColumn.setCellValueFactory(new PropertyValueFactory<Ticket, String>("name"));
        purchaseDateTableColumn.setCellValueFactory(new PropertyValueFactory<Ticket, LocalDate>("purchaseDate"));
        sourceStationTableColumn.setCellValueFactory(new PropertyValueFactory<Ticket, String>("source"));
        destinationStationTableColumn.setCellValueFactory(new PropertyValueFactory<Ticket, String>("destination"));
        travelDateTableColumn.setCellValueFactory(new PropertyValueFactory<Ticket, LocalDate>("travelDate"));
    }

    @javafx.fxml.FXML
    public void resetButtonOnAction(ActionEvent actionEvent) {
        ticketTableView.getItems().clear();
    }

    @javafx.fxml.FXML
    public void generateTicketButtonOnAction(ActionEvent actionEvent) {
        ticketTableView.getItems().clear();
        String id = idLabel.getText();
        String name = nameTextField.getText();
        String source = sourceStationComboBox.getValue();
        String destination = destinationStationComboBox.getValue();
        LocalDate purchaseDate = LocalDate.now();
        purchaseDateLabel.setText(purchaseDate.toString());
        LocalDate travelDate = travelDatePicker.getValue();

        Ticket tick = new Ticket(id, name, source, destination, purchaseDate, travelDate);
        ticketList.add(tick);
        ticketTableView.setItems(ticketList);
        File ticketFile = new File("Tickets by Ticketing Staff.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if(ticketFile.exists()) {
                fos = new FileOutputStream(ticketFile, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(ticketFile);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(tick);
            oos.close();
        }
        catch(Exception e) {

        }
        nameTextField.clear();
        idLabel.setText(this.generateId());
        purchaseDateLabel.setText(LocalDate.now().toString());
        sourceStationComboBox.setValue(null);
        destinationStationComboBox.setValue(null);
        travelDatePicker.setValue(null);
    }

    private String generateId() {
        Random random = new Random();
        String id = Integer.toString(random.nextInt(10000, 99999));
        return id;
    }

}