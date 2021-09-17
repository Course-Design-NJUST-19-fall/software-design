package com.test.mybatisplus.mapper;

import com.test.mybatisplus.entity.Account;
import com.test.mybatisplus.enums.SortsEnum;
import com.test.mybatisplus.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = com.test.mybatisplus.MybatisplusApplication.class)
class AccountMapperTest {
     @Autowired
     private AccountMapper mapper;
     @Test
    void test(){
         mapper.selectList(null).forEach(System.out::println);
     }
     @Test
    void save(){
         Account account = new Account("lxc","123456","my son",SortsEnum.STUDENT,"15902351277",false);
         mapper.insert(account);
         mapper.selectList(null).forEach(System.out::println);
     }
}