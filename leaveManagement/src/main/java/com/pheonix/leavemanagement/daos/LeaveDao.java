package com.pheonix.leavemanagement.daos;

import com.pheonix.leavemanagement.dtos.LeaveListReqDto;
import com.pheonix.leavemanagement.dtos.LeaveListResDto;
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

    int fetchLeaveCount(@Param("paginationDto") LeaveListReqDto paginationDto);

    List<LeaveListResDto> fetchLeaveList(@Param("paginationDto") LeaveListReqDto paginationDto);

    int updateLeaveStatus(@Param("model") Leave model,
                          @Param("leaveId") String leaveId);
}
