package com.pheonix.leavemanagement.models;

import java.io.Serial;

public class LeaveType extends BaseModel{

    @Serial
    private static final long serialVersionUID = 5358018195194393213L;

    private String leaveTypeId;
    private String leaveTypeName;
    private String leaveTypeCode;

    public String getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(String leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public String getLeaveTypeName() {
        return leaveTypeName;
    }

    public void setLeaveTypeName(String leaveTypeName) {
        this.leaveTypeName = leaveTypeName;
    }

    public String getLeaveTypeCode() {
        return leaveTypeCode;
    }

    public void setLeaveTypeCode(String leaveTypeCode) {
        this.leaveTypeCode = leaveTypeCode;
    }
}
