package chenyunlong.zhangli.model.vo;

import chenyunlong.zhangli.model.dto.base.OutputConverter;
import chenyunlong.zhangli.model.entities.AnimeComment;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Stan
 */
@Data
public class CommentVO {
    private Long id;
    private String username;
    private String content;
    private LocalDateTime createTime;
    private Long mid;
}
