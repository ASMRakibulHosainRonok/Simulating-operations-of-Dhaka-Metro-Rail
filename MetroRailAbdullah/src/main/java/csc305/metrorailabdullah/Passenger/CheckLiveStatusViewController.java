package csc305.metrorailabdullah.Passenger;

import csc305.metrorailabdullah.AppendableObjectOutputStream;
import csc305.metrorailabdullah.ModelClasses.RouteAndFare;
import csc305.metrorailabdullah.ModelClasses.Schedule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class CheckLiveStatusViewController
{
    @javafx.fxml.FXML
    private Button statusButton;
    @javafx.fxml.FXML
    private TableColumn<Schedule, String> travelTimeTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Schedule, String> liveRouteOptionTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> routeOptionComboBox;
    @javafx.fxml.FXML
    private TableColumn<Schedule, String> statusTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Schedule, String> sourceStationTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> sourceStationComboBox;
    @javafx.fxml.FXML
    private TableColumn<Schedule, String> destinationStationTableColumn;
    private ObservableList<Schedule> scheduleList;
    private ObservableList<Schedule> filteredScheduleList;
    @javafx.fxml.FXML
    private TableView<Schedule> liveStatusTableView;
    @javafx.fxml.FXML
    private Label sourceLabel;
    @javafx.fxml.FXML
    private Label routeLabel;

    @javafx.fxml.FXML
    public void initialize() {
        sourceLabel.setText("Label");
        routeLabel.setText("Label");
        scheduleList = FXCollections.observableArrayList();
        filteredScheduleList = FXCollections.observableArrayList();

        sourceStationComboBox.getItems().addAll("Uttara North", "Uttara Central", "Uttara South", "Agargaon", "Karwan Bazar", "Farmgate", "Motijheel");
        routeOptionComboBox.getItems().addAll("A", "B", "C");

        sourceStationTableColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("source"));
        destinationStationTableColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("destination"));
        liveRouteOptionTableColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("routeOption"));
        travelTimeTableColumn.setCellValueFactory(new  PropertyValueFactory<Schedule, String>("departTime"));
        statusTableColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("status"));
    }

    @javafx.fxml.FXML
    public void sourceStationComboBoxOnAction(ActionEvent actionEvent) {
        String option = sourceStationComboBox.getValue();
        statusButton.setDisable(false);
        sourceLabel.setText(option);
    }

    @javafx.fxml.FXML
    public void routeOptionComboBoxOnAction(ActionEvent actionEvent) {
        String option = routeOptionComboBox.getValue();
        statusButton.setDisable(false);
        routeLabel.setText(option);
    }

    @javafx.fxml.FXML
    public void seeStatusButtonOnAction(ActionEvent actionEvent) {
        liveStatusTableView.getItems().clear();
        String source = sourceLabel.getText();
        String route = routeLabel.getText();
        if(source.equals("Label")) {
            for(Schedule routine: scheduleList) {
                if(routine.getRouteOption().equals(route)) {
                    filteredScheduleList.add(routine);
                }
            }
            liveStatusTableView.setItems(filteredScheduleList);
            routeOptionComboBox.setValue(null);
            statusButton.setDisable(true);
        }
        else if(route.equals("Label")) {
            for(Schedule routine: scheduleList) {
                if(routine.getSource().equals(source)) {
                    filteredScheduleList.add(routine);
                }
            }
            liveStatusTableView.setItems(filteredScheduleList);
            sourceStationComboBox.setValue(null);
            statusButton.setDisable(true);
        }
    }

    @javafx.fxml.FXML
    public void subscribeForAlertsButtonOnAction(ActionEvent actionEvent) {
        File scheduleFile = new File("Filtered Schedules.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if(scheduleFile.exists()) {
                fos = new FileOutputStream(scheduleFile, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(scheduleFile);
                oos = new ObjectOutputStream(fos);
            }
            for(Schedule routine: filteredScheduleList) {
                oos.writeObject(routine);
            }
            oos.close();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void resetButtonOnAction(ActionEvent actionEvent) {
        liveStatusTableView.getItems().clear();
        liveStatusTableView.setItems(scheduleList);
    }
}