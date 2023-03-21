// ---Auto Generated by Project Qing ---
package cn.chenyunlong.qing.domain.user.user.request;

import cn.chenyunlong.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema
public class ChangePasswordRequest implements Request {

    @NotBlank
    @Schema(title = "username")
    private String username;

    /**
     * md5加密之后的密码
     */
    @NotBlank
    @Schema(title = "password")
    private String password;

}
