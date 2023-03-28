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

// ---Auto Generated by Project Qing ---
package cn.chenyunlong.qing.domain.anime.anime.response;

import cn.chenyunlong.common.model.AbstractJpaResponse;
import cn.chenyunlong.qing.domain.anime.anime.PlayStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema
public class AnimeInfoResponse extends AbstractJpaResponse {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDate getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(LocalDate premiereDate) {
        this.premiereDate = premiereDate;
    }

    public PlayStatus getPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(PlayStatus playStatus) {
        this.playStatus = playStatus;
    }

    public String getPlotType() {
        return plotType;
    }

    public void setPlotType(String plotType) {
        this.plotType = plotType;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getOfficialWebsite() {
        return officialWebsite;
    }

    public void setOfficialWebsite(String officialWebsite) {
        this.officialWebsite = officialWebsite;
    }

    public String getPlayHeat() {
        return playHeat;
    }

    public void setPlayHeat(String playHeat) {
        this.playHeat = playHeat;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
}
