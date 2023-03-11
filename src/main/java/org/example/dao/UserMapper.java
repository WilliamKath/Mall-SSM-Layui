package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.User;

public interface UserMapper {
    User findByUsername(String username);

    int addUser(User user);

    boolean existUsername(@Param("username") String username);
}
