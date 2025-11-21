package com.pheonix.leavemanagement.services;

import com.pheonix.leavemanagement.dtos.PaginationDto;
import com.pheonix.leavemanagement.dtos.UserDto;
import com.pheonix.leavemanagement.models.User;
import com.pheonix.leavemanagement.utils.Messages;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public interface UserService {
    int addUser(@Valid UserDto dto);

    int updateUser(@Valid UserDto dto,
                   @NotEmpty(message = Messages.USER_ID_REQUIRED) String userId);

    boolean userIdExist(@NotEmpty(message = Messages.USER_ID_REQUIRED) String userId);

    int deleteUser(@NotEmpty(message = Messages.USER_ID_REQUIRED) String userId);

    User fetchUser(@NotEmpty(message = Messages.USER_ID_REQUIRED) String userId);

    int fetchUserCount(@Valid PaginationDto paginationDto);

    List<User> fetchUserList(@Valid PaginationDto paginationDto);
}
