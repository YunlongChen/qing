// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.episode.creator;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class EpisodeCreator {
    @Schema(
            title = "AnimeId",
            description = "animeId"
    )
    private Long animeId;

    @Schema(
            title = "ListId",
            description = "listId"
    )
    private Long listId;

    @Schema(
            title = "Name",
            description = "name"
    )
    private String name;

    @Schema(
            title = "Status",
            description = "status"
    )
    private Integer status;

    @Schema(
            title = "UploaderName",
            description = "uploaderName"
    )
    private String uploaderName;

    @Schema(
            title = "UploaderId",
            description = "uploaderId"
    )
    private Long uploaderId;

    @Schema(
            title = "Url",
            description = "url"
    )
    private String url;

    @Schema(
            title = "OrderNo",
            description = "orderNo"
    )
    private Integer orderNo;
}
