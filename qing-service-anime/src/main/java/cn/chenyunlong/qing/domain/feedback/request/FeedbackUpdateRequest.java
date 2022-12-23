// ---Auto Generated by Project Qing ---
package cn.chenyunlong.qing.domain.feedback.request;

import cn.chenyunlong.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class FeedbackUpdateRequest implements Request {
    @Schema(
            title = "mid"
    )
    private Long mid;

    @Schema(
            title = "type"
    )
    private Integer type;

    @Schema(
            title = "detail"
    )
    private String detail;

    @Schema(
            title = "uid"
    )
    private String uid;

    @Schema(
            title = "processingStatus"
    )
    private Integer processingStatus;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
