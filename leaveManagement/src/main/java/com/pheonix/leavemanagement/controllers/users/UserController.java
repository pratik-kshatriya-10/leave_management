package com.pheonix.leavemanagement.controllers.users;

import com.pheonix.leavemanagement.controllers.BaseRestController;
import com.pheonix.leavemanagement.dtos.UserDto;
import com.pheonix.leavemanagement.services.UserService;
import com.pheonix.leavemanagement.utils.Constants;
import com.pheonix.leavemanagement.utils.CustomException;
import com.pheonix.leavemanagement.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(Constants.BASE_URL + "/users")
public class UserController extends BaseRestController {

    @Autowired
    private UserService userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> addUser(
            @RequestBody UserDto dto){

        int result = userService.addUser(dto);
        if (result < 0){
            throw new CustomException(Messages.ERROR_ADD_DEPARTMENT);
        }
        return constructSuccessResponse(Messages.SUCCESS_ADD_DEPARTMENT, Messages.SUCCESS);


    }



}
