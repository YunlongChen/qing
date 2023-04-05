// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.user.user.controller;

import cn.chenyunlong.common.constants.CodeEnum;
import cn.chenyunlong.common.model.JsonResult;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.user.user.creator.UserCreator;
import cn.chenyunlong.qing.domain.user.user.mapper.UserMapper;
import cn.chenyunlong.qing.domain.user.user.query.UserQuery;
import cn.chenyunlong.qing.domain.user.user.request.UserCreateRequest;
import cn.chenyunlong.qing.domain.user.user.request.UserQueryRequest;
import cn.chenyunlong.qing.domain.user.user.request.UserUpdateRequest;
import cn.chenyunlong.qing.domain.user.user.response.UserResponse;
import cn.chenyunlong.qing.domain.user.user.service.IUserService;
import cn.chenyunlong.qing.domain.user.user.updater.UserUpdater;
import cn.chenyunlong.qing.domain.user.user.vo.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("user/v1")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    /**
     * createRequest
     */
    @PostMapping
    public JsonResult<Long> createUser(@RequestBody UserCreateRequest request) {
        UserCreator creator = UserMapper.INSTANCE.request2Dto(request);
        return JsonResult.success(userService.createUser(creator));
    }

    /**
     * update request
     */
    @PostMapping("updateUser")
    public JsonResult<String> updateUser(@RequestBody UserUpdateRequest request) {
        UserUpdater updater = UserMapper.INSTANCE.request2Updater(request);
        userService.updateUser(updater);
        return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    public JsonResult<String> validUser(@PathVariable Long id) {
        userService.validUser(id);
        return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    public JsonResult<String> invalidUser(@PathVariable Long id) {
        userService.invalidUser(id);
        return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    public JsonResult<UserResponse> findById(@PathVariable Long id) {
        UserVO vo = userService.findById(id);
        UserResponse response = UserMapper.INSTANCE.vo2CustomResponse(vo);
        return JsonResult.success(response);
    }

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    public JsonResult<PageResult<UserResponse>> findByPage(
            @RequestBody PageRequestWrapper<UserQueryRequest> request) {
        PageRequestWrapper<UserQuery> wrapper = new PageRequestWrapper<>();
        wrapper.setBean(UserMapper.INSTANCE.request2Query(request.getBean()));
        wrapper.setSorts(request.getSorts());
        wrapper.setPageSize(request.getPageSize());
        wrapper.setPage(request.getPage());
        Page<UserVO> page = userService.findByPage(wrapper);
        return JsonResult.success(
                PageResult.of(
                        page.getContent().stream()
                                .map(vo -> UserMapper.INSTANCE.vo2CustomResponse(vo))
                                .collect(Collectors.toList()),
                        page.getTotalElements(),
                        page.getSize(),
                        page.getNumber())
        );
    }
}
