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
package cn.chenyunlong.qing.domain.anime.anime.mapper;

import cn.chenyunlong.common.mapper.DateMapper;
import cn.chenyunlong.common.mapper.GenericEnumMapper;
import cn.chenyunlong.qing.domain.anime.anime.AnimeInfo;
import cn.chenyunlong.qing.domain.anime.anime.creator.AnimeInfoCreator;
import cn.chenyunlong.qing.domain.anime.anime.query.AnimeInfoQuery;
import cn.chenyunlong.qing.domain.anime.anime.request.AnimeInfoCreateRequest;
import cn.chenyunlong.qing.domain.anime.anime.request.AnimeInfoQueryRequest;
import cn.chenyunlong.qing.domain.anime.anime.request.AnimeInfoUpdateRequest;
import cn.chenyunlong.qing.domain.anime.anime.response.AnimeInfoResponse;
import cn.chenyunlong.qing.domain.anime.anime.updater.AnimeInfoUpdater;
import cn.chenyunlong.qing.domain.anime.anime.vo.AnimeInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
        uses = {
                GenericEnumMapper.class,
                DateMapper.class
        }
)
public interface AnimeInfoMapper {
    AnimeInfoMapper INSTANCE = Mappers.getMapper(AnimeInfoMapper.class);

    AnimeInfo dtoToEntity(AnimeInfoCreator dto);

    AnimeInfoUpdater request2Updater(AnimeInfoUpdateRequest request);

    AnimeInfoCreator request2Dto(AnimeInfoCreateRequest request);

    AnimeInfoQuery request2Query(AnimeInfoQueryRequest request);

    AnimeInfoResponse vo2Response(AnimeInfoVO vo);

    default AnimeInfoResponse vo2CustomResponse(AnimeInfoVO vo) {
        AnimeInfoResponse response = vo2Response(vo);
        return response;
    }
}
