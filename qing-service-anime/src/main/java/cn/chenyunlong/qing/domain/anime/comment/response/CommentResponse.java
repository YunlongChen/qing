// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.comment.response;

import cn.chenyunlong.common.model.AbstractJpaResponse;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.Long;
import java.lang.String;

import lombok.Data;

@Schema
@Data
public class CommentResponse extends AbstractJpaResponse {
    @Schema(
            title = "cid",
            description = "cid"
    )
    private Long cid;

    @Schema(
            title = "username",
            description = "username"
    )
    private String username;

    @Schema(
            title = "content",
            description = "content"
    )
    private String content;

    @Schema(
            title = "ipAddress",
            description = "ipAddress"
    )
    private String ipAddress;
}
