package enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum SortsEnum {
     STUDENT(1,"学生"),
     MONITOR(0,"管理员");
     SortsEnum(Integer code,String msg) {
         this.code = code;
         this.msg = msg;
     }
     @EnumValue
     private Integer code;
     private String msg;
}
