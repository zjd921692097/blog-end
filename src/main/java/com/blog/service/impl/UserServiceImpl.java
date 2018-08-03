package com.blog.service.impl;

import com.blog.bean.User;
import com.blog.common.resultUtil.ResultEx;
import com.blog.dao.UserMapper;
import com.blog.param.LoginParam;
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

    @Override
    public ResultEx login(LoginParam param) {
        ResultEx resultEx=new ResultEx();
        User user=userMapper.login(param);
        if(user==null){
            return resultEx.makeFailedResult("用户不存在");
        }
        if(!user.getPassWord().equals(param.getPassWord())){
            return resultEx.makeFailedResult("密码错误");
        }
        return resultEx.makeSuccessResult();
    }
}
