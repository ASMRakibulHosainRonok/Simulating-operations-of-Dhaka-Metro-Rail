package csc305.metrorailabdullah.ModelClasses;

import csc305.metrorailabdullah.User;

import java.io.Serializable;

public class Dependent extends User implements Serializable {
    private String travelPermission, paymentMethod;

    public Dependent(String id, String name, String email, String password, String phoneNo, String travelPermission, String paymentMethod) {
        super(id, name, email, password, phoneNo);
        this.travelPermission = travelPermission;
        this.paymentMethod = paymentMethod;
    }

    public String getTravelPermission() {
        return travelPermission;
    }

    public void setTravelPermission(String travelPermission) {
        this.travelPermission = travelPermission;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Dependent{" +
                "travelPermission='" + travelPermission + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
