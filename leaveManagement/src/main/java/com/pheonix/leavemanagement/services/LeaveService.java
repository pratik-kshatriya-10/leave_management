package com.pheonix.leavemanagement.services;

import com.pheonix.leavemanagement.dtos.LeaveDto;
import com.pheonix.leavemanagement.dtos.LeaveListDto;
import com.pheonix.leavemanagement.dtos.LeaveStatusDto;
import com.pheonix.leavemanagement.dtos.PaginationDto;
import com.pheonix.leavemanagement.models.Leave;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Service
@Validated
public interface LeaveService {
    int addLeave(LeaveDto dto);

    int updateLeave(LeaveDto dto, String leaveId);

    boolean leaveIdExist(String leaveId);

    int deleteLeave(String leaveId);

    Leave fetchLeave(String leaveId);

    int fetchLeaveCount(PaginationDto paginationDto);

    List<LeaveListDto> fetchLeaveList(PaginationDto paginationDto);

    int updateLeaveStatus(LeaveStatusDto dto);
}
