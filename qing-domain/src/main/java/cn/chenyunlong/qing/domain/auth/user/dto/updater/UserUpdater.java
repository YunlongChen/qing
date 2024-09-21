package cn.chenyunlong.qing.domain.auth.user.dto.updater;

import cn.chenyunlong.common.enums.MFAType;
import cn.chenyunlong.qing.domain.auth.user.QingUser;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Schema
@Data
public class UserUpdater {

    @Schema(
        title = "uid",
        description = "用户唯一ID"
    )
    private Long uid;

    @Schema(
        title = "username",
        description = "用户名"
    )
    private String username;

    @Schema(
        title = "nickname",
        description = "昵称"
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

    private Long id;

    public void updateUser(QingUser param, PasswordEncoder passwordEncoder) {
        Optional.ofNullable(getUsername()).ifPresent(param::setUsername);
        Optional.ofNullable(getNickname()).ifPresent(param::setNickname);
        Optional.ofNullable(getPassword()).ifPresent(newPassword -> {
            // 判断密码是否修改
            if (!passwordEncoder.matches(newPassword, param.getPassword())) {
                param.setPassword(passwordEncoder.encode(newPassword));
            }
        });
        Optional.ofNullable(getPhone()).ifPresent(param::setPhone);
        Optional.ofNullable(getEmail()).ifPresent(param::setEmail);
        Optional.ofNullable(getAvatar()).ifPresent(param::setAvatar);
        Optional.ofNullable(getDescription()).ifPresent(param::setDescription);
        Optional.ofNullable(getExpireTime()).ifPresent(param::setExpireTime);
        Optional.ofNullable(getMfaType()).ifPresent(param::setMfaType);
        Optional.ofNullable(getMfaKey()).ifPresent(param::setMfaKey);
    }

}
