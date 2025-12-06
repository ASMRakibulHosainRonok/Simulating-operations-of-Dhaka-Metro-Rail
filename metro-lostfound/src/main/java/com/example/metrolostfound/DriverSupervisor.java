package com.example.metrolostfound;

public class DriverSupervisor {
    private String DriverName;
    private String CarNumber;
    private String ContactInfo;
    @Override
    public String toString() {
        return "DriverSupervisor{" +
                "DriverName='" + DriverName + '\'' +
                ", CarNumber='" + CarNumber + '\'' +
                ", ContactInfo='" + ContactInfo + '\'' +
                '}';
    }

    public DriverSupervisor(String driverName, String carNumber, String contactInfo) {
        DriverName = driverName;
        CarNumber = carNumber;
        ContactInfo = contactInfo;
    }

    public String getContactInfo() {
        return ContactInfo;
    }

    public void setContactInfo(String contactInfo) {
        ContactInfo = contactInfo;
    }



    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public String getCarNumber() {
        return CarNumber;
    }

    public void setCarNumber(String carNumber) {
        CarNumber = carNumber;
    }

    public DriverSupervisor(String driverName, String carNumber) {
        DriverName = driverName;
        CarNumber = carNumber;
    }
}
