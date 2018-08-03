package com.blog.controller;

import com.blog.common.resultUtil.ResultEx;
import com.blog.param.LoginParam;
import com.blog.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@CrossOrigin
@RequestMapping(value = "/user", name = "用户相关")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping(value = "/login", name = "登陆",method = RequestMethod.POST)
    @ResponseBody
    public ResultEx login(LoginParam param, HttpServletRequest request) {
        ResultEx resultEx=userService.login(param);
        if(resultEx.isSuccess()){
            request.getSession().setAttribute("USER",param);
        }
        return resultEx;
    }
    @RequestMapping(value = "/outLogin", name = "注销",method = RequestMethod.POST)
    @ResponseBody
    public ResultEx outlogin(LoginParam param, HttpServletRequest request) {
        request.getSession().removeAttribute("USER");
        return new ResultEx().makeSuccessResult();
    }
}
