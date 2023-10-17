// ---Auto Generated by Qing-Generator --

package cn.chenyunlong.qing.domain.district.request;

import cn.chenyunlong.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class DistrictUpdateRequest implements Request {
    @Schema(
        title = "code",
        description = "地区"
    )
    private String code;

    @Schema(
        title = "name",
        description = "名称"
    )
    private String name;

    private Long id;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
