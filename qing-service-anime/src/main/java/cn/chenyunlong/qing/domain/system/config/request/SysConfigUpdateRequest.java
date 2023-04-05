// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.system.config.request;

import cn.chenyunlong.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class SysConfigUpdateRequest implements Request {
    @Schema(
            title = "ConfigId",
            description = "configId"
    )
    private Long configId;

    @Schema(
            title = "ConfigName",
            description = "configName"
    )
    private String configName;

    @Schema(
            title = "ConfigKey",
            description = "configKey"
    )
    private String configKey;

    @Schema(
            title = "ConfigValue",
            description = "configValue"
    )
    private String configValue;

    @Schema(
            title = "ConfigType",
            description = "configType"
    )
    private String configType;

    @Schema(
            title = "Params",
            description = "params"
    )
    private String params;

    private Long id;
}
