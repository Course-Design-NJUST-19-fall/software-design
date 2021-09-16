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
    public class Problem implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer id;

    private Integer cpuTimeLimit;

    private Integer memoryLimit;

    private String problemName;

    private String problemPath;

    private String inputPath;

    private String outputPath;

    private Integer acceptNumber;

    private Integer submitNumber;


}
