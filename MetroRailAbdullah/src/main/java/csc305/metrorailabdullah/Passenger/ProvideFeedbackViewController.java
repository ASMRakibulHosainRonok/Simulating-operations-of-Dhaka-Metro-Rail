package csc305.metrorailabdullah.Passenger;

import csc305.metrorailabdullah.AppendableObjectOutputStream;
import csc305.metrorailabdullah.ModelClasses.Feedback;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ProvideFeedbackViewController
{
    @javafx.fxml.FXML
    private ComboBox<String> routeComboBox;
    @javafx.fxml.FXML
    private TextArea commentTextArea;
    @javafx.fxml.FXML
    private TableView<Feedback> feedbackTableView;
    @javafx.fxml.FXML
    private TableColumn<Feedback, String> routeTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Feedback, String> ratingTableColumn;
    @javafx.fxml.FXML
    private TableColumn<Feedback, String> commentTableColumn;
    @javafx.fxml.FXML
    private ComboBox<String> ratingComboBox;
    @javafx.fxml.FXML
    private Label routeLabel;
    private ObservableList<Feedback> feedbackList;

    @javafx.fxml.FXML
    public void initialize() {
        feedbackList = FXCollections.observableArrayList();

        routeComboBox.getItems().addAll("A", "B", "C");
        ratingComboBox.getItems().addAll("0", "0.5", "1", "1.5", "2", "2.5", "3", "3.5", "4", "4.5", "5");

        routeTableColumn.setCellValueFactory(new PropertyValueFactory<Feedback, String>("route"));
        ratingTableColumn.setCellValueFactory(new PropertyValueFactory<Feedback, String>("rating"));
        commentTableColumn.setCellValueFactory(new PropertyValueFactory<Feedback, String>("comment"));
    }

    @javafx.fxml.FXML
    public void reviewButtonOnAction(ActionEvent actionEvent) {
        String route = routeComboBox.getValue();
        routeLabel.setText(route);
        ratingComboBox.setDisable(false);
    }

    @javafx.fxml.FXML
    public void submitButtonOnAction(ActionEvent actionEvent) {
        feedbackTableView.getItems().clear();
        String route = routeLabel.getText();
        String rating = ratingComboBox.getValue();
        String comment = commentTextArea.getText();
        File feedbackFile = new File("Feedbacks.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if(feedbackFile.exists()) {
                fos = new FileOutputStream(feedbackFile, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(feedbackFile);
                oos = new ObjectOutputStream(fos);
            }
            if(comment.equals(null)) {
                Feedback feed = new Feedback(route, rating);
                feedbackList.add(feed);
                oos.writeObject(feed);
            }
            else {
                Feedback feed = new Feedback(route, rating, comment);
                feedbackList.add(feed);
                oos.writeObject(feed);
            }
            feedbackTableView.setItems(feedbackList);
            oos.close();
        }
        catch(Exception e) {

        }
        routeComboBox.setValue(null);
        ratingComboBox.setValue(null);
        ratingComboBox.setDisable(true);
        commentTextArea.clear();
    }

    @javafx.fxml.FXML
    public void resetButtonOnAction(ActionEvent actionEvent) {
        feedbackTableView.getItems().clear();
    }
}