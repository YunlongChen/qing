// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.system.job.log.mapper;

import cn.chenyunlong.common.mapper.DateMapper;
import cn.chenyunlong.common.mapper.GenericEnumMapper;
import cn.chenyunlong.qing.domain.system.job.log.SysJobLog;
import cn.chenyunlong.qing.domain.system.job.log.creator.SysJobLogCreator;
import cn.chenyunlong.qing.domain.system.job.log.query.SysJobLogQuery;
import cn.chenyunlong.qing.domain.system.job.log.request.SysJobLogCreateRequest;
import cn.chenyunlong.qing.domain.system.job.log.request.SysJobLogQueryRequest;
import cn.chenyunlong.qing.domain.system.job.log.request.SysJobLogUpdateRequest;
import cn.chenyunlong.qing.domain.system.job.log.response.SysJobLogResponse;
import cn.chenyunlong.qing.domain.system.job.log.updater.SysJobLogUpdater;
import cn.chenyunlong.qing.domain.system.job.log.vo.SysJobLogVO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        uses = {
                GenericEnumMapper.class,
                DateMapper.class
        },
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface SysJobLogMapper {
    SysJobLogMapper INSTANCE = Mappers.getMapper(SysJobLogMapper.class);

    SysJobLog dtoToEntity(SysJobLogCreator dto);

    SysJobLogUpdater request2Updater(SysJobLogUpdateRequest request);

    SysJobLogCreator request2Dto(SysJobLogCreateRequest request);

    SysJobLogQuery request2Query(SysJobLogQueryRequest request);

    SysJobLogResponse vo2Response(SysJobLogVO vo);

    default SysJobLogResponse vo2CustomResponse(SysJobLogVO vo) {
        return vo2Response(vo);
    }
}
