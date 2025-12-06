package csc305.metrorailabdullah.ModelClasses;

import java.io.Serializable;
import java.time.LocalDate;

public class SpecialTravelCard extends TravelCard implements Serializable {
    private String status;
    private float discountPrivilege;
    private LocalDate finalDate;

    public SpecialTravelCard(String cardId, String passengerName, float balance, boolean isMonthly, String status, float discountPrivilege, LocalDate finalDate) {
        super(cardId, passengerName, balance, isMonthly);
        this.status = status;
        this.discountPrivilege = discountPrivilege;
        this.finalDate = finalDate;
    }

    public String getStatus() {
        return status;
    }

    public float getDiscountPrivilege() {
        return discountPrivilege;
    }

    public LocalDate getFinalDate() {
        return finalDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDiscountPrivilege(float discountPrivilege) {
        this.discountPrivilege = discountPrivilege;
    }

    public void setFinalDate(LocalDate finalDate) {
        this.finalDate = finalDate;
    }

    @Override
    public String toString() {
        return "SpecialTravelCard{" +
                "status='" + status + '\'' +
                ", discountPrivilege=" + discountPrivilege +
                ", finalDate=" + finalDate +
                ", cardId='" + cardId + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", balance=" + balance +
                ", isDamagedOrLost=" + isDamagedOrLost +
                ", isActivated=" + isActivated +
                ", isMonthly=" + isMonthly +
                '}';
    }
}
