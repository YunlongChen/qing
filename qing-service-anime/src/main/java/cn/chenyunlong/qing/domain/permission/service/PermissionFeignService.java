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
package cn.chenyunlong.qing.domain.permission.service;

import cn.chenyunlong.common.model.JsonObject;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.permission.request.PermissionCreateRequest;
import cn.chenyunlong.qing.domain.permission.request.PermissionQueryRequest;
import cn.chenyunlong.qing.domain.permission.request.PermissionUpdateRequest;
import cn.chenyunlong.qing.domain.permission.response.PermissionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "xxxSrv",
        contextId = "permissionClient",
        path = "permission/v1"
)
public interface PermissionFeignService {
    /**
     * createRequest
     */
    @PostMapping("createPermission")
    JsonObject<Long> createPermission(@RequestBody PermissionCreateRequest request);

    /**
     * update request
     */
    @PostMapping("updatePermission")
    JsonObject<String> updatePermission(@RequestBody PermissionUpdateRequest request);

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    JsonObject<String> validPermission(@PathVariable("id") Long id);

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    JsonObject<String> invalidPermission(@PathVariable("id") Long id);

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    JsonObject<PermissionResponse> findById(@PathVariable("id") Long id);

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    JsonObject<PageResult<PermissionResponse>> findByPage(
            @RequestBody PageRequestWrapper<PermissionQueryRequest> request);
}
