// ---Auto Generated by Qing-Generator --

package cn.chenyunlong.qing.samples.codegen.domain.creator;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class TestDomainCreator {
    @Schema(
        title = "username",
        description = "username"
    )
    private String username;

    @Schema(
        title = "password",
        description = "password"
    )
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
