package com.pheonix.leavemanagement.daos;

import com.pheonix.leavemanagement.models.LeaveType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface LeaveTypeDao {

    List<LeaveType> fetchLeaveTypes();
}
