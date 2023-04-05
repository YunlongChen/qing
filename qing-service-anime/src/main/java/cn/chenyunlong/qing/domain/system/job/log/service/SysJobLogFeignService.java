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

// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.system.job.log.service;

import cn.chenyunlong.common.model.JsonResult;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.system.job.log.request.SysJobLogCreateRequest;
import cn.chenyunlong.qing.domain.system.job.log.request.SysJobLogQueryRequest;
import cn.chenyunlong.qing.domain.system.job.log.request.SysJobLogUpdateRequest;
import cn.chenyunlong.qing.domain.system.job.log.response.SysJobLogResponse;

import java.lang.Long;
import java.lang.String;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "xxxSrv",
        contextId = "sysJobLogClient",
        path = "sysJobLog/v1"
)
public interface SysJobLogFeignService {
    /**
     * createRequest
     */
    @PostMapping("createSysJobLog")
    JsonResult<Long> createSysJobLog(@RequestBody SysJobLogCreateRequest request);

    /**
     * update request
     */
    @PostMapping("updateSysJobLog")
    JsonResult<String> updateSysJobLog(@RequestBody SysJobLogUpdateRequest request);

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    JsonResult<String> validSysJobLog(@PathVariable("id") Long id);

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    JsonResult<String> invalidSysJobLog(@PathVariable("id") Long id);

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    JsonResult<SysJobLogResponse> findById(@PathVariable("id") Long id);

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    JsonResult<PageResult<SysJobLogResponse>> findByPage(
            @RequestBody PageRequestWrapper<SysJobLogQueryRequest> request);
}
