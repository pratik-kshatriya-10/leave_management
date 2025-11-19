package com.pheonix.leavemanagement.controllers.leaves;

import com.pheonix.leavemanagement.controllers.BaseRestController;
import com.pheonix.leavemanagement.dtos.LeaveDto;
import com.pheonix.leavemanagement.dtos.LeaveListDto;
import com.pheonix.leavemanagement.dtos.PaginationDto;
import com.pheonix.leavemanagement.models.DataGridModel;
import com.pheonix.leavemanagement.models.Leave;
import com.pheonix.leavemanagement.services.LeaveService;
import com.pheonix.leavemanagement.utils.Constants;
import com.pheonix.leavemanagement.utils.CustomException;
import com.pheonix.leavemanagement.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(Constants.BASE_URL + "/leaves")
public class LeaveController extends BaseRestController {

    @Autowired
    private LeaveService leaveService;


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> addLeave(
            @RequestBody LeaveDto dto){

        int result = leaveService.addLeave(dto);
        if (result < 0){
            throw new CustomException(Messages.ERROR_ADD_LEAVE);
        }
        return constructSuccessResponse(Messages.SUCCESS_ADD_LEAVE, Constants.SUCCESS);
    }

    @PutMapping(value = "/{leaveId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> updateLeave(
            @RequestBody LeaveDto dto,
            @PathVariable(Constants.LEAVE_ID) String leaveId){

        if (!leaveService.leaveIdExist(leaveId)){
            throw new CustomException(Messages.INVALID_LEAVE_ID);
        }
        int result = leaveService.updateLeave(dto, leaveId);
        if (result < 0){
            throw new CustomException(Messages.ERROR_UPDATE_LEAVE);
        }
        return constructSuccessResponse(Messages.SUCCESS_UPDATE_LEAVE, Constants.SUCCESS);
    }

    @DeleteMapping(value = "/{leaveId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> deleteLeave(
            @PathVariable(Constants.LEAVE_ID) String leaveId){

        if (!leaveService.leaveIdExist(leaveId)){
            throw new CustomException(Messages.INVALID_LEAVE_ID);
        }
        int result = leaveService.deleteLeave(leaveId);
        if (result < 0){
            throw new CustomException(Messages.ERROR_DELETE_LEAVE);
        }
        return constructSuccessResponse(Messages.SUCCESS_DELETE_LEAVE, Constants.SUCCESS);
    }

    @GetMapping(value = "/{leaveId}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Leave fetchLeave(
            @PathVariable(Constants.LEAVE_ID) String leaveId){

        if (!leaveService.leaveIdExist(leaveId)){
            throw new CustomException(Messages.INVALID_LEAVE_ID);
        }
        Leave result = leaveService.fetchLeave(leaveId);
        if (result ==  null){
            throw new CustomException(Messages.USER_NOT_FOUND);
        }
        return result;
    }

    @PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DataGridModel<LeaveListDto> searchLeaves(
            @RequestBody PaginationDto paginationDto){
        int count = leaveService.fetchLeaveCount(paginationDto);
        List<LeaveListDto> list = new ArrayList<>();
        if (count > 0){
            list = leaveService.fetchLeaveList(paginationDto);
        }
        DataGridModel<LeaveListDto> model = new DataGridModel<>();
        model.setCount(count);
        model.setData(list);
        model.setPaginationDto(paginationDto);
        return model;
    }

}
