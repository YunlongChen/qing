// ---Auto Generated by Project Qing ---
package cn.chenyunlong.qing.domain.system.version.request;

import cn.chenyunlong.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class VersionUpdateRequest implements Request {
    @Schema(
            title = "code"
    )
    private String code;

    @Schema(
            title = "name"
    )
    private String name;

    @Schema(
            title = "description"
    )
    private String description;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
