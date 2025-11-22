package com.pheonix.leavemanagement.dtos;

import com.pheonix.leavemanagement.utils.Messages;
import jakarta.validation.constraints.NotEmpty;

public class LeaveHistoryByUserDto extends PaginationDto{
    @NotEmpty(message = Messages.USER_ID_REQUIRED)
    private String userId;

    private String startDate;

    private String endDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
}
