package com.pheonix.leavemanagement.dtos;

import com.pheonix.leavemanagement.models.Leave;
import com.pheonix.leavemanagement.utils.Constants;

public class LeaveDto {
    private String userId;

    private String leaveTypeName;

    private String fromDate;

    private String toDate;

    private int numberOfDays;

    private String leaveReason;

    private String reportedToId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLeaveTypeName() {
        return leaveTypeName;
    }

    public void setLeaveTypeName(String leaveTypeName) {
        this.leaveTypeName = leaveTypeName;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getReportedToId() {
        return reportedToId;
    }

    public void setReportedToId(String reportedToId) {
        this.reportedToId = reportedToId;
    }

    public Leave buildLeave() {
        Leave model = new Leave();
        model.setUserId(this.userId);
        model.setLeaveTypeName(this.leaveTypeName);
        model.setNumberOfDays(this.numberOfDays);
        model.setLeaveReason(this.leaveReason);
        model.setReportedToId(this.reportedToId);
        return model;
    }
}
