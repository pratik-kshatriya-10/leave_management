package com.pheonix.leavemanagement.services.impls;

import com.pheonix.leavemanagement.daos.LeaveDao;
import com.pheonix.leavemanagement.dtos.*;
import com.pheonix.leavemanagement.models.Leave;
import com.pheonix.leavemanagement.services.LeaveHistoryService;
import com.pheonix.leavemanagement.services.LeaveService;
import com.pheonix.leavemanagement.services.UserService;
import com.pheonix.leavemanagement.utils.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveDao leaveDao;
    @Autowired
    private UserService userService;
    @Autowired
    private LeaveHistoryService leaveHistoryService;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public int addLeave(LeaveDto dto){
        validateLeaveDetails(dto);
        Leave model = dto.buildLeave();
        String leaveId = UUID.random();
        model.setLeaveId(leaveId);
        model.setFromDate(DateUtils.convertDateIntoLongStartOfDay(dto.getFromDate()));
        model.setToDate(DateUtils.convertDateIntoLongEndOfDay(dto.getToDate()));
        model.setLeaveStatus(Constants.LeaveStatuses.PENDING);
        model.updateCCUU("1", DateUtils.now());
        int result = leaveDao.addLeave(model);
        if (result > 0){
            leaveHistoryService.addLeaveHistory(leaveId, dto.getUserId(), Constants.LeaveStatuses.PENDING, "1");
        }
        return result;
    }

    private void validateLeaveDetails(LeaveDto dto) {
        if (userService.userIdExist(dto.getUserId())){
            throw new CustomException(Messages.INVALID_USER_ID);
        }

    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public int updateLeave(LeaveDto dto, String leaveId){
        validateLeaveDetails(dto);
        Leave model = dto.buildLeave();
        model.setFromDate(DateUtils.convertDateIntoLongStartOfDay(dto.getFromDate()));
        model.setToDate(DateUtils.convertDateIntoLongEndOfDay(dto.getToDate()));
        model.updateUU("1", DateUtils.now());
        return leaveDao.updateLeave(model, leaveId);
    }

    @Override
    public boolean leaveIdExist(String leaveId){
        return leaveDao.leaveIdExist(leaveId);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public int deleteLeave(String leaveId){
        Leave model = new Leave();
        model.updateUUD("1", DateUtils.now());
        return leaveDao.deleteLeave(model, leaveId);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Leave fetchLeave(String leaveId){
        return leaveDao.fetchLeave(leaveId);
    }

    @Override
    public int fetchLeaveCount(LeaveListReqDto leaveListReqDto){
        return leaveDao.fetchLeaveCount(leaveListReqDto);
    }

    @Override
    public List<LeaveListResDto> fetchLeaveList(LeaveListReqDto leaveListReqDto){
        List<LeaveListResDto> list =  leaveDao.fetchLeaveList(leaveListReqDto);
        for(LeaveListResDto leaveListResDto: list){
            leaveListResDto.setFromDate(DateUtils.convertDateInString(leaveListResDto.getFromDateInLong()));
            leaveListResDto.setToDate(DateUtils.convertDateInString(leaveListResDto.getToDateInLong()));
        }
        return list;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public int updateLeaveStatus(LeaveStatusDto dto){
        if (!userService.userIdExist(dto.getUserId())){
            throw new CustomException(Messages.INVALID_USER_ID);
        }
        if (!Constants.LeaveStatuses.leaveStatuses.contains(dto.getLeaveStatus())){
            throw new CustomException(Messages.INVALID_LEAVE_STATUS);
        }
        Leave model = new Leave();
        model.setLeaveStatus(dto.getLeaveStatus());
        model.setUserId(dto.getUserId());
        model.updateUU("1", DateUtils.now());
        int result = leaveDao.updateLeaveStatus(model, dto.getLeaveId());
        if (result > 0){
            leaveHistoryService.addLeaveHistory(dto.getLeaveId(), dto.getUserId(), dto.getLeaveStatus(), "1");
        }
        return result;
    }


}
