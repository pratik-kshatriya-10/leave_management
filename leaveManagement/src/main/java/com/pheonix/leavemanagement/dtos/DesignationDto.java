package com.pheonix.leavemanagement.dtos;

import com.pheonix.leavemanagement.models.Designation;
import com.pheonix.leavemanagement.utils.Messages;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;

public class DesignationDto implements Serializable {
    @Serial
    private static final long serialVersionUID = -7651473701442089785L;

    @NotEmpty(message = Messages.REQUIRED_DESIGNATION_NAME)
    @Size(max = 100, message = Messages.DESIGNATION_NAME_MAX_SIZE)
    private String designationName;

    private String departmentId;

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Designation buildDesignation(String designationCode) {
        Designation model = new Designation();
        model.setDesignationName(this.designationName);
        model.setDesignationCode(designationCode);
        model.setDepartmentId(this.departmentId);
        return model;

    }
}
