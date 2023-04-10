// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.attachment.service;

import cn.chenyunlong.common.model.JsonResult;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.anime.attachment.request.AttachmentCreateRequest;
import cn.chenyunlong.qing.domain.anime.attachment.request.AttachmentQueryRequest;
import cn.chenyunlong.qing.domain.anime.attachment.request.AttachmentUpdateRequest;
import cn.chenyunlong.qing.domain.anime.attachment.response.AttachmentResponse;

import java.lang.Long;
import java.lang.String;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "xxxSrv",
        contextId = "attachmentClient",
        path = "attachment/v1"
)
public interface AttachmentFeignService {
    /**
     * createRequest
     */
    @PostMapping("createAttachment")
    JsonResult<Long> createAttachment(@RequestBody AttachmentCreateRequest request);

    /**
     * update request
     */
    @PostMapping("updateAttachment")
    JsonResult<String> updateAttachment(@RequestBody AttachmentUpdateRequest request);

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    JsonResult<String> validAttachment(@PathVariable("id") Long id);

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    JsonResult<String> invalidAttachment(@PathVariable("id") Long id);

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    JsonResult<AttachmentResponse> findById(@PathVariable("id") Long id);

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    JsonResult<PageResult<AttachmentResponse>> findByPage(
            @RequestBody PageRequestWrapper<AttachmentQueryRequest> request);
}
