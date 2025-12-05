package csc305.metrorailabdullah.ModelClasses;

import java.io.Serializable;

public class TravelCard implements Serializable {
    protected String cardId, passengerName;
    protected float balance;
    protected boolean isDamagedOrLost, isActivated, isMonthly;

    public TravelCard(String cardId, String passengerName, float balance, boolean isMonthly) {
        this.cardId = cardId;
        this.passengerName = passengerName;
        this.balance = balance;
        this.isMonthly = isMonthly;
    }

    public String getCardId() {
        return cardId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public float getBalance() {
        return balance;
    }

    public boolean isDamagedOrLost() {
        return isDamagedOrLost;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public boolean isMonthly() {
        return isMonthly;
    }

    public void setMonthly(boolean monthly) {
        isMonthly = monthly;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setDamagedOrLost(boolean damagedOrLost) {
        isDamagedOrLost = damagedOrLost;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    @Override
    public String toString() {
        return "TravelCard{" +
                "cardId='" + cardId + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", balance=" + balance +
                ", isDamagedOrLost=" + isDamagedOrLost +
                ", isActivated=" + isActivated +
                '}';
    }
}
