package com.web.www.dao;

import com.web.www.entity.User;

import java.util.List;

public interface UserMapper {

    public int insertUser(User user);

    public int updateUser(User user);

    public int deleteUser(int id);

    public User selectUserById(int id);

    public List<User> selectAllUser();

}
