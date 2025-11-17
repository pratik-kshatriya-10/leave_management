package com.pheonix.leavemanagement.models;

import java.io.Serial;

public class Department extends BaseModel{
    @Serial
    private static final long serialVersionUID = 2343643529660685542L;

    private String departmentId;
    private String departmentName;
    private String departmentCode;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}
