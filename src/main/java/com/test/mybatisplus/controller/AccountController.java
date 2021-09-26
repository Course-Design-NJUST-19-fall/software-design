package com.test.mybatisplus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.test.mybatisplus.entity.Account;
import com.test.mybatisplus.enums.AccountServiceResultEnum;
import com.test.mybatisplus.enums.AddResultEnum;
import com.test.mybatisplus.enums.SortsEnum;
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
    @GetMapping("/getRank/{page}/{size}")
    public Page<Account> getRankByPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        return accountService.getRankByPage(page,size);
    }
    @PostMapping("/save")
    public AddResultEnum save(@RequestBody Account account){
        Account otherAccount = accountService.getById(account.getId());
        if(otherAccount==null) {
            if(accountService.save(account)) return AddResultEnum.SUCCESS;
            else return AddResultEnum.ERROR;
        }
        else return AddResultEnum.HAVE_EXIST;
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
    @GetMapping("/signIn/{id}/{password}")
    public SortsEnum signIn(@PathVariable("id") String id, @PathVariable("password") String  password){
        Account account=new Account();
        account.setId(id);
        account.setPassword(password);
        if(accountService.signIn(account)== AccountServiceResultEnum.SUCCESS) {
            if(account.getSort()==SortsEnum.学生) return SortsEnum.学生;
            else if(account.getSort()==SortsEnum.老师) return SortsEnum.老师;
            else return SortsEnum.管理员;
        }
        else return null;
    }


}

