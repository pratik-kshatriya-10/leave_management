package com.pheonix.leavemanagement.services.impls;

import com.pheonix.leavemanagement.daos.LeaveHistoryDao;
import com.pheonix.leavemanagement.dtos.LeaveHistoryByUserDto;
import com.pheonix.leavemanagement.dtos.LeaveHistoryListDto;
import com.pheonix.leavemanagement.models.LeaveHistory;
import com.pheonix.leavemanagement.services.LeaveHistoryService;
import com.pheonix.leavemanagement.utils.DateUtils;
import com.pheonix.leavemanagement.utils.UUID;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class LeaveHistoryServiceImpl implements LeaveHistoryService {
    @Autowired
    private LeaveHistoryDao leaveHistoryDao;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void addLeaveHistory(String leaveId, String userId, String leaveStatus, String loggedInUserId){
        LeaveHistory model = new LeaveHistory();
        model.setLeaveHistoryId(UUID.random());
        model.setLeaveId(leaveId);
        model.setUserId(userId);
        model.setStatus(leaveStatus);
        model.updateCCUU(loggedInUserId, DateUtils.now());
        leaveHistoryDao.addLeaveHistory(model);
    }

    @Override
    public int fetchLeaveHistoryCount(LeaveHistoryByUserDto leaveHistoryByUserDto){
        return leaveHistoryDao.fetchLeaveHistoryCount(leaveHistoryByUserDto);
    }

    @Override
    public List<LeaveHistoryListDto> fetchLeaveHistoryList(LeaveHistoryByUserDto leaveHistoryByUserDto){
        List<LeaveHistoryListDto> list =  leaveHistoryDao.fetchLeaveHistoryList(leaveHistoryByUserDto);
        for (LeaveHistoryListDto leaveHistoryListDto: list){
            leaveHistoryListDto.setStartDate(DateUtils.convertDateInString(leaveHistoryListDto.getFromDateInLong()));
            leaveHistoryListDto.setEndDate(DateUtils.convertDateInString(leaveHistoryListDto.getToDateInLong()));
        }
        return list;
    }
}
