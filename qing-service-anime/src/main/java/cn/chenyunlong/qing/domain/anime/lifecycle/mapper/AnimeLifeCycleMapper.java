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
package cn.chenyunlong.qing.domain.anime.lifecycle.mapper;

import cn.chenyunlong.qing.domain.anime.lifecycle.AnimeLifeCycle;
import cn.chenyunlong.qing.domain.anime.lifecycle.creator.AnimeLifeCycleCreator;
import cn.chenyunlong.qing.domain.anime.lifecycle.query.AnimeLifeCycleQuery;
import cn.chenyunlong.qing.domain.anime.lifecycle.request.AnimeLifeCycleCreateRequest;
import cn.chenyunlong.qing.domain.anime.lifecycle.request.AnimeLifeCycleQueryRequest;
import cn.chenyunlong.qing.domain.anime.lifecycle.request.AnimeLifeCycleUpdateRequest;
import cn.chenyunlong.qing.domain.anime.lifecycle.response.AnimeLifeCycleResponse;
import cn.chenyunlong.qing.domain.anime.lifecycle.updater.AnimeLifeCycleUpdater;
import cn.chenyunlong.qing.domain.anime.lifecycle.vo.AnimeLifeCycleVO;
import cn.hutool.core.bean.BeanUtil;

public interface AnimeLifeCycleMapper {
    AnimeLifeCycleMapper INSTANCE = new AnimeLifeCycleMapper() {};

    default AnimeLifeCycle dtoToEntity(AnimeLifeCycleCreator dto) {
        return BeanUtil.copyProperties(dto, AnimeLifeCycle.class);
    }

    default AnimeLifeCycleUpdater request2Updater(AnimeLifeCycleUpdateRequest request) {
        return BeanUtil.copyProperties(request, AnimeLifeCycleUpdater.class);
    }

    default AnimeLifeCycleCreator request2Dto(AnimeLifeCycleCreateRequest request) {
        return BeanUtil.copyProperties(request, AnimeLifeCycleCreator.class);
    }

    default AnimeLifeCycleQuery request2Query(AnimeLifeCycleQueryRequest request) {
        return BeanUtil.copyProperties(request, AnimeLifeCycleQuery.class);
    }

    default AnimeLifeCycleResponse vo2Response(AnimeLifeCycleVO vo) {
        return BeanUtil.copyProperties(vo, AnimeLifeCycleResponse.class);
    }

    default AnimeLifeCycleResponse vo2CustomResponse(AnimeLifeCycleVO vo) {
        return vo2Response(vo);
    }
}
