// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.sign.service;

import cn.chenyunlong.common.model.JsonResult;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.sign.request.SignCreateRequest;
import cn.chenyunlong.qing.domain.sign.request.SignQueryRequest;
import cn.chenyunlong.qing.domain.sign.request.SignUpdateRequest;
import cn.chenyunlong.qing.domain.sign.response.SignResponse;

import java.lang.Long;
import java.lang.String;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "xxxSrv",
        contextId = "signClient",
        path = "sign/v1"
)
public interface SignFeignService {
    /**
     * createRequest
     */
    @PostMapping("createSign")
    JsonResult<Long> createSign(@RequestBody SignCreateRequest request);

    /**
     * update request
     */
    @PostMapping("updateSign")
    JsonResult<String> updateSign(@RequestBody SignUpdateRequest request);

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    JsonResult<String> validSign(@PathVariable("id") Long id);

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    JsonResult<String> invalidSign(@PathVariable("id") Long id);

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    JsonResult<SignResponse> findById(@PathVariable("id") Long id);

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    JsonResult<PageResult<SignResponse>> findByPage(
            @RequestBody PageRequestWrapper<SignQueryRequest> request);
}
