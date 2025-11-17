package com.pheonix.leavemanagement.services;

import com.pheonix.leavemanagement.dtos.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public interface UserService {
    int addUser(UserDto dto);
}
