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
package cn.chenyunlong.qing.domain.user.user.service;

import cn.chenyunlong.common.model.JsonObject;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.user.user.request.UserCreateRequest;
import cn.chenyunlong.qing.domain.user.user.request.UserQueryRequest;
import cn.chenyunlong.qing.domain.user.user.request.UserUpdateRequest;
import cn.chenyunlong.qing.domain.user.user.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "xxxSrv",
        contextId = "userClient",
        path = "user/v1"
)
public interface UserFeignService {
  /**
   * createRequest
   */
  @PostMapping("createUser")
  JsonObject<Long> createUser(@RequestBody UserCreateRequest request);

  /**
   * update request
   */
  @PostMapping("updateUser")
  JsonObject<String> updateUser(@RequestBody UserUpdateRequest request);

  /**
   * valid
   */
  @PostMapping("valid/{id}")
  JsonObject<String> validUser(@PathVariable("id") Long id);

  /**
   * invalid
   */
  @PostMapping("invalid/{id}")
  JsonObject<String> invalidUser(@PathVariable("id") Long id);

  /**
   * findById
   */
  @GetMapping("findById/{id}")
  JsonObject<UserResponse> findById(@PathVariable("id") Long id);

  /**
   * findByPage request
   */
  @PostMapping("findByPage")
  JsonObject<PageResult<UserResponse>> findByPage(
          @RequestBody PageRequestWrapper<UserQueryRequest> request);
}
