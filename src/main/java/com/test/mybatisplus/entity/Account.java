package com.test.mybatisplus.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.test.mybatisplus.enums.SortsEnum;
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
public class Account implements Serializable {

  public Account(String userName, String password, String nicoName, SortsEnum sort, String phoneNumber, boolean listenMessage){
    this.id =userName;
    this.password =password;
    this.nicoName =nicoName;
    this.sort = sort;
    this.listenMessage =listenMessage;
    this.phoneNumber =phoneNumber;
  }
  public Account(String userName, String password, String nicoName, SortsEnum sort, String phoneNumber, boolean listenMessage, Integer submitNumber, Integer acceptNumber, Integer rating, Integer classId){
    this(userName,password,nicoName,sort,phoneNumber,listenMessage);
    this.submitNumber = submitNumber;
    this.acceptNumber = acceptNumber;
    this.rating = rating;
    this.classId = classId;
  }
  public Account(){

  }
  public void addSubmitNumber(Integer i){
    this.submitNumber += i;
  }
  public void addAcceptNumber(Integer i){
    this.acceptNumber += i;
  }
  public void addRating(Integer i){
    this.rating += i;
  }

  private static final long serialVersionUID = 1L;

  private String id;

  private String password;

  private String nicoName;

  private SortsEnum sort;

  private String phoneNumber;

  private Boolean listenMessage;

  private Integer submitNumber;

  private Integer acceptNumber;

  private Integer rating;

  private Integer classId;
}
