package csc305.metrorailabdullah.ModelClasses;

import java.io.Serializable;
import java.time.LocalDate;

public class SalesReport implements Serializable {
    private String reportId, staffName, routeOption, counterId;
    private int noOfTicketsSold, noOfUsage;
    private float revenues;
    private LocalDate reportDate;

    public SalesReport(String reportId, String staffName, String routeOption, String counterId, int noOfTicketsSold, int noOfUsage, float revenues, LocalDate reportDate) {
        this.reportId = reportId;
        this.staffName = staffName;
        this.routeOption = routeOption;
        this.counterId = counterId;
        this.noOfTicketsSold = noOfTicketsSold;
        this.noOfUsage = noOfUsage;
        this.revenues = revenues;
        this.reportDate = reportDate;
    }

    public String getReportId() {
        return reportId;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getRouteOption() {
        return routeOption;
    }

    public String getCounterId() {
        return counterId;
    }

    public int getNoOfTicketsSold() {
        return noOfTicketsSold;
    }

    public int getNoOfUsage() {
        return noOfUsage;
    }

    public float getRevenues() {
        return revenues;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setRouteOption(String routeOption) {
        this.routeOption = routeOption;
    }

    public void setCounterId(String counterId) {
        this.counterId = counterId;
    }

    public void setNoOfTicketsSold(int noOfTicketsSold) {
        this.noOfTicketsSold = noOfTicketsSold;
    }

    public void setNoOfUsage(int noOfUsage) {
        this.noOfUsage = noOfUsage;
    }

    public void setRevenues(float revenues) {
        this.revenues = revenues;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    @Override
    public String toString() {
        return "SalesReport{" +
                "reportId='" + reportId + '\'' +
                ", staffName='" + staffName + '\'' +
                ", routeOption='" + routeOption + '\'' +
                ", counterId='" + counterId + '\'' +
                ", noOfTicketsSold=" + noOfTicketsSold +
                ", noOfUsage=" + noOfUsage +
                ", revenues=" + revenues +
                ", reportDate=" + reportDate +
                '}';
    }
}
