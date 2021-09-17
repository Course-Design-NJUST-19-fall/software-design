package entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import enums.SortsEnum;
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

  public Account(String userName, String password, String nicoName, SortsEnum sort, String phoneNumber, SortsEnum type, boolean listenMessage){
    this.id =userName;
    this.password =password;
    this.nicoName =nicoName;
    this.sort = sort;
    this.listenMessage =listenMessage;
    this.phoneNumber =phoneNumber;
  }
  public Account(){

  }

  private static final long serialVersionUID = 1L;

  private String id;

  private String password;

  private String nicoName;

  private SortsEnum sort;

  private String phoneNumber;

  private Boolean listenMessage;
}
