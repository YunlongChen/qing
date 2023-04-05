// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.lifecycle.vo;

import cn.chenyunlong.common.model.AbstractBaseJpaVO;
import cn.chenyunlong.qing.domain.anime.anime.domainservice.model.meta.InOutBizType;
import cn.chenyunlong.qing.domain.anime.anime.domainservice.model.meta.InOutType;
import cn.chenyunlong.qing.domain.anime.lifecycle.AnimeLifeCycle;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class AnimeLifeCycleVO extends AbstractBaseJpaVO {
    @Schema(
            title = "Name",
            description = "资产名称"
    )
    private String name;

    @Schema(
            title = "AssetsId",
            description = "资产Id"
    )
    private Long assetsId;

    @Schema(
            title = "SkuId",
            description = "skuId"
    )
    private Long skuId;

    @Schema(
            title = "UniqueCode",
            description = "唯一编码"
    )
    private String uniqueCode;

    @Schema(
            title = "HouseName",
            description = "仓库名称"
    )
    private String houseName;

    @Schema(
            title = "HouseId",
            description = "仓库id"
    )
    private Long houseId;

    @Schema(
            title = "InOutBizType",
            description = "出入库业务类型"
    )
    private InOutBizType inOutBizType;

    @Schema(
            title = "InOutType",
            description = "出入类型"
    )
    private InOutType inOutType;

    @Schema(
            title = "OperateUser",
            description = "操作人"
    )
    private String operateUser;

    @Schema(
            title = "GenBatchNo",
            description = "唯一批次号"
    )
    private String genBatchNo;

    @Schema(
            title = "BatchNo",
            description = "批次号"
    )
    private String batchNo;

    protected AnimeLifeCycleVO() {
    }

    public AnimeLifeCycleVO(AnimeLifeCycle source) {
        super();
        this.setName(source.getName());
        this.setAssetsId(source.getAssetsId());
        this.setSkuId(source.getSkuId());
        this.setUniqueCode(source.getUniqueCode());
        this.setHouseName(source.getHouseName());
        this.setHouseId(source.getHouseId());
        this.setInOutBizType(source.getInOutBizType());
        this.setInOutType(source.getInOutType());
        this.setOperateUser(source.getOperateUser());
        this.setGenBatchNo(source.getGenBatchNo());
        this.setBatchNo(source.getBatchNo());
    }
}
