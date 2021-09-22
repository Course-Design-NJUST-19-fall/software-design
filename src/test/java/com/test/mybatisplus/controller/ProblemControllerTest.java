package com.test.mybatisplus.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.mybatisplus.entity.Problem;
import com.test.mybatisplus.service.impl.ProblemServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProblemControllerTest {
    @Resource
    ProblemServiceImpl problemService;
    @Test
    void test(){
        Integer page=1,size=10;
        Page<Problem> problemPage= problemService.getByPage(page,size);
        problemPage.getRecords().forEach(System.out::println);
    }
}