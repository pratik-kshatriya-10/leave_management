package com.pheonix.leavemanagement.models;

import java.io.Serial;

public class Designation extends BaseModel{

    @Serial
    private static final long serialVersionUID = -5378764032178941354L;

    private String designationId;
    private String designationName;
    private String designationCode;
    private String departmentId;

    public String getDesignationId() {
        return designationId;
    }

    public void setDesignationId(String designationId) {
        this.designationId = designationId;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getDesignationCode() {
        return designationCode;
    }

    public void setDesignationCode(String designationCode) {
        this.designationCode = designationCode;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
