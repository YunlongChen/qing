// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.attachment.creator;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class AttachmentCreator {
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
