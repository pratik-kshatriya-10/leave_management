package com.pheonix.leavemanagement.daos;

import com.pheonix.leavemanagement.dtos.PaginationDto;
import com.pheonix.leavemanagement.models.Designation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface DesignationDao {
    int addDesignation(Designation model);

    boolean designationCodeExists(@Param("designationCode") String designationCode);

    boolean designationIdExist(@Param("designationId") String designationId);

    boolean designationCodeExistsOtherThan(@Param("designationCode") String designationCode,
                                           @Param("designationId") String designationId);

    int updateDesignation(@Param("model") Designation model,
                          @Param("designationId") String designationId);

    int deleteDesignation(@Param("model") Designation model,
                          @Param("designationId") String designationId);

    Designation fetchDesignation(String designationId);

    int fetchDesignationCount(@Param("paginationDto") PaginationDto paginationDto);

    List<Designation> fetchDesignationList(@Param("paginationDto") PaginationDto paginationDto);
}
