// ---Auto Generated by Qing-Generator --

package cn.chenyunlong.qing.domain.district.service;

import cn.chenyunlong.common.model.JsonResult;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.district.request.DistrictCreateRequest;
import cn.chenyunlong.qing.domain.district.request.DistrictQueryRequest;
import cn.chenyunlong.qing.domain.district.request.DistrictUpdateRequest;
import cn.chenyunlong.qing.domain.district.response.DistrictResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
    value = "stanic",
    contextId = "districtClient",
    path = "district/v1"
)
public interface DistrictFeignService {
    /**
     * createRequest
     */
    @PostMapping("createDistrict")
    JsonResult<Long> createDistrict(@RequestBody DistrictCreateRequest request);

    /**
     * update request
     */
    @PostMapping("updateDistrict")
    JsonResult<String> updateDistrict(@RequestBody DistrictUpdateRequest request);

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    JsonResult<String> validDistrict(@PathVariable("id") Long id);

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    JsonResult<String> invalidDistrict(@PathVariable("id") Long id);

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    JsonResult<DistrictResponse> findById(@PathVariable("id") Long id);

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    JsonResult<PageResult<DistrictResponse>> findByPage(
        @RequestBody PageRequestWrapper<DistrictQueryRequest> request);
}
