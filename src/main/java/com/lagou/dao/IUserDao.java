package com.lagou.dao;

import com.lagou.pojo.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll() throws Exception;

    User findByCondition(User user) throws Exception;

    int updateUser(User user);

    int insertUser(User user);

    int deleteUser(User user);
}
