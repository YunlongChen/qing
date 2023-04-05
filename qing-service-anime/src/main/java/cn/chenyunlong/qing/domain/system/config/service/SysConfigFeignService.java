// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.system.config.service;

import cn.chenyunlong.common.model.JsonResult;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.system.config.request.SysConfigCreateRequest;
import cn.chenyunlong.qing.domain.system.config.request.SysConfigQueryRequest;
import cn.chenyunlong.qing.domain.system.config.request.SysConfigUpdateRequest;
import cn.chenyunlong.qing.domain.system.config.response.SysConfigResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "xxxSrv",
        contextId = "sysConfigClient",
        path = "sysConfig/v1"
)
public interface SysConfigFeignService {
    /**
     * createRequest
     */
    @PostMapping("createSysConfig")
    JsonResult<Long> createSysConfig(@RequestBody SysConfigCreateRequest request);

    /**
     * update request
     */
    @PostMapping("updateSysConfig")
    JsonResult<String> updateSysConfig(@RequestBody SysConfigUpdateRequest request);

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    JsonResult<String> validSysConfig(@PathVariable("id") Long id);

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    JsonResult<String> invalidSysConfig(@PathVariable("id") Long id);

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    JsonResult<SysConfigResponse> findById(@PathVariable("id") Long id);

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    JsonResult<PageResult<SysConfigResponse>> findByPage(
            @RequestBody PageRequestWrapper<SysConfigQueryRequest> request);
}
