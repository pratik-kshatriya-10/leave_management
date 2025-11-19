package com.pheonix.leavemanagement.daos;

import com.pheonix.leavemanagement.dtos.PaginationDto;
import com.pheonix.leavemanagement.models.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserDao {
    boolean emailAlreadyExist(@Param("email") String email);

    boolean usernameAlreadyExist(@Param("username") String username);

    int addUser(User model);

    int updateUser(@Param("model") User model,
                   @Param("userId") String userId);

    boolean userIdExist(@Param("userId") String userId);

    boolean emailAlreadyExistOtherThan(@Param("email") String email,
                                       @Param("userId") String userId);

    boolean usernameAlreadyExistOtherThan(@Param("username") String username,
                                          @Param("userId") String userId);

    int deleteUser(@Param("model") User model,
                   @Param("userId") String userId);

    User fetchUser(@Param("userId") String userId);

    int fetchUserCount(@Param("paginationDto") PaginationDto paginationDto);

    List<User> fetchUserList(@Param("paginationDto") PaginationDto paginationDto);
}
