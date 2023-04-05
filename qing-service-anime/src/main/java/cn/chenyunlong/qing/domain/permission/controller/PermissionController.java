// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.permission.controller;

import cn.chenyunlong.common.constants.CodeEnum;
import cn.chenyunlong.common.model.JsonResult;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.permission.creator.PermissionCreator;
import cn.chenyunlong.qing.domain.permission.mapper.PermissionMapper;
import cn.chenyunlong.qing.domain.permission.query.PermissionQuery;
import cn.chenyunlong.qing.domain.permission.request.PermissionCreateRequest;
import cn.chenyunlong.qing.domain.permission.request.PermissionQueryRequest;
import cn.chenyunlong.qing.domain.permission.request.PermissionUpdateRequest;
import cn.chenyunlong.qing.domain.permission.response.PermissionResponse;
import cn.chenyunlong.qing.domain.permission.service.IPermissionService;
import cn.chenyunlong.qing.domain.permission.updater.PermissionUpdater;
import cn.chenyunlong.qing.domain.permission.vo.PermissionVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("permission/v1")
@RequiredArgsConstructor
public class PermissionController {
    private final IPermissionService permissionService;

    /**
     * createRequest
     */
    @PostMapping
    public JsonResult<Long> createPermission(@RequestBody PermissionCreateRequest request) {
        PermissionCreator creator = PermissionMapper.INSTANCE.request2Dto(request);
        return JsonResult.success(permissionService.createPermission(creator));
    }

    /**
     * update request
     */
    @PostMapping("updatePermission")
    public JsonResult<String> updatePermission(@RequestBody PermissionUpdateRequest request) {
        PermissionUpdater updater = PermissionMapper.INSTANCE.request2Updater(request);
        permissionService.updatePermission(updater);
        return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    public JsonResult<String> validPermission(@PathVariable Long id) {
        permissionService.validPermission(id);
        return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    public JsonResult<String> invalidPermission(@PathVariable Long id) {
        permissionService.invalidPermission(id);
        return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    public JsonResult<PermissionResponse> findById(@PathVariable Long id) {
        PermissionVO vo = permissionService.findById(id);
        PermissionResponse response = PermissionMapper.INSTANCE.vo2CustomResponse(vo);
        return JsonResult.success(response);
    }

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    public JsonResult<PageResult<PermissionResponse>> findByPage(
            @RequestBody PageRequestWrapper<PermissionQueryRequest> request) {
        PageRequestWrapper<PermissionQuery> wrapper = new PageRequestWrapper<>();
        wrapper.setBean(PermissionMapper.INSTANCE.request2Query(request.getBean()));
        wrapper.setSorts(request.getSorts());
        wrapper.setPageSize(request.getPageSize());
        wrapper.setPage(request.getPage());
        Page<PermissionVO> page = permissionService.findByPage(wrapper);
        return JsonResult.success(
                PageResult.of(
                        page.getContent().stream()
                                .map(vo -> PermissionMapper.INSTANCE.vo2CustomResponse(vo))
                                .collect(Collectors.toList()),
                        page.getTotalElements(),
                        page.getSize(),
                        page.getNumber())
        );
    }
}
