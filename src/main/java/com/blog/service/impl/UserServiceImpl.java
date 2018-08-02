package com.blog.service.impl;

import com.blog.bean.User;
import com.blog.dao.UserMapper;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }
}
