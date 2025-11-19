package com.pheonix.leavemanagement.services.impls;

import com.pheonix.leavemanagement.daos.LeaveTypeDao;
import com.pheonix.leavemanagement.models.LeaveType;
import com.pheonix.leavemanagement.services.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveTypeServiceImpl implements LeaveTypeService {

    @Autowired
    private LeaveTypeDao leaveTypeDao;

    @Override
    public List<LeaveType> fetchLeaveTypes(){
        return leaveTypeDao.fetchLeaveTypes();
    }

}
