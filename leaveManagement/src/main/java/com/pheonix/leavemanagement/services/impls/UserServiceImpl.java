package com.pheonix.leavemanagement.services.impls;

import com.pheonix.leavemanagement.daos.UserDao;
import com.pheonix.leavemanagement.dtos.UserDto;
import com.pheonix.leavemanagement.models.User;
import com.pheonix.leavemanagement.services.UserService;
import com.pheonix.leavemanagement.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public int addUser(UserDto dto){
        validateUserDetails(dto);
        if (userDao.emailAlreadyExist(dto.getEmail().toLowerCase())){
            throw new CustomException(Messages.DUPLICATE_EMAIL);
        }
        if (userDao.usernameAlreadyExist(dto.getUsername().toLowerCase())){
            throw new CustomException(Messages.DUPLICATE_USERNAME);
        }
        User model = dto.builduser();
        model.setUserId(UUID.random());
        model.setPassword(dto.getPassword());
        model.updateCCUU("1", DateUtils.now());
        return userDao.addUser(model);
    }

    private void validateUserDetails(UserDto dto) {
        if (!dto.getEmail().matches(Constants.RegexPattern.EMAIL_PATTERN)){
            throw new CustomException(Messages.INVALID_EMAIL);
        }
        if (!dto.getUsername().matches(Constants.RegexPattern.SMALL_LETTERS_WITH_NUMBERS)){
            throw new CustomException(Messages.INVALID_USERNAME);
        }
        if (!dto.getContactNumber().matches(Constants.RegexPattern.NUMBER_PATTERN)){
            throw new CustomException(Messages.INVALID_CONTACT_NUMBER);
        }
    }
}
