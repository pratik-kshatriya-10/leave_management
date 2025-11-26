package com.pheonix.leavemanagement.dtos;

import com.pheonix.leavemanagement.models.LeaveHistory;

import java.io.Serial;

public class LeaveHistoryListDto extends LeaveHistory {
    @Serial
    private static final long serialVersionUID = 8586591298962894843L;

    private String userFullName;
    private String startDate;
    private String endDate;
    private String leaveTypeName;
    private long fromDateInLong;
    private long toDateInLong;

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
