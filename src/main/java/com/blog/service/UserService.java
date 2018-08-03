package com.blog.service;

import com.blog.bean.User;
import com.blog.common.resultUtil.ResultEx;
import com.blog.param.LoginParam;

import java.util.List;


public interface UserService {
    List<User> getAllUser();
    ResultEx login(LoginParam param);
}
