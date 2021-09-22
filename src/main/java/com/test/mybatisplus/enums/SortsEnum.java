package com.test.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum SortsEnum {
    学生(1,"学生"),
    管理员(0,"管理员"),
    老师(2,"老师");

    SortsEnum(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }
    @EnumValue
    private Integer code;
    private String msg;
}
