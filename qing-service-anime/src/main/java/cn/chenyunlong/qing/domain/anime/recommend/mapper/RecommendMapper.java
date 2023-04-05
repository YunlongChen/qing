// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.recommend.mapper;

import cn.chenyunlong.qing.domain.anime.recommend.Recommend;
import cn.chenyunlong.qing.domain.anime.recommend.creator.RecommendCreator;
import cn.chenyunlong.qing.domain.anime.recommend.query.RecommendQuery;
import cn.chenyunlong.qing.domain.anime.recommend.request.RecommendCreateRequest;
import cn.chenyunlong.qing.domain.anime.recommend.request.RecommendQueryRequest;
import cn.chenyunlong.qing.domain.anime.recommend.request.RecommendUpdateRequest;
import cn.chenyunlong.qing.domain.anime.recommend.response.RecommendResponse;
import cn.chenyunlong.qing.domain.anime.recommend.updater.RecommendUpdater;
import cn.chenyunlong.qing.domain.anime.recommend.vo.RecommendVO;
import cn.hutool.core.bean.BeanUtil;

public interface RecommendMapper {
    RecommendMapper INSTANCE = new RecommendMapper() {};

    default Recommend dtoToEntity(RecommendCreator dto) {
        return BeanUtil.copyProperties(dto, Recommend.class);
    }

    default RecommendUpdater request2Updater(RecommendUpdateRequest request) {
        return BeanUtil.copyProperties(request, RecommendUpdater.class);
    }

    default RecommendCreator request2Dto(RecommendCreateRequest request) {
        return BeanUtil.copyProperties(request, RecommendCreator.class);
    }

    default RecommendQuery request2Query(RecommendQueryRequest request) {
        return BeanUtil.copyProperties(request, RecommendQuery.class);
    }

    default RecommendResponse vo2Response(RecommendVO vo) {
        return BeanUtil.copyProperties(vo, RecommendResponse.class);
    }

    default RecommendResponse vo2CustomResponse(RecommendVO vo) {
        return vo2Response(vo);
    }
}
