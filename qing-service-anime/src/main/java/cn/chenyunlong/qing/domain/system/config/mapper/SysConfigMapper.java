// ---Auto Generated by Project Qing ---
package cn.chenyunlong.qing.domain.system.config.mapper;

import cn.chenyunlong.common.mapper.DateMapper;
import cn.chenyunlong.common.mapper.GenericEnumMapper;
import cn.chenyunlong.qing.domain.system.config.SysConfig;
import cn.chenyunlong.qing.domain.system.config.creator.SysConfigCreator;
import cn.chenyunlong.qing.domain.system.config.query.SysConfigQuery;
import cn.chenyunlong.qing.domain.system.config.request.SysConfigCreateRequest;
import cn.chenyunlong.qing.domain.system.config.request.SysConfigQueryRequest;
import cn.chenyunlong.qing.domain.system.config.request.SysConfigUpdateRequest;
import cn.chenyunlong.qing.domain.system.config.response.SysConfigResponse;
import cn.chenyunlong.qing.domain.system.config.updater.SysConfigUpdater;
import cn.chenyunlong.qing.domain.system.config.vo.SysConfigVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
        uses = {
                GenericEnumMapper.class,
                DateMapper.class
        }
)
public interface SysConfigMapper {
    SysConfigMapper INSTANCE = Mappers.getMapper(SysConfigMapper.class);

    SysConfig dtoToEntity(SysConfigCreator dto);

    SysConfigUpdater request2Updater(SysConfigUpdateRequest request);

    SysConfigCreator request2Dto(SysConfigCreateRequest request);

    SysConfigQuery request2Query(SysConfigQueryRequest request);

    SysConfigResponse vo2Response(SysConfigVO vo);

    default SysConfigResponse vo2CustomResponse(SysConfigVO vo) {
        SysConfigResponse response = vo2Response(vo);
        return response;
    }
}
