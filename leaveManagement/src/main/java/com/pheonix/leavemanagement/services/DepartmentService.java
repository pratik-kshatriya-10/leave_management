package com.pheonix.leavemanagement.services;

import com.pheonix.leavemanagement.dtos.DepartmentDto;
import com.pheonix.leavemanagement.dtos.PaginationDto;
import com.pheonix.leavemanagement.models.Department;
import com.pheonix.leavemanagement.utils.Messages;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public interface DepartmentService {
    int addDepartment(@Valid DepartmentDto dto);

    int updateDepartment(@Valid DepartmentDto dto,
                         @NotEmpty(message = Messages.REQUIRED_DEPARTMENT_ID) String departmentId);

    int deleteDepartment(@NotEmpty(message = Messages.REQUIRED_DEPARTMENT_ID) String departmentId);

    Department fetchDepartment(@NotEmpty(message = Messages.REQUIRED_DEPARTMENT_ID) String departmentId);

    int fetchDepartmentCount(PaginationDto paginationDto);

    List<Department> fetchDepartmentList(PaginationDto paginationDto);
}
