package cn.chenyunlong.qing.domain.anime.episode.dto.response;

import cn.chenyunlong.common.model.AbstractJpaResponse;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class EpisodeResponse extends AbstractJpaResponse {

    static {
    }

    @Schema(
        title = "name",
        description = "名称"
    )
    private String name;

    @Schema(
        title = "animeId",
        description = "动漫ID"
    )
    private Long animeId;

    @Schema(
        title = "collectionId",
        description = "播放源ID"
    )
    private Long collectionId;

    @Schema(
        title = "collectionName",
        description = "播放源名称"
    )
    private String collectionName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAnimeId() {
        return animeId;
    }

    public void setAnimeId(Long animeId) {
        this.animeId = animeId;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
}
