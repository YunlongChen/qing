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
package cn.chenyunlong.qing.domain.anime.episode.mapper;

import cn.chenyunlong.common.mapper.DateMapper;
import cn.chenyunlong.common.mapper.GenericEnumMapper;
import cn.chenyunlong.qing.domain.anime.episode.Episode;
import cn.chenyunlong.qing.domain.anime.episode.creator.EpisodeCreator;
import cn.chenyunlong.qing.domain.anime.episode.query.EpisodeQuery;
import cn.chenyunlong.qing.domain.anime.episode.request.EpisodeCreateRequest;
import cn.chenyunlong.qing.domain.anime.episode.request.EpisodeQueryRequest;
import cn.chenyunlong.qing.domain.anime.episode.request.EpisodeUpdateRequest;
import cn.chenyunlong.qing.domain.anime.episode.response.EpisodeResponse;
import cn.chenyunlong.qing.domain.anime.episode.updater.EpisodeUpdater;
import cn.chenyunlong.qing.domain.anime.episode.vo.EpisodeVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
        uses = {
                GenericEnumMapper.class,
                DateMapper.class
        }
)
public interface EpisodeMapper {
    EpisodeMapper INSTANCE = Mappers.getMapper(EpisodeMapper.class);

    Episode dtoToEntity(EpisodeCreator dto);

    EpisodeUpdater request2Updater(EpisodeUpdateRequest request);

    EpisodeCreator request2Dto(EpisodeCreateRequest request);

    EpisodeQuery request2Query(EpisodeQueryRequest request);

    EpisodeResponse vo2Response(EpisodeVO vo);

    default EpisodeResponse vo2CustomResponse(EpisodeVO vo) {
        EpisodeResponse response = vo2Response(vo);
        return response;
    }
}
