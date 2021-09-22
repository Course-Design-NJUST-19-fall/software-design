package com.test.mybatisplus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.mybatisplus.entity.Account;
import com.test.mybatisplus.service.impl.AccountServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author team
 * @since 2021-09-17
 */
@Controller
@RestController
@CrossOrigin
@RequestMapping("//account")
public class AccountController {
    @Resource
    AccountServiceImpl accountService;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Account> getByPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        return accountService.getByPage(page,size);
    }
    @PostMapping("/save")
    public boolean save(@RequestBody Account account){
        return accountService.save(account);
    }
    @GetMapping("/findById/{id}")
    public Account findById(@PathVariable("id") String id){
        return accountService.getById(id);
    }
    @PutMapping("/updated")
    public boolean update(@RequestBody Account account){
        UpdateWrapper<Account> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",account.getId());
        return accountService.update(account,updateWrapper);
    }
    @DeleteMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable("id") String id){
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return accountService.remove(queryWrapper);
    }

}

