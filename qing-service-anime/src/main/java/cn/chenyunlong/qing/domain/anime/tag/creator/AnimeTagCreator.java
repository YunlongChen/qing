// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.tag.creator;

import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.Integer;
import java.lang.String;

import lombok.Data;

@Schema
@Data
public class AnimeTagCreator {
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
}
