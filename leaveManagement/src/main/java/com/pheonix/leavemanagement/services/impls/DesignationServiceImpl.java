package com.pheonix.leavemanagement.services.impls;

import com.pheonix.leavemanagement.daos.DesignationDao;
import com.pheonix.leavemanagement.dtos.DesignationDto;
import com.pheonix.leavemanagement.dtos.PaginationDto;
import com.pheonix.leavemanagement.models.Designation;
import com.pheonix.leavemanagement.services.DesignationService;
import com.pheonix.leavemanagement.utils.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignationServiceImpl implements DesignationService {

    @Autowired
    private DesignationDao designationDao;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public int addDesignation(DesignationDto dto){
        String designationCode = dto.getDesignationName().toUpperCase().replace("_", "");
        if (!designationCode.matches(Constants.RegexPattern.ALPHABETICAL_CHARACTERS)){
            throw new CustomException(Messages.INVALID_DESIGNATION_NAME);
        }
        if(designationDao.designationCodeExists(designationCode)){
            throw new CustomException(Messages.DUPLICATE_DESIGNATION_CODE);
        }
        Designation model = new Designation();
        model.setDesignationId(UUID.random());
        model.setDesignationName(dto.getDesignationName());
        model.setDesignationCode(designationCode);
        model.updateCCUU("1", DateUtils.now());
        return designationDao.addDesignation(model);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public int updateDesignation(DesignationDto dto, String designationId){
        if (!designationDao.designationIdExist(designationId)){
            throw new CustomException(Messages.INVALID_DESIGNATION_ID);
        }
        String designationCode = dto.getDesignationName().toUpperCase().replace("_", "");
        if (!designationCode.matches(Constants.RegexPattern.ALPHABETICAL_CHARACTERS)){
            throw new CustomException(Messages.INVALID_DESIGNATION_NAME);
        }
        if(designationDao.designationCodeExistsOtherThan(designationCode, designationId)){
            throw new CustomException(Messages.DUPLICATE_DESIGNATION_CODE);
        }
        Designation model = new Designation();
        model.setDesignationName(dto.getDesignationName());
        model.setDesignationCode(designationCode);
        model.updateUU("1", DateUtils.now());
        return designationDao.updateDesignation(model, designationId);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public int deleteDesignation(String designationId){
        if (!designationDao.designationIdExist(designationId)){
            throw new CustomException(Messages.INVALID_DESIGNATION_ID);
        }
        Designation model = new Designation();
        model.updateUUD("1", DateUtils.now());
        return designationDao.deleteDesignation(model, designationId);
    }

    @Override
    public Designation fetchDesignation(String designationId){
        if (!designationDao.designationIdExist(designationId)){
            throw new CustomException(Messages.INVALID_DEPARTMENT_ID);
        }
        return designationDao.fetchDesignation(designationId);
    }

    @Override
    public int fetchDesignationCount(PaginationDto paginationDto){
        return designationDao.fetchDesignationCount(paginationDto);
    }
    @Override
    public List<Designation> fetchDesignationList(PaginationDto paginationDto){
        return designationDao.fetchDesignationList(paginationDto);
    }


}
