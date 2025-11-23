package com.pheonix.leavemanagement.services;

import com.pheonix.leavemanagement.dtos.*;
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

    int fetchLeaveCount(@Valid LeaveListReqDto leaveListReqDto);

    List<LeaveListResDto> fetchLeaveList(@Valid LeaveListReqDto leaveListReqDto);

    int updateLeaveStatus(@Valid LeaveStatusDto dto);
}
