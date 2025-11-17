package com.pheonix.leavemanagement.dtos;

import com.pheonix.leavemanagement.utils.Messages;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class DepartmentDto {

    @NotEmpty(message = Messages.REQUIRED_DEPARTMENT_NAME)
    @Size(max = 100, message = Messages.DEPARTMENT_NAME_MAX_SIZE)
    private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
