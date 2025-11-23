package com.pheonix.leavemanagement.dtos;

public class LeaveListResDto {
    private String leaveId;

    private String userId;

    private String userFullName;

    private String fromDate;

    private String toDate;

    private int numberOfDays;

    private String leaveReason;

    private String reportedToId;

    private String reportedToFullName;

    private String leaveStatus;

    private String leaveTypeName;
    private long fromDateInLong;
    private long toDateInLong;

    public String getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(String leaveId) {
        this.leaveId = leaveId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
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

    public String getReportedToFullName() {
        return reportedToFullName;
    }

    public void setReportedToFullName(String reportedToFullName) {
        this.reportedToFullName = reportedToFullName;
    }

    public String getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(String leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public String getLeaveTypeName() {
        return leaveTypeName;
    }

    public void setLeaveTypeName(String leaveTypeName) {
        this.leaveTypeName = leaveTypeName;
    }

    public long getFromDateInLong() {
        return fromDateInLong;
    }

    public void setFromDateInLong(long fromDateInLong) {
        this.fromDateInLong = fromDateInLong;
    }

    public long getToDateInLong() {
        return toDateInLong;
    }

    public void setToDateInLong(long toDateInLong) {
        this.toDateInLong = toDateInLong;
    }
}
