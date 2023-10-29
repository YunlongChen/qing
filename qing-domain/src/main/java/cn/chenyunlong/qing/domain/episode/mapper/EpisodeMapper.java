package cn.chenyunlong.qing.domain.episode.mapper;

import cn.chenyunlong.qing.domain.episode.Episode;
import cn.chenyunlong.qing.domain.episode.dto.creator.EpisodeCreator;
import cn.chenyunlong.qing.domain.episode.dto.query.EpisodeQuery;
import cn.chenyunlong.qing.domain.episode.dto.request.EpisodeCreateRequest;
import cn.chenyunlong.qing.domain.episode.dto.request.EpisodeQueryRequest;
import cn.chenyunlong.qing.domain.episode.dto.request.EpisodeUpdateRequest;
import cn.chenyunlong.qing.domain.episode.dto.response.EpisodeResponse;
import cn.chenyunlong.qing.domain.episode.dto.updater.EpisodeUpdater;
import cn.chenyunlong.qing.domain.episode.dto.vo.EpisodeVO;
import cn.hutool.core.bean.BeanUtil;

public interface EpisodeMapper {
    EpisodeMapper INSTANCE = new EpisodeMapper() {
    };

    default Episode dtoToEntity(EpisodeCreator dto) {
        return BeanUtil.copyProperties(dto, Episode.class);
    }

    default EpisodeUpdater request2Updater(EpisodeUpdateRequest request) {
        return BeanUtil.copyProperties(request, EpisodeUpdater.class);
    }

    default EpisodeCreator request2Dto(EpisodeCreateRequest request) {
        return BeanUtil.copyProperties(request, EpisodeCreator.class);
    }

    default EpisodeQuery request2Query(EpisodeQueryRequest request) {
        return BeanUtil.copyProperties(request, EpisodeQuery.class);
    }

    default EpisodeResponse vo2Response(EpisodeVO vo) {
        return BeanUtil.copyProperties(vo, EpisodeResponse.class);
    }

    default EpisodeResponse vo2CustomResponse(EpisodeVO vo) {
        return vo2Response(vo);
    }
}
