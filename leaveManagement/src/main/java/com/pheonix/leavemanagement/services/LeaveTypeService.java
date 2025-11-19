package com.pheonix.leavemanagement.services;

import com.pheonix.leavemanagement.models.LeaveType;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public interface LeaveTypeService {
    List<LeaveType> fetchLeaveTypes();
}
