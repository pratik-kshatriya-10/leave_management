package com.pheonix.leavemanagement.services.impls;

import com.pheonix.leavemanagement.daos.UserDao;
import com.pheonix.leavemanagement.dtos.PaginationDto;
import com.pheonix.leavemanagement.dtos.UserDto;
import com.pheonix.leavemanagement.models.User;
import com.pheonix.leavemanagement.services.UserService;
import com.pheonix.leavemanagement.utils.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        if (dto.getEmail() != null && !dto.getEmail().matches(Constants.RegexPattern.EMAIL_PATTERN)){
            throw new CustomException(Messages.INVALID_EMAIL);
        }
        if (dto.getUsername() !=  null &&!dto.getUsername().matches(Constants.RegexPattern.SMALL_LETTERS_WITH_NUMBERS)){
            throw new CustomException(Messages.INVALID_USERNAME);
        }
        if (dto.getContactNumber() != null && !dto.getContactNumber().matches(Constants.RegexPattern.NUMBER_PATTERN)){
            throw new CustomException(Messages.INVALID_CONTACT_NUMBER);
        }
    }

    @Override
    public boolean userIdExist(String userId){
        return userDao.userIdExist(userId);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public int updateUser(UserDto dto, String userId){
        validateUserDetails(dto);
        if (dto.getEmail() != null && userDao.emailAlreadyExistOtherThan(dto.getEmail().toLowerCase(), userId)){
            throw new CustomException(Messages.DUPLICATE_EMAIL);
        }
        if (dto.getUsername() != null && userDao.usernameAlreadyExistOtherThan(dto.getUsername().toLowerCase(), userId)){
            throw new CustomException(Messages.DUPLICATE_USERNAME);
        }
        User model = dto.builduser();
        model.setPassword(dto.getPassword());
        model.updateUU("1", DateUtils.now());
        return userDao.updateUser(model, userId);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public int deleteUser(String userId){
        User model = new User();
        model.updateUUD("1", DateUtils.now());
        return userDao.deleteUser(model, userId);
    }

    @Override
    public User fetchUser(String userId){
        return userDao.fetchUser(userId);
    }

    @Override
    public int fetchUserCount(PaginationDto paginationDto){
        return userDao.fetchUserCount(paginationDto);
    }

    @Override
    public List<User> fetchUserList(PaginationDto paginationDto){
        return userDao.fetchUserList(paginationDto);
    }

}
