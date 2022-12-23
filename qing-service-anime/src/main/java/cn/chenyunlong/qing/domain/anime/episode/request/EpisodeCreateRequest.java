// ---Auto Generated by Project Qing ---
package cn.chenyunlong.qing.domain.anime.episode.request;

import cn.chenyunlong.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class EpisodeCreateRequest implements Request {
    @Schema(
            title = "animeId"
    )
    private Long animeId;

    @Schema(
            title = "listId"
    )
    private Long listId;

    @Schema(
            title = "name"
    )
    private String name;

    @Schema(
            title = "status"
    )
    private Integer status;

    @Schema(
            title = "uploaderName"
    )
    private String uploaderName;

    @Schema(
            title = "uploaderId"
    )
    private Long uploaderId;

    @Schema(
            title = "url"
    )
    private String url;

    @Schema(
            title = "orderNo"
    )
    private Integer orderNo;

    public Long getAnimeId() {
        return animeId;
    }

    public void setAnimeId(Long animeId) {
        this.animeId = animeId;
    }

    public Long getListId() {
        return listId;
    }

    public void setListId(Long listId) {
        this.listId = listId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUploaderName() {
        return uploaderName;
    }

    public void setUploaderName(String uploaderName) {
        this.uploaderName = uploaderName;
    }

    public Long getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(Long uploaderId) {
        this.uploaderId = uploaderId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
}
