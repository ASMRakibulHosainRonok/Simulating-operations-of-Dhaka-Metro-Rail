package csc305.metrorailabdullah.ModelClasses;

import java.io.Serializable;
import java.time.LocalDate;

public class Ticket implements Serializable {
    private String id, name, source, destination;
    private LocalDate purchaseDate, travelDate;

    public Ticket(String id, String name, String source, String destination, LocalDate purchaseDate, LocalDate travelDate) {
        this.id = id;
        this.name = name;
        this.source = source;
        this.destination = destination;
        this.purchaseDate = purchaseDate;
        this.travelDate = travelDate;
    }

    public String getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id='" + id + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", travelDate=" + travelDate +
                '}';
    }
}
