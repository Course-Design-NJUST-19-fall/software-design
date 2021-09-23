package com.test.mybatisplus.controller;

import com.test.mybatisplus.entity.Account;
import com.test.mybatisplus.enums.AccountServiceResultEnum;
import com.test.mybatisplus.enums.SortsEnum;
import com.test.mybatisplus.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import javax.annotation.Resource;

@SpringBootTest
class AccountControllerTest {
    @Resource
    AccountServiceImpl accountService;
    @Test
    void test(){
        String id="lxc";
        String password="123456";
        Account account=new Account();
        account.setId(id);
        account.setPassword(password);
        if(accountService.signIn(account)== AccountServiceResultEnum.SUCCESS) {
            System.out.println(account.getSort());
//            if(account.getSort()==SortsEnum.学生) return SortsEnum.学生;
//            else if(account.getSort()==SortsEnum.老师) return SortsEnum.老师;
//            else return SortsEnum.管理员;
        }
//        else return null;
    }
}