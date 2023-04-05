// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.district.request;

import cn.chenyunlong.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class DistrictUpdateRequest implements Request {
    @Schema(
            title = "Name",
            description = "name"
    )
    private String name;

    @Schema(
            title = "Code",
            description = "code"
    )
    private String code;

    @Schema(
            title = "Description",
            description = "description"
    )
    private String description;

    private Long id;
}
