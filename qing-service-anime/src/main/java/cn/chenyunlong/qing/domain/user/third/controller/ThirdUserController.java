// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.user.third.controller;

import cn.chenyunlong.common.constants.CodeEnum;
import cn.chenyunlong.common.model.JsonResult;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.user.third.creator.ThirdUserCreator;
import cn.chenyunlong.qing.domain.user.third.mapper.ThirdUserMapper;
import cn.chenyunlong.qing.domain.user.third.query.ThirdUserQuery;
import cn.chenyunlong.qing.domain.user.third.request.ThirdUserCreateRequest;
import cn.chenyunlong.qing.domain.user.third.request.ThirdUserQueryRequest;
import cn.chenyunlong.qing.domain.user.third.request.ThirdUserUpdateRequest;
import cn.chenyunlong.qing.domain.user.third.response.ThirdUserResponse;
import cn.chenyunlong.qing.domain.user.third.service.IThirdUserService;
import cn.chenyunlong.qing.domain.user.third.updater.ThirdUserUpdater;
import cn.chenyunlong.qing.domain.user.third.vo.ThirdUserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("thirdUser/v1")
@RequiredArgsConstructor
public class ThirdUserController {
    private final IThirdUserService thirdUserService;

    /**
     * createRequest
     */
    @PostMapping
    public JsonResult<Long> createThirdUser(@RequestBody ThirdUserCreateRequest request) {
        ThirdUserCreator creator = ThirdUserMapper.INSTANCE.request2Dto(request);
        return JsonResult.success(thirdUserService.createThirdUser(creator));
    }

    /**
     * update request
     */
    @PostMapping("updateThirdUser")
    public JsonResult<String> updateThirdUser(@RequestBody ThirdUserUpdateRequest request) {
        ThirdUserUpdater updater = ThirdUserMapper.INSTANCE.request2Updater(request);
        thirdUserService.updateThirdUser(updater);
        return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    public JsonResult<String> validThirdUser(@PathVariable Long id) {
        thirdUserService.validThirdUser(id);
        return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    public JsonResult<String> invalidThirdUser(@PathVariable Long id) {
        thirdUserService.invalidThirdUser(id);
        return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    public JsonResult<ThirdUserResponse> findById(@PathVariable Long id) {
        ThirdUserVO vo = thirdUserService.findById(id);
        ThirdUserResponse response = ThirdUserMapper.INSTANCE.vo2CustomResponse(vo);
        return JsonResult.success(response);
    }

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    public JsonResult<PageResult<ThirdUserResponse>> findByPage(
            @RequestBody PageRequestWrapper<ThirdUserQueryRequest> request) {
        PageRequestWrapper<ThirdUserQuery> wrapper = new PageRequestWrapper<>();
        wrapper.setBean(ThirdUserMapper.INSTANCE.request2Query(request.getBean()));
        wrapper.setSorts(request.getSorts());
        wrapper.setPageSize(request.getPageSize());
        wrapper.setPage(request.getPage());
        Page<ThirdUserVO> page = thirdUserService.findByPage(wrapper);
        return JsonResult.success(
                PageResult.of(
                        page.getContent().stream()
                                .map(ThirdUserMapper.INSTANCE::vo2CustomResponse)
                                .collect(Collectors.toList()),
                        page.getTotalElements(),
                        page.getSize(),
                        page.getNumber())
        );
    }
}
