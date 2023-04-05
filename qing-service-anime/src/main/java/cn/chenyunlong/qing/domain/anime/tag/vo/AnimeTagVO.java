// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.tag.vo;

import cn.chenyunlong.common.model.AbstractBaseJpaVO;
import cn.chenyunlong.qing.domain.anime.tag.AnimeTag;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.Integer;
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
public class AnimeTagVO extends AbstractBaseJpaVO {
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

    public AnimeTagVO(AnimeTag source) {
        super();
        this.setName(source.getName());
        this.setDescription(source.getDescription());
        this.setOrderNo(source.getOrderNo());
    }
}
