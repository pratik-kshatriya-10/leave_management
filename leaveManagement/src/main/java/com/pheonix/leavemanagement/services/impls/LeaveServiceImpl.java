package com.pheonix.leavemanagement.services.impls;

import com.pheonix.leavemanagement.daos.LeaveDao;
import com.pheonix.leavemanagement.dtos.LeaveDto;
import com.pheonix.leavemanagement.dtos.LeaveListDto;
import com.pheonix.leavemanagement.dtos.PaginationDto;
import com.pheonix.leavemanagement.models.Leave;
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

    @Override
    @Transactional(rollbackOn = Exception.class)
    public int addLeave(LeaveDto dto){
        validateLeaveDetails(dto);
        Leave model = dto.buildLeave();
        model.setLeaveId(UUID.random());
        model.setFromDate(DateUtils.convertDateIntoLongStartOfDay(dto.getFromDate()));
        model.setToDate(DateUtils.convertDateIntoLongEndOfDay(dto.getToDate()));
        model.setLeaveStatus(Constants.LeaveStatuses.PENDING);
        model.updateCCUU("1", DateUtils.now());
        return leaveDao.addLeave(model);
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
    public int fetchLeaveCount(PaginationDto paginationDto){
        return leaveDao.fetchLeaveCount(paginationDto);
    }

    @Override
    public List<LeaveListDto> fetchLeaveList(PaginationDto paginationDto){
        return leaveDao.fetchLeaveList(paginationDto);
    }



}
