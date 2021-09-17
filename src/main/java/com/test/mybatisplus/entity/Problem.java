package com.test.mybatisplus.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class Problem implements Serializable {

  private static final long serialVersionUID = 1L;

  public Problem(int id,int cpuTimeLimit,int memoryLimit,int acceptNumber,int submitNumber, int rating,
                 String problemName,String problemPath,String inputPath,String outputPath)
  {
    this.id=id;
    this.cpuTimeLimit=cpuTimeLimit;
    this.memoryLimit=memoryLimit;
    this.acceptNumber=acceptNumber;
    this.submitNumber=submitNumber;
    this.rating = rating;
    this.problemName=problemName;
    this.problemPath=problemPath;
    this.inputPath=inputPath;
    this.outputPath=outputPath;
  }
  public Problem(){

  }

  @TableId(type = IdType.AUTO)
  private Integer id;

  private Integer cpuTimeLimit;

  private Integer memoryLimit;

  private String problemName;

  private String problemPath;

  private String inputPath;

  private String outputPath;

  private Integer acceptNumber;

  private Integer submitNumber;

  private Integer rating;
}
