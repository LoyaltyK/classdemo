package com.example.edu_end.controller;

import com.example.edu_end.entity.Result;
import com.example.edu_end.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public Result login(int account, String password){
        System.out.println(account + "--" + password);
        return userService.login(account,password);
    }

}
