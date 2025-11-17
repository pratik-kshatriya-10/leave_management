package com.pheonix.leavemanagement.daos;

import com.pheonix.leavemanagement.dtos.PaginationDto;
import com.pheonix.leavemanagement.models.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DepartmentDao {

    int addDepartment(Department model);

    boolean departmentCodeExists(@Param("departmentCode") String departmentCode);

    boolean departmentCodeExistsOtherThan(@Param("departmentCode") String departmentCode,
                                          @Param("departmentId") String departmentId);

    int updateDepartment(@Param("model") Department model,
                         @Param("departmentId") String departmentId);

    boolean departmentIdExist(@Param("departmentId") String departmentId);

    int deleteDepartment(@Param("model") Department model,
                         @Param("departmentId") String departmentId);

    Department fetchDepartment(@Param("departmentId") String departmentId);

    int fetchDepartmentCount(@Param("paginationDto") PaginationDto paginationDto);

    List<Department> fetchDepartmentList(@Param("paginationDto") PaginationDto paginationDto);
}
