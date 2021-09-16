package enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

public enum ResultEnum {
     UNKNOWN_ERROR(0,"Unknown Error"),
     ACCEPT(1,"Accept"),
     WRONG_ANSWER(2,"Wrong Answer"),
     COMPILATION_ERROR(3,"Compilation Error"),
     TIME_LIMIT_EXCEEDED(4,"Time Limit Exceeded"),
     MEMORY_LIMIT_EXCEEDED(5,"Memory Limit Exceeded"),
     SEGMENTATION_FAULT(6,"Segmentation Fault"),
     RUNTIME_ERROR(7,"Runtime Error");
     ResultEnum(Integer code,String msg){
         this.code=code;
         this.msg=msg;
     }
     @EnumValue
     private Integer code;
     private String msg;
}
