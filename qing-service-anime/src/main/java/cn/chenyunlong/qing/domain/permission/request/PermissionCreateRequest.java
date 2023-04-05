// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.permission.request;

import cn.chenyunlong.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import java.lang.String;
import lombok.Data;

@Schema
@Data
public class PermissionCreateRequest implements Request {
    @Schema(
            title = "Name",
            description = "name"
    )
    private String name;

    @Schema(
            title = "Description",
            description = "description"
    )
    private String description;
}
