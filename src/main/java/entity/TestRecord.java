package entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import enums.ResultEnum;
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

      private Integer id;

    private String submitterId;

    private Integer problemId;

    private LocalDateTime submitTime;

    private Integer cpuTimeCost;

    private Integer memoryCost;

    private ResultEnum result;


}
