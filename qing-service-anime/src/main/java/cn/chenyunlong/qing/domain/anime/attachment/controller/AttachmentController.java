/*
 * Copyright (c) 2023  YunLong Chen
 * Project Qing is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *          http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 *
 */

// ---Auto Generated by Project Qing ---
package cn.chenyunlong.qing.domain.anime.attachment.controller;

import cn.chenyunlong.common.constants.CodeEnum;
import cn.chenyunlong.common.model.JsonObject;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.anime.attachment.creator.AttachmentCreator;
import cn.chenyunlong.qing.domain.anime.attachment.mapper.AttachmentMapper;
import cn.chenyunlong.qing.domain.anime.attachment.query.AttachmentQuery;
import cn.chenyunlong.qing.domain.anime.attachment.request.AttachmentCreateRequest;
import cn.chenyunlong.qing.domain.anime.attachment.request.AttachmentQueryRequest;
import cn.chenyunlong.qing.domain.anime.attachment.request.AttachmentUpdateRequest;
import cn.chenyunlong.qing.domain.anime.attachment.response.AttachmentResponse;
import cn.chenyunlong.qing.domain.anime.attachment.service.IAttachmentService;
import cn.chenyunlong.qing.domain.anime.attachment.updater.AttachmentUpdater;
import cn.chenyunlong.qing.domain.anime.attachment.vo.AttachmentVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("attachment/v1")
@RequiredArgsConstructor
public class AttachmentController {
    private final IAttachmentService attachmentService;

    /**
     * createRequest
     */
    @PostMapping("createAttachment")
    public JsonObject<Long> createAttachment(@RequestBody AttachmentCreateRequest request) {
        AttachmentCreator creator = AttachmentMapper.INSTANCE.request2Dto(request);
        return JsonObject.success(attachmentService.createAttachment(creator));
    }

    /**
     * update request
     */
    @PostMapping("updateAttachment")
    public JsonObject<String> updateAttachment(@RequestBody AttachmentUpdateRequest request) {
        AttachmentUpdater updater = AttachmentMapper.INSTANCE.request2Updater(request);
        attachmentService.updateAttachment(updater);
        return JsonObject.success(CodeEnum.Success.getName());
    }

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    public JsonObject<String> validAttachment(@PathVariable Long id) {
        attachmentService.validAttachment(id);
        return JsonObject.success(CodeEnum.Success.getName());
    }

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    public JsonObject<String> invalidAttachment(@PathVariable Long id) {
        attachmentService.invalidAttachment(id);
        return JsonObject.success(CodeEnum.Success.getName());
    }

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    public JsonObject<AttachmentResponse> findById(@PathVariable Long id) {
        AttachmentVO vo = attachmentService.findById(id);
        AttachmentResponse response = AttachmentMapper.INSTANCE.vo2CustomResponse(vo);
        return JsonObject.success(response);
    }

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    public JsonObject<PageResult<AttachmentResponse>> findByPage(
            @RequestBody PageRequestWrapper<AttachmentQueryRequest> request) {
        PageRequestWrapper<AttachmentQuery> wrapper = new PageRequestWrapper<>();
        wrapper.setBean(AttachmentMapper.INSTANCE.request2Query(request.getBean()));
        wrapper.setSorts(request.getSorts());
        wrapper.setPageSize(request.getPageSize());
        wrapper.setPage(request.getPage());
        Page<AttachmentVO> page = attachmentService.findByPage(wrapper);
        return JsonObject.success(
                PageResult.of(
                        page.getContent().stream()
                                .map(AttachmentMapper.INSTANCE::vo2CustomResponse)
                                .collect(Collectors.toList()),
                        page.getTotalElements(),
                        page.getSize(),
                        page.getNumber())
        );
    }
}
