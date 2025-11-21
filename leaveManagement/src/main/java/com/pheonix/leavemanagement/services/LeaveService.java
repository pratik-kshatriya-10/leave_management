package com.pheonix.leavemanagement.services;

import com.pheonix.leavemanagement.dtos.LeaveDto;
import com.pheonix.leavemanagement.dtos.LeaveListDto;
import com.pheonix.leavemanagement.dtos.LeaveStatusDto;
import com.pheonix.leavemanagement.dtos.PaginationDto;
import com.pheonix.leavemanagement.models.Leave;
import com.pheonix.leavemanagement.utils.Messages;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Service
@Validated
public interface LeaveService {
    int addLeave(@Valid LeaveDto dto);

    int updateLeave(@Valid LeaveDto dto,
                    @NotEmpty(message = Messages.LEAVE_ID_REQUIRED) String leaveId);

    boolean leaveIdExist(@NotEmpty(message = Messages.LEAVE_ID_REQUIRED) String leaveId);

    int deleteLeave(@NotEmpty(message = Messages.LEAVE_ID_REQUIRED) String leaveId);

    Leave fetchLeave(@NotEmpty(message = Messages.LEAVE_ID_REQUIRED) String leaveId);

    int fetchLeaveCount(@Valid PaginationDto paginationDto);

    List<LeaveListDto> fetchLeaveList(@Valid PaginationDto paginationDto);

    int updateLeaveStatus(@Valid LeaveStatusDto dto);
}
