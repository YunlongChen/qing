// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.type.request;

import cn.chenyunlong.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;

import lombok.Data;

@Schema
@Data
public class AnimeTypeUpdateRequest implements Request {
    @Schema(
            title = "name",
            description = "name"
    )
    private String name;

    @Schema(
            title = "description",
            description = "description"
    )
    private String description;

    @Schema(
            title = "orderNo",
            description = "orderNo"
    )
    private Integer orderNo;

    private Long id;
}
