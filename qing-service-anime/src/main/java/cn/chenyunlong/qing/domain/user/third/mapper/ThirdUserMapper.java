// ---Auto Generated by Project Qing ---
package cn.chenyunlong.qing.domain.user.third.mapper;

import cn.chenyunlong.common.mapper.DateMapper;
import cn.chenyunlong.common.mapper.GenericEnumMapper;
import cn.chenyunlong.qing.domain.user.third.ThirdUser;
import cn.chenyunlong.qing.domain.user.third.creator.ThirdUserCreator;
import cn.chenyunlong.qing.domain.user.third.query.ThirdUserQuery;
import cn.chenyunlong.qing.domain.user.third.request.ThirdUserCreateRequest;
import cn.chenyunlong.qing.domain.user.third.request.ThirdUserQueryRequest;
import cn.chenyunlong.qing.domain.user.third.request.ThirdUserUpdateRequest;
import cn.chenyunlong.qing.domain.user.third.response.ThirdUserResponse;
import cn.chenyunlong.qing.domain.user.third.updater.ThirdUserUpdater;
import cn.chenyunlong.qing.domain.user.third.vo.ThirdUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
        uses = {
                GenericEnumMapper.class,
                DateMapper.class
        }
)
public interface ThirdUserMapper {
    ThirdUserMapper INSTANCE = Mappers.getMapper(ThirdUserMapper.class);

    ThirdUser dtoToEntity(ThirdUserCreator dto);

    ThirdUserUpdater request2Updater(ThirdUserUpdateRequest request);

    ThirdUserCreator request2Dto(ThirdUserCreateRequest request);

    ThirdUserQuery request2Query(ThirdUserQueryRequest request);

    ThirdUserResponse vo2Response(ThirdUserVO vo);

    default ThirdUserResponse vo2CustomResponse(ThirdUserVO vo) {
        ThirdUserResponse response = vo2Response(vo);
        return response;
    }
}
