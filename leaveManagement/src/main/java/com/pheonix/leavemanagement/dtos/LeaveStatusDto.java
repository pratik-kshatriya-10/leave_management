package com.pheonix.leavemanagement.dtos;

import com.pheonix.leavemanagement.utils.Messages;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serial;
import java.io.Serializable;

public class LeaveStatusDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 4596697589435652879L;

    @NotEmpty(message = Messages.LEAVE_ID_REQUIRED)
    private String leaveId;

    @NotEmpty(message = Messages.USER_ID_REQUIRED)
    private String userId;

    private String leaveStatus;

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

    public String getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(String leaveStatus) {
        this.leaveStatus = leaveStatus;
    }
}
