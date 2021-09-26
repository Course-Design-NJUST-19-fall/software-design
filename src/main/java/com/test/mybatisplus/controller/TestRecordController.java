package com.test.mybatisplus.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.mybatisplus.entity.Account;
import com.test.mybatisplus.entity.TestRecord;
import com.test.mybatisplus.service.impl.TestRecordServiceImpl;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author team
 * @since 2021-09-16
 */
@Controller
@RestController
@CrossOrigin
@RequestMapping("//testRecord")
public class TestRecordController {
    @Resource
    TestRecordServiceImpl testRecordService;
    @GetMapping("/findAll/{page}/{size}")
    public Page<TestRecord> getByPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        return testRecordService.getByPage(page,size);
    }
    @GetMapping("/findById/{id}")
    public TestRecord findById(@PathVariable("id") String id){
        return testRecordService.getById(id);
    }
}

