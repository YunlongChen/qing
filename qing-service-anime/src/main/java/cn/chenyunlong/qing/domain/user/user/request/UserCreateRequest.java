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
package cn.chenyunlong.qing.domain.user.user.request;

import cn.chenyunlong.common.model.Request;
import cn.chenyunlong.qing.infrastructure.enums.MFAType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema
public class UserCreateRequest implements Request {
    @Schema(
            title = "uid"
    )
    private Long uid;

    @Schema(
            title = "username"
    )
    private String username;

    @Schema(
            title = "nickname"
    )
    private String nickname;

    @Schema(
            title = "password"
    )
    private String password;

    @Schema(
            title = "phone"
    )
    private String phone;

    @Schema(
            title = "email"
    )
    private String email;

    @Schema(
            title = "avatar"
    )
    private String avatar;

    @Schema(
            title = "description"
    )
    private String description;

    @Schema(
            title = "expireTime"
    )
    private LocalDateTime expireTime;

    @Schema(
            title = "mfaType"
    )
    private MFAType mfaType;

    @Schema(
            title = "mfaKey"
    )
    private String mfaKey;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public MFAType getMfaType() {
        return mfaType;
    }

    public void setMfaType(MFAType mfaType) {
        this.mfaType = mfaType;
    }

    public String getMfaKey() {
        return mfaKey;
    }

    public void setMfaKey(String mfaKey) {
        this.mfaKey = mfaKey;
    }
}
