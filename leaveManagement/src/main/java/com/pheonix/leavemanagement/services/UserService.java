package com.pheonix.leavemanagement.services;

import com.pheonix.leavemanagement.dtos.PaginationDto;
import com.pheonix.leavemanagement.dtos.UserDto;
import com.pheonix.leavemanagement.models.User;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public interface UserService {
    int addUser(UserDto dto);

    int updateUser(UserDto dto, String userId);

    boolean userIdExist(String userId);

    int deleteUser(String userId);

    User fetchUser(String userId);

    int fetchUserCount(PaginationDto paginationDto);

    List<User> fetchUserList(PaginationDto paginationDto);
}
