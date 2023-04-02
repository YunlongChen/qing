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

import cn.chenyunlong.common.mapper.DateMapper;
import cn.chenyunlong.common.mapper.GenericEnumMapper;
import cn.chenyunlong.qing.domain.anime.lifecycle.AnimeLifeCycle;
import cn.chenyunlong.qing.domain.anime.lifecycle.creator.AnimeLifeCycleCreator;
import cn.chenyunlong.qing.domain.anime.lifecycle.query.AnimeLifeCycleQuery;
import cn.chenyunlong.qing.domain.anime.lifecycle.request.AnimeLifeCycleCreateRequest;
import cn.chenyunlong.qing.domain.anime.lifecycle.request.AnimeLifeCycleQueryRequest;
import cn.chenyunlong.qing.domain.anime.lifecycle.request.AnimeLifeCycleUpdateRequest;
import cn.chenyunlong.qing.domain.anime.lifecycle.response.AnimeLifeCycleResponse;
import cn.chenyunlong.qing.domain.anime.lifecycle.updater.AnimeLifeCycleUpdater;
import cn.chenyunlong.qing.domain.anime.lifecycle.vo.AnimeLifeCycleVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
        uses = {
                GenericEnumMapper.class,
                DateMapper.class
        }
)
public interface AnimeLifeCycleMapper {
    AnimeLifeCycleMapper INSTANCE = Mappers.getMapper(AnimeLifeCycleMapper.class);

    AnimeLifeCycle dtoToEntity(AnimeLifeCycleCreator dto);

    AnimeLifeCycleUpdater request2Updater(AnimeLifeCycleUpdateRequest request);

    AnimeLifeCycleCreator request2Dto(AnimeLifeCycleCreateRequest request);

    AnimeLifeCycleQuery request2Query(AnimeLifeCycleQueryRequest request);

    AnimeLifeCycleResponse vo2Response(AnimeLifeCycleVO vo);

    default AnimeLifeCycleResponse vo2CustomResponse(AnimeLifeCycleVO vo) {
        AnimeLifeCycleResponse response = vo2Response(vo);
        return response;
    }
}
