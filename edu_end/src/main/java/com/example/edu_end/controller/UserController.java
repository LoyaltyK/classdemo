package com.example.edu_end.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @PostMapping("/login")
    @ResponseBody
    public String login(String account,String password){
        System.out.println(account + "--" + password);
        return account;
    }

}
