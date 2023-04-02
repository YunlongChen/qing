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
package cn.chenyunlong.qing.domain.anime.tag.mapper;

import cn.chenyunlong.common.mapper.DateMapper;
import cn.chenyunlong.common.mapper.GenericEnumMapper;
import cn.chenyunlong.qing.domain.anime.tag.AnimeTag;
import cn.chenyunlong.qing.domain.anime.tag.creator.AnimeTagCreator;
import cn.chenyunlong.qing.domain.anime.tag.query.AnimeTagQuery;
import cn.chenyunlong.qing.domain.anime.tag.request.AnimeTagCreateRequest;
import cn.chenyunlong.qing.domain.anime.tag.request.AnimeTagQueryRequest;
import cn.chenyunlong.qing.domain.anime.tag.request.AnimeTagUpdateRequest;
import cn.chenyunlong.qing.domain.anime.tag.response.AnimeTagResponse;
import cn.chenyunlong.qing.domain.anime.tag.updater.AnimeTagUpdater;
import cn.chenyunlong.qing.domain.anime.tag.vo.AnimeTagVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
        uses = {
                GenericEnumMapper.class,
                DateMapper.class
        }
)
public interface AnimeTagMapper {
    AnimeTagMapper INSTANCE = Mappers.getMapper(AnimeTagMapper.class);

    AnimeTag dtoToEntity(AnimeTagCreator dto);

    AnimeTagUpdater request2Updater(AnimeTagUpdateRequest request);

    AnimeTagCreator request2Dto(AnimeTagCreateRequest request);

    AnimeTagQuery request2Query(AnimeTagQueryRequest request);

    AnimeTagResponse vo2Response(AnimeTagVO vo);

    default AnimeTagResponse vo2CustomResponse(AnimeTagVO vo) {
        AnimeTagResponse response = vo2Response(vo);
        return response;
    }
}
