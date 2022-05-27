package com.example.edu_end.service;

import com.example.edu_end.entity.Scores;

import java.util.List;

public interface StudentService {

    List<Scores> selectScoresByStudentId(int id);

}
