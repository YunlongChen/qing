// ---Auto Generated by Qing-Generator --

package cn.chenyunlong.qing.domain.user.mapper;

import cn.chenyunlong.qing.domain.user.User;
import cn.chenyunlong.qing.domain.user.creator.UserCreator;
import cn.chenyunlong.qing.domain.user.query.UserQuery;
import cn.chenyunlong.qing.domain.user.request.UserCreateRequest;
import cn.chenyunlong.qing.domain.user.request.UserQueryRequest;
import cn.chenyunlong.qing.domain.user.request.UserUpdateRequest;
import cn.chenyunlong.qing.domain.user.response.UserResponse;
import cn.chenyunlong.qing.domain.user.updater.UserUpdater;
import cn.chenyunlong.qing.domain.user.vo.UserVO;
import cn.hutool.core.bean.BeanUtil;

public interface UserMapper {
    UserMapper INSTANCE = new UserMapper() {
    };

    default User dtoToEntity(UserCreator dto) {
        return BeanUtil.copyProperties(dto, User.class);
    }

    default UserUpdater request2Updater(UserUpdateRequest request) {
        return BeanUtil.copyProperties(request, UserUpdater.class);
    }

    default UserCreator request2Dto(UserCreateRequest request) {
        return BeanUtil.copyProperties(request, UserCreator.class);
    }

    default UserQuery request2Query(UserQueryRequest request) {
        return BeanUtil.copyProperties(request, UserQuery.class);
    }

    default UserResponse vo2CustomResponse(UserVO vo) {
        return vo2Response(vo);
    }

    default UserResponse vo2Response(UserVO vo) {
        return BeanUtil.copyProperties(vo, UserResponse.class);
    }
}
