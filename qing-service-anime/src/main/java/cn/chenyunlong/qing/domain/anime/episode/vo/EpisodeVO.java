// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.episode.vo;

import cn.chenyunlong.common.model.AbstractBaseJpaVO;
import cn.chenyunlong.qing.domain.anime.episode.Episode;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Schema
@Data
@EqualsAndHashCode(
        callSuper = true
)
@NoArgsConstructor(
        access = AccessLevel.PROTECTED
)
public class EpisodeVO extends AbstractBaseJpaVO {
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

    public EpisodeVO(Episode source) {
        super();
        this.setAnimeId(source.getAnimeId());
        this.setListId(source.getListId());
        this.setName(source.getName());
        this.setStatus(source.getStatus());
        this.setUploaderName(source.getUploaderName());
        this.setUploaderId(source.getUploaderId());
        this.setUrl(source.getUrl());
        this.setOrderNo(source.getOrderNo());
    }
}
