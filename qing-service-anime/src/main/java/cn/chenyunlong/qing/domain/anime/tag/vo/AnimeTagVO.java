/*
 * Copyright (c) 2023  YunLong Chen
 * Project Qing is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *          http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 *
 */

// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.tag.vo;

import cn.chenyunlong.common.model.AbstractBaseJpaVO;
import cn.chenyunlong.qing.domain.anime.tag.AnimeTag;
import io.swagger.v3.oas.annotations.media.Schema;
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
            title = "Name",
            description = "name"
    )
    private String name;

    @Schema(
            title = "Description",
            description = "description"
    )
    private String description;

    @Schema(
            title = "OrderNo",
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
