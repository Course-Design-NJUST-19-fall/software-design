package com.test.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.test.mybatisplus.mapper")
@ComponentScan({"com.test.mybatisplus.handler","com.test.mybatisplus.service","com.test.mybatisplus.controller","com.test.mybatisplus.config"})
public class MybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusApplication.class, args);
    }

}
