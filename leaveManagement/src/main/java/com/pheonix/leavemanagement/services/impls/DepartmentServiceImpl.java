package com.pheonix.leavemanagement.services.impls;

import com.pheonix.leavemanagement.daos.DepartmentDao;
import com.pheonix.leavemanagement.dtos.DepartmentDto;
import com.pheonix.leavemanagement.dtos.PaginationDto;
import com.pheonix.leavemanagement.models.Department;
import com.pheonix.leavemanagement.services.DepartmentService;
import com.pheonix.leavemanagement.utils.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public int addDepartment(DepartmentDto dto){
        String departmentCode = dto.getDepartmentName().toUpperCase().replace("_", "");
        if (!departmentCode.matches(Constants.RegexPattern.ALPHABETICAL_CHARACTERS)){
            throw new CustomException(Messages.INVALID_DEPARTMENT_NAME);
        }
        if(departmentDao.departmentCodeExists(departmentCode)){
            throw new CustomException(Messages.DUPLICATE_DEPARTMENT_CODE);
        }
        Department model = new Department();
        model.setDepartmentId(UUID.random());
        model.setDepartmentName(dto.getDepartmentName());
        model.setDepartmentCode(departmentCode);
        model.updateCCUU("1", DateUtils.now());
        return departmentDao.addDepartment(model);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public int updateDepartment(DepartmentDto dto, String departmentId){
        if (!departmentDao.departmentIdExist(departmentId)){
            throw new CustomException(Messages.INVALID_DEPARTMENT_ID);
        }
        String departmentCode = dto.getDepartmentName().toUpperCase().replace("_", "");
        if (!departmentCode.matches(Constants.RegexPattern.ALPHABETICAL_CHARACTERS)){
            throw new CustomException(Messages.INVALID_DEPARTMENT_NAME);
        }
        if(departmentDao.departmentCodeExistsOtherThan(departmentCode, departmentId)){
            throw new CustomException(Messages.DUPLICATE_DEPARTMENT_CODE);
        }
        Department model = new Department();
        model.setDepartmentName(dto.getDepartmentName());
        model.setDepartmentCode(departmentCode);
        model.updateUU("1", DateUtils.now());
        return departmentDao.updateDepartment(model, departmentId);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public int deleteDepartment(String departmentId){
        if (!departmentDao.departmentIdExist(departmentId)){
            throw new CustomException(Messages.INVALID_DEPARTMENT_ID);
        }
        Department model = new Department();
        model.updateUUD("1", DateUtils.now());
        return departmentDao.deleteDepartment(model, departmentId);
    }

    @Override
    public Department fetchDepartment(String departmentId){
        if (!departmentDao.departmentIdExist(departmentId)){
            throw new CustomException(Messages.INVALID_DEPARTMENT_ID);
        }
        return departmentDao.fetchDepartment(departmentId);
    }

    @Override
    public int fetchDepartmentCount(PaginationDto paginationDto){
        return departmentDao.fetchDepartmentCount(paginationDto);
    }

    @Override
    public List<Department> fetchDepartmentList(PaginationDto paginationDto){
        return departmentDao.fetchDepartmentList(paginationDto);
    }

}

