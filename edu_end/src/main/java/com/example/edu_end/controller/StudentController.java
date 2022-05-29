package com.example.edu_end.controller;

import com.example.edu_end.entity.Reward;
import com.example.edu_end.entity.Scores;
import com.example.edu_end.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/getStudentScores")
    public List<Scores> selectScoresByStudentId(int id){
        return studentService.selectScoresByStudentId(id);
    }


    @GetMapping("/getStudentReward")
    public List<Reward> selectRewardByStudentId(int id){
        return studentService.selectRewardByStudentId(id);
    }

}
