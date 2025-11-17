package com.pheonix.leavemanagement.controllers.designations;

import com.pheonix.leavemanagement.controllers.BaseRestController;
import com.pheonix.leavemanagement.dtos.DesignationDto;
import com.pheonix.leavemanagement.dtos.PaginationDto;
import com.pheonix.leavemanagement.models.DataGridModel;
import com.pheonix.leavemanagement.models.Designation;
import com.pheonix.leavemanagement.services.DesignationService;
import com.pheonix.leavemanagement.utils.Constants;
import com.pheonix.leavemanagement.utils.CustomException;
import com.pheonix.leavemanagement.utils.Messages;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(Constants.BASE_URL + "/designations")
public class DesignationController extends BaseRestController {

    @Autowired
    private DesignationService designationService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> addDesignation(
            @Valid @RequestBody DesignationDto dto){

        int result = designationService.addDesignation(dto);
        if (result < 0){
            throw new CustomException(Messages.ERROR_ADD_DESIGNATION);
        }
        return constructSuccessResponse(Messages.SUCCESS_ADD_DESIGNATION, Messages.SUCCESS);


    }

    @PutMapping(value = "/{designationId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> updateDesignation(
            @RequestBody DesignationDto dto,
            @PathVariable(Constants.DESIGNATION_ID) String designationId){
        int result = designationService.updateDesignation(dto, designationId);
        if (result < 0){
            throw new CustomException(Messages.ERROR_UPDATE_DESIGNATION);
        }
        return constructSuccessResponse(Messages.SUCCESS_UPDATE_DESIGNATION, Messages.SUCCESS);
    }

    @DeleteMapping(value = "/{designationId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> deleteDesignation(
            @PathVariable(Constants.DESIGNATION_ID) String designationId){
        int result = designationService.deleteDesignation(designationId);
        if (result < 0){
            throw new CustomException(Messages.ERROR_DELETE_DESIGNATION);
        }
        return constructSuccessResponse(Messages.SUCCESS_DELETE_DESIGNATION, Messages.SUCCESS);

    }

    @GetMapping(value = "/{designationId}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Designation fetchDesignation(
            @PathVariable(Constants.DESIGNATION_ID) String designationId){
        Designation result = designationService.fetchDesignation(designationId);
        if (result ==  null){
            throw new CustomException(Messages.DESIGNATION_NOT_FOUND);
        }
        return result;
    }

    @PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public DataGridModel<Designation> searchDesignations(
            @RequestBody PaginationDto paginationDto){
        int count = designationService.fetchDesignationCount(paginationDto);
        List<Designation> list = new ArrayList<>();
        if (count > 0){
            list = designationService.fetchDesignationList(paginationDto);
        }
        DataGridModel<Designation> model = new DataGridModel<>();
        model.setCount(count);
        model.setData(list);
        model.setPaginationDto(paginationDto);
        return model;
    }
}
