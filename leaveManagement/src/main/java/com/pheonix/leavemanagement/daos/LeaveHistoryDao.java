package com.pheonix.leavemanagement.daos;

import com.pheonix.leavemanagement.models.LeaveHistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LeaveHistoryDao {

    void addLeaveHistory(LeaveHistory model);
}
