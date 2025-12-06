package csc305.metrorailabdullah.ModelClasses;

import java.io.Serial;
import java.io.Serializable;

public class Complaint implements Serializable {
    private String complaintId, ticketId, transactionStatus;

    public Complaint(String complaintId, String ticketId, String transactionStatus) {
        this.complaintId = complaintId;
        this.ticketId = ticketId;
        this.transactionStatus = transactionStatus;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Override
    public String toString() {
        return "Complaint{" +
                "complaintId='" + complaintId + '\'' +
                ", ticketId='" + ticketId + '\'' +
                ", transactionStatus='" + transactionStatus + '\'' +
                '}';
    }
}
