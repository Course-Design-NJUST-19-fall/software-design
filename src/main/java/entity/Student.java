package entity;

import java.io.Serializable;
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
    public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

      private String id;

    private Integer submitNumber;

    private Integer acceptNumber;


}
