package com.example.edu_end.service.impl;

import com.example.edu_end.entity.Result;
import com.example.edu_end.entity.User;
import com.example.edu_end.mapper.UserMapper;
import com.example.edu_end.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Result login(int id, String passWord) {
        User user = userMapper.selectById(id);
        if ( user != null && passWord.equals(user.getPassWord()) ) {
            Map<String,Object> result = new HashMap<>();
//            User reUser = new User(user.getId(), user.getUserName(), user.getRole());
//            System.out.println(reUser);
            user.setPassWord(null);
            result.put("user", user);
            result.put("token","success");
            return Result.success(result);
        }

        return Result.error("账户或密码错误");
    }
}
