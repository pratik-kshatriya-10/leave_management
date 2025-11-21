package com.pheonix.leavemanagement.services.impls;

import com.pheonix.leavemanagement.daos.LeaveHistoryDao;
import com.pheonix.leavemanagement.models.LeaveHistory;
import com.pheonix.leavemanagement.services.LeaveHistoryService;
import com.pheonix.leavemanagement.utils.DateUtils;
import com.pheonix.leavemanagement.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveHistoryServiceImpl implements LeaveHistoryService {
    @Autowired
    private LeaveHistoryDao leaveHistoryDao;

    public void addLeaveHistory(String leaveId, String userId, String leaveStatus, String loggedInUserId){
        LeaveHistory model = new LeaveHistory();
        model.setLeaveHistoryId(UUID.random());
        model.setLeaveId(leaveId);
        model.setUserId(userId);
        model.setStatus(leaveStatus);
        model.updateCCUU(loggedInUserId, DateUtils.now());
        leaveHistoryDao.addLeaveHistory(model);
    }
}
