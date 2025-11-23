package com.pheonix.leavemanagement.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class LeaveListReqDto extends PaginationDto {

    private String leaveStatus;
    private String leaveTypeName;
    private String fromDate;
    private String toDate;
    @JsonIgnore
    private long fromDateInLong;
    @JsonIgnore
    private long toDateInLong;

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
