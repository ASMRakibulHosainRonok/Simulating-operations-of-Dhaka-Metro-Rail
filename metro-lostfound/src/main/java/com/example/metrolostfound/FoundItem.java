package com.example.metrolostfound;

public class FoundItem {
    private String description;
    private String locationFound;
    private String timeFound;
    private String color;

    public String getLocationFound() {
        return locationFound;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public String getTimeFound() {
        return timeFound;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocationFound(String locationFound) {
        this.locationFound = locationFound;
    }

    public void setTimeFound(String timeFound) {
        this.timeFound = timeFound;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public FoundItem(String description, String locationFound, String timeFound) {
        this.description = description;
        this.locationFound = locationFound;
        this.timeFound = timeFound;
        this.color = color;
    }


}

