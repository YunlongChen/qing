/*
 * Copyright (c) 2019-2023  YunLong Chen
 * Project Qing is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *          https://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 *
 */

// ---Auto Generated by Qing-Generator ---

package cn.chenyunlong.qing.domain.anime.vo;

import cn.chenyunlong.common.model.AbstractBaseJpaVO;
import cn.chenyunlong.qing.domain.anime.AnimeInfo;
import cn.chenyunlong.qing.domain.anime.PlayStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
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
public class AnimeInfoVO extends AbstractBaseJpaVO {
    @Schema(
        title = "name"
    )
    private String name;

    @Schema(
        title = "instruction"
    )
    private String instruction;

    @Schema(
        title = "districtId"
    )
    private Long districtId;

    @Schema(
        title = "districtName"
    )
    private String districtName;

    @Schema(
        title = "coverUrl"
    )
    private String coverUrl;

    @Schema(
        title = "typeId"
    )
    private Long typeId;

    @Schema(
        title = "typeName"
    )
    private String typeName;

    @Schema(
        title = "originalName"
    )
    private String originalName;

    @Schema(
        title = "otherName"
    )
    private String otherName;

    @Schema(
        title = "author"
    )
    private String author;

    @Schema(
        title = "company"
    )
    private String company;

    @Schema(
        title = "premiereDate"
    )
    private LocalDate premiereDate;

    @Schema(
        title = "playStatus"
    )
    private PlayStatus playStatus;

    @Schema(
        title = "plotType"
    )
    private String plotType;

    @Schema(
        title = "tags"
    )
    private String tags;

    @Schema(
        title = "officialWebsite"
    )
    private String officialWebsite;

    @Schema(
        title = "playHeat"
    )
    private String playHeat;

    @Schema(
        title = "orderNo"
    )
    private Integer orderNo;

    public AnimeInfoVO(AnimeInfo source) {
        super();
        this.setName(source.getName());
        this.setInstruction(source.getInstruction());
        this.setDistrictId(source.getDistrictId());
        this.setDistrictName(source.getDistrictName());
        this.setCoverUrl(source.getCoverUrl());
        this.setTypeId(source.getTypeId());
        this.setTypeName(source.getTypeName());
        this.setOriginalName(source.getOriginalName());
        this.setOtherName(source.getOtherName());
        this.setAuthor(source.getAuthor());
        this.setCompany(source.getCompany());
        this.setPremiereDate(source.getPremiereDate());
        this.setPlayStatus(source.getPlayStatus());
        this.setPlotType(source.getPlotType());
        this.setTags(source.getTags());
        this.setOfficialWebsite(source.getOfficialWebsite());
        this.setPlayHeat(source.getPlayHeat());
        this.setOrderNo(source.getOrderNo());
    }
}
