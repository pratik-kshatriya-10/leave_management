package com.pheonix.leavemanagement.models;

import java.io.Serial;

public class LeaveHistory extends BaseModel{

    @Serial
    private static final long serialVersionUID = 6333583014917280545L;

    private String leaveHistoryId;
    private String leaveId;
    private String userId;
    private String status;

    public String getLeaveHistoryId() {
        return leaveHistoryId;
    }

    public void setLeaveHistoryId(String leaveHistoryId) {
        this.leaveHistoryId = leaveHistoryId;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
