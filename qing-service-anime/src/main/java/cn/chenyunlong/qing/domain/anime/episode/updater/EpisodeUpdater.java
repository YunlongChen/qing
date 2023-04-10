// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.episode.updater;

import cn.chenyunlong.qing.domain.anime.episode.Episode;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Optional;

import lombok.Data;

@Schema
@Data
public class EpisodeUpdater {
    @Schema(
            title = "animeId",
            description = "animeId"
    )
    private Long animeId;

    @Schema(
            title = "listId",
            description = "listId"
    )
    private Long listId;

    @Schema(
            title = "name",
            description = "name"
    )
    private String name;

    @Schema(
            title = "status",
            description = "status"
    )
    private Integer status;

    @Schema(
            title = "uploaderName",
            description = "uploaderName"
    )
    private String uploaderName;

    @Schema(
            title = "uploaderId",
            description = "uploaderId"
    )
    private Long uploaderId;

    @Schema(
            title = "url",
            description = "url"
    )
    private String url;

    @Schema(
            title = "orderNo",
            description = "orderNo"
    )
    private Integer orderNo;

    private Long id;

    public void updateEpisode(Episode param) {
        Optional.ofNullable(getAnimeId()).ifPresent(param::setAnimeId);
        Optional.ofNullable(getListId()).ifPresent(param::setListId);
        Optional.ofNullable(getName()).ifPresent(param::setName);
        Optional.ofNullable(getStatus()).ifPresent(param::setStatus);
        Optional.ofNullable(getUploaderName()).ifPresent(param::setUploaderName);
        Optional.ofNullable(getUploaderId()).ifPresent(param::setUploaderId);
        Optional.ofNullable(getUrl()).ifPresent(param::setUrl);
        Optional.ofNullable(getOrderNo()).ifPresent(param::setOrderNo);
    }
}
