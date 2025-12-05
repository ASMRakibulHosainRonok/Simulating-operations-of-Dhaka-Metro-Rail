package com.example.metrolostfound;

public class LostItem {

    private String description;
    private String color;
    private String station;   // location
    private String dateLost;

    public LostItem(String description, String color, String station) {
        this.description = description;
        this.color = color;
        this.station = station;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDateLost(String dateLost) {
        this.dateLost = dateLost;
    }

    public void setStation(String station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "LostItem{" +
                "description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", station='" + station + '\'' +
                ", dateLost='" + dateLost + '\'' +
                '}';
    }

    public String getDescription() { return description; }
    public String getColor() { return color; }
    public String getStation() { return station; }
    public String getDateLost() { return dateLost; }
}



