// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.attachment.response;

import cn.chenyunlong.common.model.AbstractJpaResponse;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class AttachmentResponse extends AbstractJpaResponse {
    @Schema(
            title = "AttachmentId",
            description = "attachmentId"
    )
    private Integer attachmentId;

    @Schema(
            title = "AttachmentName",
            description = "attachmentName"
    )
    private String attachmentName;

    @Schema(
            title = "AttachmentUrl",
            description = "attachmentUrl"
    )
    private String attachmentUrl;
}
