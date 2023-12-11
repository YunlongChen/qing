package cn.chenyunlong.qing.domain.productcenter.goods.dto.request;

import cn.chenyunlong.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Schema
@Data
public class GoodsUpdateRequest implements Request {
    @Schema(
            title = "name",
            description = "name"
    )
    private String name;

    @Schema(
            title = "skuId",
            description = "规格ID"
    )
    private Long skuId;

    @Schema(
            title = "uniqueCode",
            description = "唯一编码"
    )
    private String uniqueCode;

    @Schema(
            title = "price",
            description = "价格"
    )
    private BigDecimal price;

    @Schema(
            title = "batchNo",
            description = "批次号"
    )
    private String batchNo;

    @Schema(
            title = "storeId",
            description = "仓库ID"
    )
    private Long storeId;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
