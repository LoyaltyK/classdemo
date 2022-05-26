package com.example.edu_end.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private String role;

    public User(Integer id, String userName, String role) {
    }
}
