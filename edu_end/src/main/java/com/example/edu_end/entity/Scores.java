package com.example.edu_end.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Scores {
    private int id;
    private int uid;
    private String subjects;
    private double scores;
    private int year;


}
