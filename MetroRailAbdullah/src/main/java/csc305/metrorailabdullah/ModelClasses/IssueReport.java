package csc305.metrorailabdullah.ModelClasses;

import java.io.Serializable;

public class IssueReport implements Serializable {
    private String reportId, ticketId, passengerName, issue;

    public IssueReport(String reportId, String ticketId, String passengerName, String issue) {
        this.reportId = reportId;
        this.ticketId = ticketId;
        this.passengerName = passengerName;
        this.issue = issue;
    }

    public String getReportId() {
        return reportId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getIssue() {
        return issue;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    @Override
    public String toString() {
        return "IssueReport{" +
                "reportId='" + reportId + '\'' +
                ", ticketId='" + ticketId + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", issue='" + issue + '\'' +
                '}';
    }
}
