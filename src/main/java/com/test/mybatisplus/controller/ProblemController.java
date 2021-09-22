package com.test.mybatisplus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.mybatisplus.entity.Problem;
import com.test.mybatisplus.service.impl.ProblemServiceImpl;
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
@RequestMapping("//problem")
public class ProblemController {
    @Resource
    ProblemServiceImpl problemService;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Problem> getByPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        return problemService.getByPage(page,size);
    }
    @PostMapping("/save")
    public boolean save(@RequestBody Problem problem){
        return problemService.save(problem);
    }
    @GetMapping("/findById/{id}")
    public Problem findById(@PathVariable("id") Integer id){
        return problemService.getById(id);
    }
    @PutMapping("/updated")
    public boolean update(@RequestBody Problem problem){
        UpdateWrapper<Problem> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",problem.getId());
        return problemService.update(problem,updateWrapper);
    }
    @DeleteMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable("id") Integer id){
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return problemService.remove(queryWrapper);
    }
    @PostMapping("/judgeProblem")
    public boolean judgeProblem(@RequestBody Integer problemId,@RequestBody String submitterId, @RequestBody String code) {
        return problemService.ProblemJudge(problemId,submitterId,code);
    }


}

