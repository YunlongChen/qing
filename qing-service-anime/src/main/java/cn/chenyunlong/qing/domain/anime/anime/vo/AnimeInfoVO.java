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
package cn.chenyunlong.qing.domain.anime.anime.vo;

import cn.chenyunlong.common.model.AbstractBaseJpaVO;
import cn.chenyunlong.qing.domain.anime.anime.AnimeInfo;
import cn.chenyunlong.qing.domain.anime.anime.PlayStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
            title = "Name",
            description = "name"
    )
    private String name;

    @Schema(
            title = "Instruction",
            description = "instruction"
    )
    private String instruction;

    @Schema(
            title = "DistrictId",
            description = "districtId"
    )
    private Long districtId;

    @Schema(
            title = "DistrictName",
            description = "districtName"
    )
    private String districtName;

    @Schema(
            title = "CoverUrl",
            description = "coverUrl"
    )
    private String coverUrl;

    @Schema(
            title = "TypeId",
            description = "typeId"
    )
    private Long typeId;

    @Schema(
            title = "TypeName",
            description = "typeName"
    )
    private String typeName;

    @Schema(
            title = "OriginalName",
            description = "originalName"
    )
    private String originalName;

    @Schema(
            title = "OtherName",
            description = "otherName"
    )
    private String otherName;

    @Schema(
            title = "Author",
            description = "author"
    )
    private String author;

    @Schema(
            title = "Company",
            description = "company"
    )
    private String company;

    @Schema(
            title = "PremiereDate",
            description = "premiereDate"
    )
    private LocalDate premiereDate;

    @Schema(
            title = "PlayStatus",
            description = "playStatus"
    )
    private PlayStatus playStatus;

    @Schema(
            title = "PlotType",
            description = "plotType"
    )
    private String plotType;

    @Schema(
            title = "Tags",
            description = "tags"
    )
    private String tags;

    @Schema(
            title = "OfficialWebsite",
            description = "officialWebsite"
    )
    private String officialWebsite;

    @Schema(
            title = "PlayHeat",
            description = "playHeat"
    )
    private String playHeat;

    @Schema(
            title = "OrderNo",
            description = "orderNo"
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
