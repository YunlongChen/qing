// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.system.version.response;

import cn.chenyunlong.common.model.AbstractJpaResponse;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.String;

@Schema
public class VersionResponse extends AbstractJpaResponse {
    @Schema(
            title = "Code",
            description = ""
    )
    private String code;

    @Schema(
            title = "Name",
            description = ""
    )
    private String name;

    @Schema(
            title = "Description",
            description = ""
    )
    private String description;
}
