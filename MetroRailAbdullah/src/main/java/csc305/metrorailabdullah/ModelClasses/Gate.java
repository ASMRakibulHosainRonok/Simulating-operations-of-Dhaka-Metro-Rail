package csc305.metrorailabdullah.ModelClasses;

import java.io.Serializable;
import java.time.LocalDate;

public class Gate implements Serializable {
    private String gateNo, accessTime;
    private LocalDate accessDate;
    private boolean isMalfunctioned;
    private int noOfSuccessfulScans, noOfFailedScans;

    public Gate(String gateNo, String accessTime, LocalDate accessDate, boolean isMalfunctioned, int noOfSuccessfulScans, int noOfFailedScans) {
        this.gateNo = gateNo;
        this.accessTime = accessTime;
        this.accessDate = accessDate;
        this.isMalfunctioned = isMalfunctioned;
        this.noOfSuccessfulScans = noOfSuccessfulScans;
        this.noOfFailedScans = noOfFailedScans;
    }

    public String getGateNo() {
        return gateNo;
    }

    public String getAccessTime() {
        return accessTime;
    }

    public LocalDate getAccessDate() {
        return accessDate;
    }

    public boolean isMalfunctioned() {
        return isMalfunctioned;
    }

    public int getNoOfSuccessfulScans() {
        return noOfSuccessfulScans;
    }

    public int getNoOfFailedScans() {
        return noOfFailedScans;
    }

    public void setAccessTime(String accessTime) {
        this.accessTime = accessTime;
    }

    public void setAccessDate(LocalDate accessDate) {
        this.accessDate = accessDate;
    }

    public void setMalfunctioned(boolean malfunctioned) {
        isMalfunctioned = malfunctioned;
    }

    public void setNoOfSuccessfulScans(int noOfSuccessfulScans) {
        this.noOfSuccessfulScans = noOfSuccessfulScans;
    }

    public void setNoOfFailedScans(int noOfFailedScans) {
        this.noOfFailedScans = noOfFailedScans;
    }

    public void setGateNo(String gateNo) {
        this.gateNo = gateNo;
    }

    @Override
    public String toString() {
        return "Gate{" +
                "gateNo='" + gateNo + '\'' +
                ", accessTime='" + accessTime + '\'' +
                ", accessDate=" + accessDate +
                ", isMalfunctioned=" + isMalfunctioned +
                ", noOfSuccessfulScans=" + noOfSuccessfulScans +
                ", noOfFailedScans=" + noOfFailedScans +
                '}';
    }
}
