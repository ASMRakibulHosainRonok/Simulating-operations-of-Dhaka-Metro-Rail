package csc305.metrorailabdullah.TicketingStaff;

import csc305.metrorailabdullah.ModelClasses.*;
import csc305.metrorailabdullah.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;

public class TicketingStaff extends User implements Serializable {
    private String counterId;
    private int shiftHours;

    public TicketingStaff(String id, String name, String email, String password, String phoneNo) {
        super(id, name, email, password, phoneNo);
        //this.counterId = counterId;
        //this.shiftHours = shiftHours;
    }

    public String getCounterId() {
        return counterId;
    }

    public int getShiftHours() {
        return shiftHours;
    }

    public void setCounterId(String counterId) {
        this.counterId = counterId;
    }

    public void setShiftHours(int shiftHours) {
        this.shiftHours = shiftHours;
    }

    @Override
    public String toString() {
        return "TicketingStaff{" +
                "counterId='" + counterId + '\'' +
                ", shiftHours=" + shiftHours +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

    public boolean generateTicket(Ticket tick) {
        return true;
    }

    public ObservableList<SalesReport> generateSalesReport() {
        ObservableList<SalesReport> report = FXCollections.observableArrayList();
        return report;
    }

    public ObservableList<ReconciliationReport> generateReconciliationReport() {
        ObservableList<ReconciliationReport> report = FXCollections.observableArrayList();
        return report;
    }

    public boolean rechargeTravelCardByTicketingStaff(TravelCard card) {
        return true;
    }

    public boolean replaceTravelCard(TravelCard card) {
        return true;
    }

    public boolean monitorGates(Gate g) {
        return true;
    }

    public boolean checkComplaint(Complaint report) {
        return  true;
    }

    public boolean generateSpecialPass(SpecialTravelCard card) {
        return true;
    }

}
