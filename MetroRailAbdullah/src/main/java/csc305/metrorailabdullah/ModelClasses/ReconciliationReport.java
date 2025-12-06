package csc305.metrorailabdullah.ModelClasses;

import java.io.Serializable;
import java.time.LocalDate;

public class ReconciliationReport implements Serializable {
    private String reconReportId, salesReportId, staffName;
    private SalesReport report;
    private float physicalCash, onlineCash, refunds, balance;
    private LocalDate reportDate;

    public ReconciliationReport(String reconReportId, String staffName, SalesReport report, float physicalCash, float onlineCash, float refunds, LocalDate reportDate) {
        this.reconReportId = reconReportId;
        this.staffName = staffName;
        this.report = report;
        this.salesReportId = report.getReportId();
        this.physicalCash = physicalCash;
        this.onlineCash = onlineCash;
        this.refunds = refunds;
        this.balance = this.onlineCash - this.physicalCash;
        this.reportDate = reportDate;
    }

    public String getReconReportId() {
        return reconReportId;
    }

    public String getSalesReportId() {
        return salesReportId;
    }

    public String getStaffName() {
        return staffName;
    }

    public SalesReport getReport() {
        return report;
    }

    public float getPhysicalCash() {
        return physicalCash;
    }

    public float getRefunds() {
        return refunds;
    }

    public float getOnlineCash() {
        return onlineCash;
    }

    public float getBalance() {
        return balance;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setSalesReportId(String salesReportId) {
        this.salesReportId = salesReportId;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setReport(SalesReport report) {
        this.report = report;
    }

    public void setPhysicalCash(float physicalCash) {
        this.physicalCash = physicalCash;
        this.setBalance();
    }

    public void setOnlineCash(float onlineCash) {
        this.onlineCash = onlineCash;
        this.setBalance();
    }

    public void setRefunds(float refunds) {
        this.refunds = refunds;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    private void setBalance() {
        this.balance = this.onlineCash - this.physicalCash;
    }

    @Override
    public String toString() {
        return "ReconciliationReport{" +
                "reconReportId='" + reconReportId + '\'' +
                ", salesReportId='" + salesReportId + '\'' +
                ", staffName='" + staffName + '\'' +
                ", report=" + report +
                ", physicalCash=" + physicalCash +
                ", onlineCash=" + onlineCash +
                ", refunds=" + refunds +
                ", balance=" + balance +
                ", reportDate=" + reportDate +
                '}';
    }
}
