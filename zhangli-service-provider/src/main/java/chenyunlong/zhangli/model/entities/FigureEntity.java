package chenyunlong.zhangli.model.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Stan
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("figure")
public class FigureEntity extends BaseEntity {
    private String name;
    private String otherNames;
    private LocalDate releaseDate;
    private String characterName;
    private String relatedWork;
    private String producer;
    private BigDecimal price;
    private String links;
    private String coverImg;
}
