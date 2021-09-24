package com.test.mybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.mybatisplus.entity.TestRecord;
import com.test.mybatisplus.mapper.TestRecordMapper;
import com.test.mybatisplus.service.impl.TestRecordServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TestRecordControllerTest {
    @Resource
    TestRecordServiceImpl testRecordService;
    @Test
    void test(){
        Page<TestRecord>testRecordPage=testRecordService.getByPage(1,10);
        testRecordPage.getRecords().forEach(System.out::println);
    }

}