package entity;

import java.io.Serializable;

import enums.SortsEnum;
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
public class Student extends Account implements Serializable {

  public Student(String userName, String passWord, String nicoName, SortsEnum sort, String phoneNumber, SortsEnum type, boolean listenMessage,
                 int submitNumber, int acceptNumber, int rating){
    super(userName, passWord, nicoName, sort, phoneNumber, type, listenMessage);
    this.submitNumber =submitNumber;
    this.acceptNumber =acceptNumber;
    this.rating = rating;
  }
  public Student(){
    super();
  }

  private static final long serialVersionUID = 1L;

  private String id;

  private Integer submitNumber;

  private Integer acceptNumber;

  private Integer rating;
}
