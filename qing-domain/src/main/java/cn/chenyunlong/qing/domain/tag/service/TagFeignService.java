// ---Auto Generated by Qing-Generator --

package cn.chenyunlong.qing.domain.tag.service;

import cn.chenyunlong.common.model.JsonResult;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.tag.request.TagCreateRequest;
import cn.chenyunlong.qing.domain.tag.request.TagQueryRequest;
import cn.chenyunlong.qing.domain.tag.request.TagUpdateRequest;
import cn.chenyunlong.qing.domain.tag.response.TagResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
    value = "stanic",
    contextId = "tagClient",
    path = "tag/v1"
)
public interface TagFeignService {
    /**
     * createRequest
     */
    @PostMapping("createTag")
    JsonResult<Long> createTag(@RequestBody TagCreateRequest request);

    /**
     * update request
     */
    @PostMapping("updateTag")
    JsonResult<String> updateTag(@RequestBody TagUpdateRequest request);

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    JsonResult<String> validTag(@PathVariable("id") Long id);

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    JsonResult<String> invalidTag(@PathVariable("id") Long id);

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    JsonResult<TagResponse> findById(@PathVariable("id") Long id);

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    JsonResult<PageResult<TagResponse>> findByPage(
        @RequestBody PageRequestWrapper<TagQueryRequest> request);
}
