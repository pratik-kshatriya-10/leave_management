package com.pheonix.leavemanagement.daos;

import com.pheonix.leavemanagement.dtos.LeaveListDto;
import com.pheonix.leavemanagement.dtos.PaginationDto;
import com.pheonix.leavemanagement.models.Leave;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LeaveDao {

    int addLeave(Leave model);

    int updateLeave(@Param("model")Leave model,
                    @Param("leaveId") String leaveId);

    boolean leaveIdExist(@Param("leaveId") String leaveId);

    int deleteLeave(@Param("model") Leave model,
                    @Param("leaveId") String leaveId);

    Leave fetchLeave(@Param("leaveId") String leaveId);

    int fetchLeaveCount(@Param("paginationDto") PaginationDto paginationDto);

    List<LeaveListDto> fetchLeaveList(@Param("paginationDto") PaginationDto paginationDto);
}
