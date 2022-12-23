// ---Auto Generated by Project Qing ---
package cn.chenyunlong.qing.domain.file.mapper;

import cn.chenyunlong.common.mapper.DateMapper;
import cn.chenyunlong.common.mapper.GenericEnumMapper;
import cn.chenyunlong.qing.domain.file.UploadFile;
import cn.chenyunlong.qing.domain.file.creator.UploadFileCreator;
import cn.chenyunlong.qing.domain.file.query.UploadFileQuery;
import cn.chenyunlong.qing.domain.file.request.UploadFileCreateRequest;
import cn.chenyunlong.qing.domain.file.request.UploadFileQueryRequest;
import cn.chenyunlong.qing.domain.file.request.UploadFileUpdateRequest;
import cn.chenyunlong.qing.domain.file.response.UploadFileResponse;
import cn.chenyunlong.qing.domain.file.updater.UploadFileUpdater;
import cn.chenyunlong.qing.domain.file.vo.UploadFileVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
        uses = {
                GenericEnumMapper.class,
                DateMapper.class
        }
)
public interface UploadFileMapper {
    UploadFileMapper INSTANCE = Mappers.getMapper(UploadFileMapper.class);

    UploadFile dtoToEntity(UploadFileCreator dto);

    UploadFileUpdater request2Updater(UploadFileUpdateRequest request);

    UploadFileCreator request2Dto(UploadFileCreateRequest request);

    UploadFileQuery request2Query(UploadFileQueryRequest request);

    UploadFileResponse vo2Response(UploadFileVO vo);

    default UploadFileResponse vo2CustomResponse(UploadFileVO vo) {
        UploadFileResponse response = vo2Response(vo);
        return response;
    }
}
