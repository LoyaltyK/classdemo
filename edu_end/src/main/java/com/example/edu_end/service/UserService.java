package com.example.edu_end.service;

import com.example.edu_end.entity.Result;
import com.example.edu_end.entity.User;

public interface UserService {
    Result login(int id, String passWord);
}
