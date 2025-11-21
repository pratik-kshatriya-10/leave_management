package com.pheonix.leavemanagement.controllers.leaveHistries;

import com.pheonix.leavemanagement.controllers.BaseRestController;
import com.pheonix.leavemanagement.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.BASE_URL + "/leave_histories")
public class LeaveHistoryController extends BaseRestController {
}
