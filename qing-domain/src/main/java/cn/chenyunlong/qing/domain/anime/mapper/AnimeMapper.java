package cn.chenyunlong.qing.domain.anime.mapper;

import cn.chenyunlong.qing.domain.anime.Anime;
import cn.chenyunlong.qing.domain.anime.dto.creator.AnimeCreator;
import cn.chenyunlong.qing.domain.anime.dto.query.AnimeQuery;
import cn.chenyunlong.qing.domain.anime.dto.request.AnimeCreateRequest;
import cn.chenyunlong.qing.domain.anime.dto.request.AnimeQueryRequest;
import cn.chenyunlong.qing.domain.anime.dto.request.AnimeUpdateRequest;
import cn.chenyunlong.qing.domain.anime.dto.response.AnimeResponse;
import cn.chenyunlong.qing.domain.anime.dto.updater.AnimeUpdater;
import cn.chenyunlong.qing.domain.anime.dto.vo.AnimeVO;
import cn.hutool.core.bean.BeanUtil;

public interface AnimeMapper {
    AnimeMapper INSTANCE = new AnimeMapper() {
    };

    default Anime dtoToEntity(AnimeCreator dto) {
        return BeanUtil.copyProperties(dto, Anime.class);
    }

    default AnimeUpdater request2Updater(AnimeUpdateRequest request) {
        return BeanUtil.copyProperties(request, AnimeUpdater.class);
    }

    default AnimeCreator request2Dto(AnimeCreateRequest request) {
        return BeanUtil.copyProperties(request, AnimeCreator.class);
    }

    default AnimeQuery request2Query(AnimeQueryRequest request) {
        return BeanUtil.copyProperties(request, AnimeQuery.class);
    }

    default AnimeResponse vo2CustomResponse(AnimeVO vo) {
        return vo2Response(vo);
    }

    default AnimeResponse vo2Response(AnimeVO vo) {
        return BeanUtil.copyProperties(vo, AnimeResponse.class);
    }
}
