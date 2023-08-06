/*
 * Copyright (c) 2019-2023  YunLong Chen
 * Project Qing is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *          https://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 *
 */

// ---Auto Generated by Qing-Generator --
package cn.chenyunlong.qing.samples.codegen.domain.controller;

import cn.chenyunlong.common.constants.CodeEnum;
import cn.chenyunlong.common.model.JsonResult;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.samples.codegen.domain.creator.TestDomainCreator;
import cn.chenyunlong.qing.samples.codegen.domain.mapper.TestDomainMapper;
import cn.chenyunlong.qing.samples.codegen.domain.query.TestDomainQuery;
import cn.chenyunlong.qing.samples.codegen.domain.request.TestDomainCreateRequest;
import cn.chenyunlong.qing.samples.codegen.domain.request.TestDomainQueryRequest;
import cn.chenyunlong.qing.samples.codegen.domain.request.TestDomainUpdateRequest;
import cn.chenyunlong.qing.samples.codegen.domain.response.TestDomainResponse;
import cn.chenyunlong.qing.samples.codegen.domain.service.ITestDomainService;
import cn.chenyunlong.qing.samples.codegen.domain.updater.TestDomainUpdater;
import cn.chenyunlong.qing.samples.codegen.domain.vo.TestDomainVO;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("api/v1/test-domain")
@RequiredArgsConstructor
public class TestDomainController {
    private final ITestDomainService testDomainService;

    /**
     * createRequest
     */
    @PostMapping
    public JsonResult<Long> createTestDomain(@RequestBody TestDomainCreateRequest request) {
        TestDomainCreator creator = TestDomainMapper.INSTANCE.request2Dto(request);return JsonResult.success(testDomainService.createTestDomain(creator));
    }

    /**
     * update request
     */
    @PostMapping("updateTestDomain")
    public JsonResult<String> updateTestDomain(@RequestBody TestDomainUpdateRequest request) {
        TestDomainUpdater updater = TestDomainMapper.INSTANCE.request2Updater(request);testDomainService.updateTestDomain(updater);
        return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    public JsonResult<String> validTestDomain(@PathVariable Long id) {
        testDomainService.validTestDomain(id);return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    public JsonResult<String> invalidTestDomain(@PathVariable Long id) {
        testDomainService.invalidTestDomain(id);return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    public JsonResult<TestDomainResponse> findById(@PathVariable Long id) {
        TestDomainVO vo = testDomainService.findById(id);TestDomainResponse response = TestDomainMapper.INSTANCE.vo2CustomResponse(vo);return JsonResult.success(response);
    }

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    public JsonResult<PageResult<TestDomainResponse>> page(
            @RequestBody PageRequestWrapper<TestDomainQueryRequest> request) {
        PageRequestWrapper<TestDomainQuery> wrapper = new PageRequestWrapper<>();
        wrapper.setBean(TestDomainMapper.INSTANCE.request2Query(request.getBean()));
        wrapper.setSorts(request.getSorts());
            wrapper.setPageSize(request.getPageSize());
            wrapper.setPage(request.getPage());
        Page<TestDomainVO> page = testDomainService.findByPage(wrapper);
        return JsonResult.success(
                PageResult.of(
                    page.getContent().stream()
                        .map(TestDomainMapper.INSTANCE::vo2CustomResponse)
                        .collect(Collectors.toList()),
                    page.getTotalElements(),
                    page.getSize(),
                    page.getNumber())
            );
    }
}
