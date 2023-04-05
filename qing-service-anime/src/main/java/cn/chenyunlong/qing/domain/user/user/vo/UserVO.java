// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.user.user.vo;

import cn.chenyunlong.common.model.AbstractBaseJpaVO;
import cn.chenyunlong.qing.domain.user.user.User;
import cn.chenyunlong.qing.infrastructure.enums.MFAType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.Long;
import java.lang.String;
import java.time.LocalDateTime;

import lombok.Data;

@Schema
@Data
public class UserVO extends AbstractBaseJpaVO {
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

    protected UserVO() {
    }

    public UserVO(User source) {
        super();
        this.setUid(source.getUid());
        this.setUsername(source.getUsername());
        this.setNickname(source.getNickname());
        this.setPassword(source.getPassword());
        this.setPhone(source.getPhone());
        this.setEmail(source.getEmail());
        this.setAvatar(source.getAvatar());
        this.setDescription(source.getDescription());
        this.setExpireTime(source.getExpireTime());
        this.setMfaType(source.getMfaType());
        this.setMfaKey(source.getMfaKey());
    }
}
