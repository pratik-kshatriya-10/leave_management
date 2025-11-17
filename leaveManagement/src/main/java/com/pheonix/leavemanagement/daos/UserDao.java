package com.pheonix.leavemanagement.daos;

import org.apache.ibatis.annotations.Param;

public interface UserDao {
    boolean emailAlreadyExist(@Param("email") String email);

    boolean usernameAlreadyExist(@Param("username") String username);
}
