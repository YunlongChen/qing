// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.user.user.request;

import cn.chenyunlong.common.model.Request;
import cn.chenyunlong.qing.infrastructure.enums.MFAType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.Long;
import java.lang.String;
import java.time.LocalDateTime;

import lombok.Data;

@Schema
@Data
public class UserCreateRequest implements Request {
    @Schema(
            title = "Uid",
            description = "uid"
    )
    private Long uid;

    @Schema(
            title = "Username",
            description = "username"
    )
    private String username;

    @Schema(
            title = "Nickname",
            description = "nickname"
    )
    private String nickname;

    @Schema(
            title = "Password",
            description = "password"
    )
    private String password;

    @Schema(
            title = "Phone",
            description = "phone"
    )
    private String phone;

    @Schema(
            title = "Email",
            description = "email"
    )
    private String email;

    @Schema(
            title = "Avatar",
            description = "avatar"
    )
    private String avatar;

    @Schema(
            title = "Description",
            description = "description"
    )
    private String description;

    @Schema(
            title = "ExpireTime",
            description = "expireTime"
    )
    private LocalDateTime expireTime;

    @Schema(
            title = "MfaType",
            description = "mfaType"
    )
    private MFAType mfaType;

    @Schema(
            title = "MfaKey",
            description = "mfaKey"
    )
    private String mfaKey;
}
