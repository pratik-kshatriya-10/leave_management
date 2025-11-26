package com.pheonix.leavemanagement.services;

import com.pheonix.leavemanagement.dtos.LeaveHistoryByUserDto;
import com.pheonix.leavemanagement.dtos.LeaveHistoryListDto;
import com.pheonix.leavemanagement.utils.Messages;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public interface LeaveHistoryService {

    void addLeaveHistory(@NotEmpty(message = Messages.LEAVE_ID_REQUIRED) String leaveId,
                         @NotEmpty(message = Messages.USER_ID_REQUIRED) String userId,
                         @NotEmpty(message = Messages.LEAVE_STATUS_REQUIRED) String leaveStatus,
                         @NotEmpty(message = Messages.LOGGED_IN_USER_ID_REQUIRED) String loggedInUserId);

    int fetchLeaveHistoryCount(@Valid LeaveHistoryByUserDto leaveHistoryByUserDto);

    List<LeaveHistoryListDto> fetchLeaveHistoryList(@Valid LeaveHistoryByUserDto leaveHistoryByUserDto);
}
