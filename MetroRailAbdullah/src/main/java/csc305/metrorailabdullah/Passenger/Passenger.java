package csc305.metrorailabdullah.Passenger;

import csc305.metrorailabdullah.ModelClasses.*;
import csc305.metrorailabdullah.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.Random;

public class Passenger extends User implements Serializable {
    private String emergencyContact, passengerType;
    private boolean isEligible;

    public Passenger(String id, String name, String email, String password, String phoneNo, String emergencyContact) {
        super(id, name, email, password, phoneNo);
        this.emergencyContact = emergencyContact;
       // this.passengerType = passengerType;
       // this.isEligible = isEligible;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public boolean isEligible() {
        return isEligible;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "emergencyContact='" + emergencyContact + '\'' +
                ", passengerType='" + passengerType + '\'' +
                ", isEligible=" + isEligible +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

    public boolean purchaseTicket(Ticket tick) {
        return true;
    }

    public boolean rechargeTravelCard(TravelCard card) {
        return true;
    }

    public boolean checkRoutesAndFares(RouteAndFare route) {
        return true;
    }

    public boolean checkLiveStatus(Schedule routine) {
        return true;
    }

    public boolean applyForRefund(IssueReport report) {
        return true;
    }

    public boolean provideFeedback(Feedback feed) {
        return true;
    }

    public ObservableList<History> seeHistory() {
        ObservableList<History> histories = FXCollections.observableArrayList();
        return histories;
    }

    public boolean manageLinkedUser(Dependent user) {
        return true;
    }

}
