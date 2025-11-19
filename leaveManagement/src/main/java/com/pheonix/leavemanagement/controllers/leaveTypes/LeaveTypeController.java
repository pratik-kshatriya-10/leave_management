package com.pheonix.leavemanagement.controllers.leaveTypes;

import com.pheonix.leavemanagement.controllers.BaseRestController;
import com.pheonix.leavemanagement.models.LeaveType;
import com.pheonix.leavemanagement.services.LeaveTypeService;
import com.pheonix.leavemanagement.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.BASE_URL + "/leave-types")
public class LeaveTypeController extends BaseRestController {

    @Autowired
    private LeaveTypeService leaveTypeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LeaveType> fetchLeaveTypes(){
        return leaveTypeService.fetchLeaveTypes();
    }

}
