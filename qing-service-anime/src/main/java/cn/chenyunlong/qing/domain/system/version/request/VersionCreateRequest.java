// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.system.version.request;

import cn.chenyunlong.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.String;

import lombok.Data;

@Schema
@Data
public class VersionCreateRequest implements Request {
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
