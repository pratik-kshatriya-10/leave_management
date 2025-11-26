package com.pheonix.leavemanagement.daos;

import com.pheonix.leavemanagement.dtos.LeaveHistoryByUserDto;
import com.pheonix.leavemanagement.dtos.LeaveHistoryListDto;
import com.pheonix.leavemanagement.models.LeaveHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LeaveHistoryDao {

    void addLeaveHistory(LeaveHistory model);

    int fetchLeaveHistoryCount(@Param("leaveHistoryByUserDto") LeaveHistoryByUserDto leaveHistoryByUserDto);

    List<LeaveHistoryListDto> fetchLeaveHistoryList(@Param("leaveHistoryByUserDto") LeaveHistoryByUserDto leaveHistoryByUserDto);
}
