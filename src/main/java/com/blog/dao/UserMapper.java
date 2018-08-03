package com.blog.dao;

import com.blog.bean.User;
import com.blog.param.LoginParam;

import java.util.List;


public interface UserMapper {
    List<User> getAllUser();
    User login(LoginParam param);
}
