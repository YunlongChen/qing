// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.file.controller;

import cn.chenyunlong.common.constants.CodeEnum;
import cn.chenyunlong.common.model.JsonResult;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.file.creator.UploadFileCreator;
import cn.chenyunlong.qing.domain.file.mapper.UploadFileMapper;
import cn.chenyunlong.qing.domain.file.query.UploadFileQuery;
import cn.chenyunlong.qing.domain.file.request.UploadFileCreateRequest;
import cn.chenyunlong.qing.domain.file.request.UploadFileQueryRequest;
import cn.chenyunlong.qing.domain.file.request.UploadFileUpdateRequest;
import cn.chenyunlong.qing.domain.file.response.UploadFileResponse;
import cn.chenyunlong.qing.domain.file.service.IUploadFileService;
import cn.chenyunlong.qing.domain.file.updater.UploadFileUpdater;
import cn.chenyunlong.qing.domain.file.vo.UploadFileVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("uploadFile/v1")
@RequiredArgsConstructor
public class UploadFileController {
    private final IUploadFileService uploadFileService;

    /**
     * createRequest
     */
    @PostMapping
    public JsonResult<Long> createUploadFile(@RequestBody UploadFileCreateRequest request) {
        UploadFileCreator creator = UploadFileMapper.INSTANCE.request2Dto(request);
        return JsonResult.success(uploadFileService.createUploadFile(creator));
    }

    /**
     * update request
     */
    @PostMapping("updateUploadFile")
    public JsonResult<String> updateUploadFile(@RequestBody UploadFileUpdateRequest request) {
        UploadFileUpdater updater = UploadFileMapper.INSTANCE.request2Updater(request);
        uploadFileService.updateUploadFile(updater);
        return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    public JsonResult<String> validUploadFile(@PathVariable Long id) {
        uploadFileService.validUploadFile(id);
        return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    public JsonResult<String> invalidUploadFile(@PathVariable Long id) {
        uploadFileService.invalidUploadFile(id);
        return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    public JsonResult<UploadFileResponse> findById(@PathVariable Long id) {
        UploadFileVO vo = uploadFileService.findById(id);
        UploadFileResponse response = UploadFileMapper.INSTANCE.vo2CustomResponse(vo);
        return JsonResult.success(response);
    }

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    public JsonResult<PageResult<UploadFileResponse>> findByPage(
            @RequestBody PageRequestWrapper<UploadFileQueryRequest> request) {
        PageRequestWrapper<UploadFileQuery> wrapper = new PageRequestWrapper<>();
        wrapper.setBean(UploadFileMapper.INSTANCE.request2Query(request.getBean()));
        wrapper.setSorts(request.getSorts());
        wrapper.setPageSize(request.getPageSize());
        wrapper.setPage(request.getPage());
        Page<UploadFileVO> page = uploadFileService.findByPage(wrapper);
        return JsonResult.success(
                PageResult.of(
                        page.getContent().stream()
                                .map(UploadFileMapper.INSTANCE::vo2CustomResponse)
                                .collect(Collectors.toList()),
                        page.getTotalElements(),
                        page.getSize(),
                        page.getNumber())
        );
    }
}
