package org.example.service;

import org.apache.ibatis.annotations.Param;
import org.example.entity.User;
import org.example.entity.UserDo;

public interface UserService {
    /**
     * 登录功能
     * @param username
     * @param password
     * @return
     */
    User Login(String username, String password);

    /**
     * 添加用户实现注册功能
     * @param user
     * @return
     */
    boolean addUser(User user);


    boolean existUsername(@Param("username") String username);
}
