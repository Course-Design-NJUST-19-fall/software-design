package com.test.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.test.mybatisplus.enums.ResultEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * <p>
 * 
 * </p>
 *
 * @author team
 * @since 2021-09-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TestRecord implements Serializable {

  private static final long serialVersionUID = 1L;

  public TestRecord(int id, int problemId,String submitterId){
    this.id=id;
    this.problemId=problemId;
    this.submitterId=submitterId;
    cpuTimeCost = 0;
    memoryCost = 0;
  }
  public TestRecord(){
    cpuTimeCost = 0;
    memoryCost = 0;
  }

  @TableId(type = IdType.AUTO)
  private Integer id;

  private String submitterId;

  private Integer problemId;

  @TableField(fill = FieldFill.INSERT)
  private Timestamp submitTime;

  private Integer cpuTimeCost;

  private Integer memoryCost;

  private ResultEnum result;

  private String compilationErrorMessage;
}
