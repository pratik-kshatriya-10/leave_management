package com.pheonix.leavemanagement.controllers.leaveHistries;

import com.pheonix.leavemanagement.controllers.BaseRestController;
import com.pheonix.leavemanagement.dtos.LeaveHistoryByUserDto;
import com.pheonix.leavemanagement.dtos.LeaveHistoryListDto;
import com.pheonix.leavemanagement.models.DataGridModel;
import com.pheonix.leavemanagement.services.LeaveHistoryService;
import com.pheonix.leavemanagement.services.UserService;
import com.pheonix.leavemanagement.utils.Constants;
import com.pheonix.leavemanagement.utils.CustomException;
import com.pheonix.leavemanagement.utils.DateUtils;
import com.pheonix.leavemanagement.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(Constants.BASE_URL + "/leave_histories")
public class LeaveHistoryController extends BaseRestController {

    @Autowired
    private LeaveHistoryService leaveHistoryService;
    @Autowired
    private UserService userService;

    @PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DataGridModel<LeaveHistoryListDto> fetchLeaveHistoryByUserId(
            @RequestBody LeaveHistoryByUserDto leaveHistoryByUserDto){
        if (!userService.userIdExist(leaveHistoryByUserDto.getUserId())){
            throw new CustomException(Messages.INVALID_USER_ID);
        }
        if(leaveHistoryByUserDto.getStartDate() != null){
            leaveHistoryByUserDto.setFromDateInLong(DateUtils.convertDateIntoLongStartOfDay(leaveHistoryByUserDto.getStartDate()));
        }
        if (leaveHistoryByUserDto.getEndDate() != null){
            leaveHistoryByUserDto.setToDateInLong(DateUtils.convertDateIntoLongEndOfDay(leaveHistoryByUserDto.getEndDate()));
        }
        int count = leaveHistoryService.fetchLeaveHistoryCount(leaveHistoryByUserDto);
        List<LeaveHistoryListDto> list = new ArrayList<>();
        if (count > 0){
            list = leaveHistoryService.fetchLeaveHistoryList(leaveHistoryByUserDto);
        }
        DataGridModel<LeaveHistoryListDto> result = new DataGridModel<>();
        result.setCount(count);
        result.setData(list);
        result.setPaginationDto(leaveHistoryByUserDto);
        return result;
    }
}
