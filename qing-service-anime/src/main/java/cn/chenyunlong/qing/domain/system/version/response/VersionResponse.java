// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.system.version.response;

import cn.chenyunlong.common.model.AbstractJpaResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import java.lang.String;

import lombok.Data;

@Schema
@Data
public class VersionResponse extends AbstractJpaResponse {
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
}
