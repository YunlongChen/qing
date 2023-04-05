// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.system.job.job.mapper;

import cn.chenyunlong.common.mapper.DateMapper;
import cn.chenyunlong.common.mapper.GenericEnumMapper;
import cn.chenyunlong.qing.domain.system.job.job.SysJob;
import cn.chenyunlong.qing.domain.system.job.job.creator.SysJobCreator;
import cn.chenyunlong.qing.domain.system.job.job.query.SysJobQuery;
import cn.chenyunlong.qing.domain.system.job.job.request.SysJobCreateRequest;
import cn.chenyunlong.qing.domain.system.job.job.request.SysJobQueryRequest;
import cn.chenyunlong.qing.domain.system.job.job.request.SysJobUpdateRequest;
import cn.chenyunlong.qing.domain.system.job.job.response.SysJobResponse;
import cn.chenyunlong.qing.domain.system.job.job.updater.SysJobUpdater;
import cn.chenyunlong.qing.domain.system.job.job.vo.SysJobVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
        uses = {
                GenericEnumMapper.class,
                DateMapper.class
        }
)
public interface SysJobMapper {
    SysJobMapper INSTANCE = Mappers.getMapper(SysJobMapper.class);

    SysJob dtoToEntity(SysJobCreator dto);

    SysJobUpdater request2Updater(SysJobUpdateRequest request);

    SysJobCreator request2Dto(SysJobCreateRequest request);

    SysJobQuery request2Query(SysJobQueryRequest request);

    SysJobResponse vo2Response(SysJobVO vo);

    default SysJobResponse vo2CustomResponse(SysJobVO vo) {
        SysJobResponse response = vo2Response(vo);
        return response;
    }
}
