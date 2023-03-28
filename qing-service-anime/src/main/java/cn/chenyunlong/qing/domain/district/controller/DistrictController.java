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
package cn.chenyunlong.qing.domain.district.controller;

import cn.chenyunlong.common.constants.CodeEnum;
import cn.chenyunlong.common.model.JsonObject;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.district.creator.DistrictCreator;
import cn.chenyunlong.qing.domain.district.mapper.DistrictMapper;
import cn.chenyunlong.qing.domain.district.query.DistrictQuery;
import cn.chenyunlong.qing.domain.district.request.DistrictCreateRequest;
import cn.chenyunlong.qing.domain.district.request.DistrictQueryRequest;
import cn.chenyunlong.qing.domain.district.request.DistrictUpdateRequest;
import cn.chenyunlong.qing.domain.district.response.DistrictResponse;
import cn.chenyunlong.qing.domain.district.service.IDistrictService;
import cn.chenyunlong.qing.domain.district.updater.DistrictUpdater;
import cn.chenyunlong.qing.domain.district.vo.DistrictVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("district/v1")
@RequiredArgsConstructor
public class DistrictController {
    private final IDistrictService districtService;

    /**
     * createRequest
     */
    @PostMapping("createDistrict")
    public JsonObject<Long> createDistrict(@RequestBody DistrictCreateRequest request) {
        DistrictCreator creator = DistrictMapper.INSTANCE.request2Dto(request);
        return JsonObject.success(districtService.createDistrict(creator));
    }

    /**
     * update request
     */
    @PostMapping("updateDistrict")
    public JsonObject<String> updateDistrict(@RequestBody DistrictUpdateRequest request) {
        DistrictUpdater updater = DistrictMapper.INSTANCE.request2Updater(request);
        districtService.updateDistrict(updater);
        return JsonObject.success(CodeEnum.Success.getName());
    }

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    public JsonObject<String> validDistrict(@PathVariable Long id) {
        districtService.validDistrict(id);
        return JsonObject.success(CodeEnum.Success.getName());
    }

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    public JsonObject<String> invalidDistrict(@PathVariable Long id) {
        districtService.invalidDistrict(id);
        return JsonObject.success(CodeEnum.Success.getName());
    }

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    public JsonObject<DistrictResponse> findById(@PathVariable Long id) {
        DistrictVO vo = districtService.findById(id);
        DistrictResponse response = DistrictMapper.INSTANCE.vo2CustomResponse(vo);
        return JsonObject.success(response);
    }

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    public JsonObject<PageResult<DistrictResponse>> findByPage(
            @RequestBody PageRequestWrapper<DistrictQueryRequest> request) {
        PageRequestWrapper<DistrictQuery> wrapper = new PageRequestWrapper<>();
        wrapper.setBean(DistrictMapper.INSTANCE.request2Query(request.getBean()));
        wrapper.setSorts(request.getSorts());
        wrapper.setPageSize(request.getPageSize());
        wrapper.setPage(request.getPage());
        Page<DistrictVO> page = districtService.findByPage(wrapper);
        return JsonObject.success(
                PageResult.of(
                        page.getContent().stream()
                                .map(vo -> DistrictMapper.INSTANCE.vo2CustomResponse(vo))
                                .collect(Collectors.toList()),
                        page.getTotalElements(),
                        page.getSize(),
                        page.getNumber())
        );
    }
}
