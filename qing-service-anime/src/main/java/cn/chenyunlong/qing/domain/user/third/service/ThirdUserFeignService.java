// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.user.third.service;

import cn.chenyunlong.common.model.JsonResult;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.user.third.request.ThirdUserCreateRequest;
import cn.chenyunlong.qing.domain.user.third.request.ThirdUserQueryRequest;
import cn.chenyunlong.qing.domain.user.third.request.ThirdUserUpdateRequest;
import cn.chenyunlong.qing.domain.user.third.response.ThirdUserResponse;

import java.lang.Long;
import java.lang.String;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "xxxSrv",
        contextId = "thirdUserClient",
        path = "thirdUser/v1"
)
public interface ThirdUserFeignService {
    /**
     * createRequest
     */
    @PostMapping("createThirdUser")
    JsonResult<Long> createThirdUser(@RequestBody ThirdUserCreateRequest request);

    /**
     * update request
     */
    @PostMapping("updateThirdUser")
    JsonResult<String> updateThirdUser(@RequestBody ThirdUserUpdateRequest request);

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    JsonResult<String> validThirdUser(@PathVariable("id") Long id);

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    JsonResult<String> invalidThirdUser(@PathVariable("id") Long id);

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    JsonResult<ThirdUserResponse> findById(@PathVariable("id") Long id);

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    JsonResult<PageResult<ThirdUserResponse>> findByPage(
            @RequestBody PageRequestWrapper<ThirdUserQueryRequest> request);
}
