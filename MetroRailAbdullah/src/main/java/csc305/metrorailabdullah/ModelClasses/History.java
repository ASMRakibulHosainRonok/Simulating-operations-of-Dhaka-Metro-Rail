package csc305.metrorailabdullah.ModelClasses;

import java.io.Serializable;
import java.time.LocalDate;

public class History implements Serializable {
    private String historyId, passengerId, id, route, paymentMethod;
    private LocalDate journeyDate, purchaseDate;
    private float fares;

    public History(String historyId, String passengerId, String id, String route, String paymentMethod, LocalDate journeyDate, LocalDate purchaseDate, float fares) {
        this.historyId = historyId;
        this.passengerId = passengerId;
        this.id = id;
        this.route = route;
        this.paymentMethod = paymentMethod;
        this.journeyDate = journeyDate;
        this.purchaseDate = purchaseDate;
        this.fares = fares;
    }

    public String getHistoryId() {
        return historyId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getId() {
        return id;
    }

    public String getRoute() {
        return route;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public LocalDate getJourneyDate() {
        return journeyDate;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public float getFares() {
        return fares;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setJourneyDate(LocalDate journeyDate) {
        this.journeyDate = journeyDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setFares(float fares) {
        this.fares = fares;
    }

    @Override
    public String toString() {
        return "History{" +
                "historyId='" + historyId + '\'' +
                ", passengerId='" + passengerId + '\'' +
                ", id='" + id + '\'' +
                ", route='" + route + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", journeyDate=" + journeyDate +
                ", purchaseDate=" + purchaseDate +
                ", fares=" + fares +
                '}';
    }
}
