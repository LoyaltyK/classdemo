package com.example.edu_end.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reward {
    private int id;
    private int uid;
    private String type;
    private String name;
    private Date time;
}
