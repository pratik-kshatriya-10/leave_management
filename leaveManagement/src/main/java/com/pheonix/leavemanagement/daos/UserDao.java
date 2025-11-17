package com.pheonix.leavemanagement.daos;

import com.pheonix.leavemanagement.models.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    boolean emailAlreadyExist(@Param("email") String email);

    boolean usernameAlreadyExist(@Param("username") String username);

    int addUser(User model);
}
