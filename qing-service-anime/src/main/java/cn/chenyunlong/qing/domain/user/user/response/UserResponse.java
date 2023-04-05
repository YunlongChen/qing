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
package cn.chenyunlong.qing.domain.user.user.response;

import cn.chenyunlong.common.model.AbstractJpaResponse;
import cn.chenyunlong.qing.infrastructure.enums.MFAType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Schema
@Data
@EqualsAndHashCode(
        callSuper = true
)
public class UserResponse extends AbstractJpaResponse {
    @Schema(
            title = "uid",
            description = "uid"
    )
    private Long uid;

    @Schema(
            title = "username",
            description = "username"
    )
    private String username;

    @Schema(
            title = "nickname",
            description = "nickname"
    )
    private String nickname;

    @Schema(
            title = "password",
            description = "password"
    )
    private String password;

    @Schema(
            title = "phone",
            description = "phone"
    )
    private String phone;

    @Schema(
            title = "email",
            description = "email"
    )
    private String email;

    @Schema(
            title = "avatar",
            description = "avatar"
    )
    private String avatar;

    @Schema(
            title = "description",
            description = "description"
    )
    private String description;

    @Schema(
            title = "expireTime",
            description = "expireTime"
    )
    private LocalDateTime expireTime;

    @Schema(
            title = "mfaType",
            description = "mfaType"
    )
    private MFAType mfaType;

    @Schema(
            title = "mfaKey",
            description = "mfaKey"
    )
    private String mfaKey;
}
