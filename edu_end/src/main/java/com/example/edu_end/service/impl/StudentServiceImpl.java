package com.example.edu_end.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.edu_end.entity.Reward;
import com.example.edu_end.entity.Scores;
import com.example.edu_end.mapper.RewardMapper;
import com.example.edu_end.mapper.ScoresMapper;
import com.example.edu_end.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    ScoresMapper scoresMapper;

    @Autowired
    RewardMapper rewardMapper;


    @Override
    public List<Scores> selectScoresByStudentId(int id) {
        QueryWrapper<Scores> scoresWrapper = new QueryWrapper<>();
        scoresWrapper.eq("uid",id);
        return scoresMapper.selectList(scoresWrapper);
    }

    @Override
    public List<Reward> selectRewardByStudentId(int id) {
        QueryWrapper<Reward> rewardWrapper = new QueryWrapper<>();
        rewardWrapper.eq("uid",id);
        return rewardMapper.selectList(rewardWrapper);
    }
}
