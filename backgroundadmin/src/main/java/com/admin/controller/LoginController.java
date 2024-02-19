package com.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class LoginController {
    @GetMapping("/login")
    public String login(String userName,String passWord){
        System.out.println("启动");
        return "登录成功";
    }
}
