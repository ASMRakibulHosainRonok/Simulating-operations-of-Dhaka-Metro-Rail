package csc305.metrorailabdullah.Passenger;

import csc305.metrorailabdullah.AppendableObjectOutputStream;
import csc305.metrorailabdullah.ModelClasses.History;
import csc305.metrorailabdullah.ModelClasses.RouteAndFare;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class CheckRoutesAndFaresViewController
{
    @javafx.fxml.FXML
    private TableView<RouteAndFare> routesAndFaresTableView;
    @javafx.fxml.FXML
    private TableColumn<RouteAndFare, String> travelTimeTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> routeOptionComboBox;
    @javafx.fxml.FXML
    private TableColumn<RouteAndFare, String> routeOptionsTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> destinationStationComboBox;
    @javafx.fxml.FXML
    private TableColumn<RouteAndFare, String> sourceStationTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> sourceStationComboBox;
    @javafx.fxml.FXML
    private TableColumn<RouteAndFare, Float> faresTableColumn;
    @javafx.fxml.FXML
    private TableColumn<RouteAndFare, String> destinationStationTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> departTimeComboBox;
    private ObservableList<RouteAndFare> routeAndFareList;
    private ObservableList<RouteAndFare> filteredRouteAndFareList;


    @javafx.fxml.FXML
    public void initialize() {
        routeAndFareList = FXCollections.observableArrayList();
        filteredRouteAndFareList = FXCollections.observableArrayList();
        sourceStationComboBox.getItems().addAll("Uttara North", "Uttara Central", "Uttara South", "Agargaon", "Karwan Bazar", "Farmgate", "Motijheel");
        destinationStationComboBox.setItems(sourceStationComboBox.getItems());

        sourceStationTableColumn.setCellValueFactory(new PropertyValueFactory<RouteAndFare, String>("source"));
        destinationStationTableColumn.setCellValueFactory(new PropertyValueFactory<RouteAndFare, String>("destination"));
        routeOptionsTableColumn.setCellValueFactory(new PropertyValueFactory<RouteAndFare, String>("routeOption"));
        travelTimeTableColumn.setCellValueFactory(new PropertyValueFactory<RouteAndFare, String>("departTime"));
        faresTableColumn.setCellValueFactory(new PropertyValueFactory<RouteAndFare, Float>("fares"));
    }

    @javafx.fxml.FXML
    public void resetButtonOnAction(ActionEvent actionEvent) {
        routesAndFaresTableView.getItems().clear();
        routesAndFaresTableView.setItems(routeAndFareList);
    }

    @javafx.fxml.FXML
    public void filterOneButtonOnAction(ActionEvent actionEvent) {
        String source = sourceStationComboBox.getValue();
        String destination = destinationStationComboBox.getValue();
        routeOptionComboBox.getItems().addAll("A", "B", "C");
        departTimeComboBox.getItems().addAll("6 am", "9 am", "12 pm", "3 pm", "6 pm");
    }

    @javafx.fxml.FXML
    public void SaveOrBookmarkButtonOnAction(ActionEvent actionEvent) {
        File routeAndFareFile = new File("Filtered Routes and Fares.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if(routeAndFareFile.exists()) {
                fos = new FileOutputStream(routeAndFareFile, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(routeAndFareFile);
                oos = new ObjectOutputStream(fos);
            }
            for(RouteAndFare route: filteredRouteAndFareList) {
                oos.writeObject(route);
            }
            oos.close();
        }
        catch (Exception e) {

        }
    }

    @javafx.fxml.FXML
    public void filterTwoButtonOnAction(ActionEvent actionEvent) {
        filteredRouteAndFareList.clear();
        String option = routeOptionComboBox.getValue();
        String departTime = departTimeComboBox.getValue();
        for(RouteAndFare route: routeAndFareList) {
            if(route.getRouteOption().equals(option) && route.getDepartTime().equals(departTime)) {
                filteredRouteAndFareList.add(route);
            }
        }
        routesAndFaresTableView.setItems(filteredRouteAndFareList);
        sourceStationComboBox.setValue(null);
        destinationStationComboBox.setValue(null);
        routeOptionComboBox.setValue(null);
        destinationStationComboBox.setValue(null);
    }
}