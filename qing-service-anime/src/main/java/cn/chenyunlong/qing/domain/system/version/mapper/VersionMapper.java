// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.system.version.mapper;

import cn.chenyunlong.qing.domain.system.version.Version;
import cn.chenyunlong.qing.domain.system.version.creator.VersionCreator;
import cn.chenyunlong.qing.domain.system.version.query.VersionQuery;
import cn.chenyunlong.qing.domain.system.version.request.VersionCreateRequest;
import cn.chenyunlong.qing.domain.system.version.request.VersionQueryRequest;
import cn.chenyunlong.qing.domain.system.version.request.VersionUpdateRequest;
import cn.chenyunlong.qing.domain.system.version.response.VersionResponse;
import cn.chenyunlong.qing.domain.system.version.updater.VersionUpdater;
import cn.chenyunlong.qing.domain.system.version.vo.VersionVO;
import cn.hutool.core.bean.BeanUtil;

public interface VersionMapper {
    VersionMapper INSTANCE = new VersionMapper() {};

    default Version dtoToEntity(VersionCreator dto) {
        return BeanUtil.copyProperties(dto, Version.class);
    }

    default VersionUpdater request2Updater(VersionUpdateRequest request) {
        return BeanUtil.copyProperties(request, VersionUpdater.class);
    }

    default VersionCreator request2Dto(VersionCreateRequest request) {
        return BeanUtil.copyProperties(request, VersionCreator.class);
    }

    default VersionQuery request2Query(VersionQueryRequest request) {
        return BeanUtil.copyProperties(request, VersionQuery.class);
    }

    default VersionResponse vo2Response(VersionVO vo) {
        return BeanUtil.copyProperties(vo, VersionResponse.class);
    }

    default VersionResponse vo2CustomResponse(VersionVO vo) {
        return vo2Response(vo);
    }
}
