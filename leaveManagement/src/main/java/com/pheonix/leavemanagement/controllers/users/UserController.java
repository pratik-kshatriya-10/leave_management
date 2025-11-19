package com.pheonix.leavemanagement.controllers.users;

import com.pheonix.leavemanagement.controllers.BaseRestController;
import com.pheonix.leavemanagement.dtos.PaginationDto;
import com.pheonix.leavemanagement.dtos.UserDto;
import com.pheonix.leavemanagement.models.DataGridModel;
import com.pheonix.leavemanagement.models.User;
import com.pheonix.leavemanagement.services.UserService;
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
@RequestMapping(Constants.BASE_URL + "/users")
public class UserController extends BaseRestController {

    @Autowired
    private UserService userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> addUser(
            @RequestBody UserDto dto){

        int result = userService.addUser(dto);
        if (result < 0){
            throw new CustomException(Messages.ERROR_ADD_USER);
        }
        return constructSuccessResponse(Messages.SUCCESS_ADD_USER, Constants.SUCCESS);
    }

    @PutMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> updateUser(
            @RequestBody UserDto dto,
            @PathVariable(Constants.USER_ID) String userId){

        if (!userService.userIdExist(userId)){
            throw new CustomException(Messages.INVALID_USER_ID);
        }
        int result = userService.updateUser(dto, userId);
        if (result < 0){
            throw new CustomException(Messages.ERROR_UPDATE_USER);
        }
        return constructSuccessResponse(Messages.SUCCESS_UPDATE_USER, Constants.SUCCESS);
    }

    @DeleteMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> deleteUser(
            @PathVariable(Constants.USER_ID) String userId){

        if (!userService.userIdExist(userId)){
            throw new CustomException(Messages.INVALID_USER_ID);
        }
        int result = userService.deleteUser(userId);
        if (result < 0){
            throw new CustomException(Messages.ERROR_DELETE_USER);
        }
        return constructSuccessResponse(Messages.SUCCESS_DELETE_USER, Constants.SUCCESS);
    }

    @GetMapping(value = "/{userId}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public User fetchUser(
            @PathVariable(Constants.USER_ID) String userId){

        if (!userService.userIdExist(userId)){
            throw new CustomException(Messages.INVALID_USER_ID);
        }
        User result = userService.fetchUser(userId);
        if (result ==  null){
            throw new CustomException(Messages.USER_NOT_FOUND);
        }
        return result;
    }

    @PostMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public DataGridModel<User> searchUsers(
            @RequestBody PaginationDto paginationDto){
        int count = userService.fetchUserCount(paginationDto);
        List<User> list = new ArrayList<>();
        if (count > 0){
            list = userService.fetchUserList(paginationDto);
        }
        DataGridModel<User> model = new DataGridModel<>();
        model.setCount(count);
        model.setData(list);
        model.setPaginationDto(paginationDto);
        return model;
    }



}
