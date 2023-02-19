/*
 * Copyright (c) 2019-2022 YunLong Chen
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

package cn.chenyunlong.qing.domain.anime.anime;

import cn.chenyunlong.codegen.processor.GenBase;
import cn.chenyunlong.codegen.processor.api.*;
import cn.chenyunlong.codegen.processor.controller.GenController;
import cn.chenyunlong.codegen.processor.creator.GenCreator;
import cn.chenyunlong.codegen.processor.mapper.GenMapper;
import cn.chenyunlong.codegen.processor.query.GenQuery;
import cn.chenyunlong.codegen.processor.repository.GenRepository;
import cn.chenyunlong.codegen.processor.service.GenService;
import cn.chenyunlong.codegen.processor.service.GenServiceImpl;
import cn.chenyunlong.codegen.processor.updater.GenUpdater;
import cn.chenyunlong.codegen.processor.vo.GenVo;
import cn.chenyunlong.common.constants.ValidStatus;
import cn.chenyunlong.common.exception.BusinessException;
import cn.chenyunlong.qing.domain.anime.anime.domainservice.AnimeInfoBizInfo;
import cn.chenyunlong.qing.domain.anime.anime.events.AnimeInfoEvents;
import cn.chenyunlong.qing.infrastructure.domain.BaseEntity;
import lombok.Data;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Stan
 */
@GenVo
@GenCreator
@GenUpdater
@GenRepository
@GenService
@GenServiceImpl
@GenController
@GenQuery
@GenCreateRequest
@GenUpdateRequest
@GenQueryRequest
@GenResponse
@GenFeign
@GenMapper
@GenBase(basePackage = "cn.chenyunlong.qing.domain.anime.anime")
@Data
@Entity
@Table(name = "anime_info")
public class AnimeInfo extends BaseEntity {
    private String name;
    private String instruction;
    private Long districtId;
    private String districtName;
    private String coverUrl;
    private Long typeId;
    private String typeName;
    private String originalName;
    private String otherName;
    private String author;
    private String company;
    private LocalDate premiereDate;
    private PlayStatus playStatus;
    private String plotType;
    private String tags;
    private String officialWebsite;
    private String playHeat;
    private Integer orderNo;

    /**
     * 导入动漫
     */
    public void in(AnimeInfoBizInfo bizInfo) {
        if (Objects.equals(ValidStatus.VALID, this.getValidStatus())) {
            throw new BusinessException(AnimeInfoErrorCode.ASSET_HAS_IN);
        }
        setValidStatus(ValidStatus.VALID);
        registerEvent(new AnimeInfoEvents.AnimeInfoInEvent(this, bizInfo));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AnimeInfo animeInfo = (AnimeInfo) o;
        return getId() != null && Objects.equals(getId(), animeInfo.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
