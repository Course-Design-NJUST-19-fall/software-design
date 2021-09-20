package com.test.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum ResultEnum {
     ACCEPT(0,"Accept"),
     RUNTIME_ERROR(1,"Rumtime Error"),
     TIME_LIMIT_EXCEEDED(2,"Time Limit Exceeded"),
     MEMORY_LIMIT_EXCEEDED(3,"Memory Limit Exceeded"),
     SEGMENTATION_FAULT(4,"Segmentation Fault"),
     UNKNOWN_ERROR(5,"Unknown Error"),
     OUTPUT_LIMIT_EXCEED(6,"output limit exceed"),        //爆输出
     UNABLE_TO_GET_INPUT(7,"unable to get input"),        //无法输入
     UNABLE_TO_MAKE_OUTPUT(8,"unable to make output"),      //无法输出
     UNABLE_TO_EXECVE(9,"unalbe to execve"),           //无法执行程序
     UNABLE_TO_SET_UID(10,"unalbe to run as a low power user"),          //无法以低权限用户执行
     UNABLE_TO_LIMIT_MEM(11,"unable to limit memory"),        //无法限制内存
     UNABLE_TO_LIMIT_CPU_TIME(12,"unable to limit cpu time"),   //无法限制cpu时间
     UNABLE_TO_LIMIT_OUTPUT(13,""),     //无法限制输出大学
     UNABLE_TO_LIMIT_STACK(14,"unalbe to limit stack"),      //无法限制堆栈
     UNABLE_TO_SECCOMP(15,"unable to limit system call"),          //无法限制系统调用
     UNABLE_TO_LIMIT_REAL_TIME(16,"unable to limit real time"),  //无法限制真实时间
     CONFIG_ERROR(17,"sandbox setting error"),               //设置错误
     WRONG_ANSWER(18,"Wrong Answer"),
     COMPILATION_ERROR(19,"Compilation Error");


     ResultEnum(Integer code,String msg){
         this.code=code;
         this.msg=msg;
     }
     @EnumValue
     private Integer code;
     private String msg;
}
