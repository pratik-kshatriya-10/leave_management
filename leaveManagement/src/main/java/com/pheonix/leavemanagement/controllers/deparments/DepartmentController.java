package com.pheonix.leavemanagement.controllers.deparments;

import com.pheonix.leavemanagement.controllers.BaseRestController;
import com.pheonix.leavemanagement.dtos.DepartmentDto;
import com.pheonix.leavemanagement.dtos.PaginationDto;
import com.pheonix.leavemanagement.models.DataGridModel;
import com.pheonix.leavemanagement.models.Department;
import com.pheonix.leavemanagement.services.DepartmentService;
import com.pheonix.leavemanagement.utils.Constants;
import com.pheonix.leavemanagement.utils.CustomException;
import com.pheonix.leavemanagement.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(Constants.BASE_URL + "/departments")
public class DepartmentController extends BaseRestController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> addDepartment(
            @RequestBody DepartmentDto dto){

        int result = departmentService.addDepartment(dto);
        if (result < 0){
            throw new CustomException(Messages.ERROR_ADD_DEPARTMENT);
        }
        return constructSuccessResponse(Messages.SUCCESS_ADD_DEPARTMENT, Constants.SUCCESS);


    }

    @PutMapping(value = "/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> updateDepartment(
            @RequestBody DepartmentDto dto,
            @PathVariable(Constants.DEPARTMENT_ID) String departmentId){
        int result = departmentService.updateDepartment(dto, departmentId);
        if (result < 0){
            throw new CustomException(Messages.ERROR_UPDATE_DEPARTMENT);
        }
        return constructSuccessResponse(Messages.SUCCESS_UPDATE_DEPARTMENT, Constants.SUCCESS);
    }

    @DeleteMapping(value = "/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> deleteDepartment(
            @PathVariable(Constants.DEPARTMENT_ID) String departmentId){
        int result = departmentService.deleteDepartment(departmentId);
        if (result < 0){
            throw new CustomException(Messages.ERROR_DELETE_DEPARTMENT);
        }
        return constructSuccessResponse(Messages.SUCCESS_DELETE_DEPARTMENT, Constants.SUCCESS);

    }

    @GetMapping(value = "/{departmentId}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public Department fetchDepartment(
            @PathVariable(Constants.DEPARTMENT_ID) String departmentId){
        Department result = departmentService.fetchDepartment(departmentId);
        if (result ==  null){
            throw new CustomException(Messages.DEPARTMENT_NOT_FOUND);
        }
        return result;
    }

    @PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DataGridModel<Department> searchDepartments(
            @RequestBody PaginationDto paginationDto){
        int count = departmentService.fetchDepartmentCount(paginationDto);
        List<Department> list = new ArrayList<>();
        if (count > 0){
            list = departmentService.fetchDepartmentList(paginationDto);
        }
        DataGridModel<Department> model = new DataGridModel<>();
        model.setCount(count);
        model.setData(list);
        model.setPaginationDto(paginationDto);
        return model;
    }
}
