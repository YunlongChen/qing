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
package cn.chenyunlong.qing.domain.system.job.job.service;

import cn.chenyunlong.common.model.JsonObject;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.system.job.job.request.SysJobCreateRequest;
import cn.chenyunlong.qing.domain.system.job.job.request.SysJobQueryRequest;
import cn.chenyunlong.qing.domain.system.job.job.request.SysJobUpdateRequest;
import cn.chenyunlong.qing.domain.system.job.job.response.SysJobResponse;

import java.lang.Long;
import java.lang.String;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "xxxSrv",
        contextId = "sysJobClient",
        path = "sysJob/v1"
)
public interface SysJobFeignService {
    /**
     * createRequest
     */
    @PostMapping("createSysJob")
    JsonObject<Long> createSysJob(@RequestBody SysJobCreateRequest request);

    /**
     * update request
     */
    @PostMapping("updateSysJob")
    JsonObject<String> updateSysJob(@RequestBody SysJobUpdateRequest request);

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    JsonObject<String> validSysJob(@PathVariable("id") Long id);

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    JsonObject<String> invalidSysJob(@PathVariable("id") Long id);

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    JsonObject<SysJobResponse> findById(@PathVariable("id") Long id);

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    JsonObject<PageResult<SysJobResponse>> findByPage(
            @RequestBody PageRequestWrapper<SysJobQueryRequest> request);
}
