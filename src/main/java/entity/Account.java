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

    private static final long serialVersionUID = 1L;

      private String id;

    private String password;

    private String nicoName;

    private SortsEnum sort;

    private String phoneNumber;

    private Boolean listenMessage;


}
