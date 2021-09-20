package com.test.mybatisplus.service.impl;

import com.test.mybatisplus.entity.Problem;
import com.test.mybatisplus.mapper.AccountMapper;
import com.test.mybatisplus.mapper.ProblemMapper;
import com.test.mybatisplus.mapper.TestRecordMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = com.test.mybatisplus.MybatisplusApplication.class)
@ExtendWith(SpringExtension.class)
class ProblemServiceImplTest {
    @Resource
    private ProblemMapper problemMapper;
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private TestRecordMapper testRecordMapper;
    @Autowired
    private ProblemServiceImpl problemService;

    @Test
    public void saveProblem(){
        problemMapper.delete(null);
        Problem problem = new Problem(null,2000,262144,0,0,3,
                "猫猫聚会","/home/problems/cats/config.json","/home/problems/cats/input/","/home/problems/cats/output/");
        problemMapper.insert(problem);
        problemMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void judgeTest(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/home/test_codes/VkCup2015_C.cpp"));
            StringBuilder stringBuilder = new StringBuilder();
            String code = null;
            String line = null;
            while ((line = reader.readLine())!=null){
                stringBuilder.append(line);
                stringBuilder.append(System.getProperty("line.separator"));
            }
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            reader.close();
            code = stringBuilder.toString();

            problemService.ProblemJudge(5,accountMapper.selectList(null).get(0),code);

            testRecordMapper.selectList(null).forEach(System.out::println);
            accountMapper.selectList(null).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}