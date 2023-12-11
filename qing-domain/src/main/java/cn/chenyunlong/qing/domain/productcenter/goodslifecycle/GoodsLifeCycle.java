package cn.chenyunlong.qing.domain.productcenter.goodslifecycle;

import cn.chenyunlong.codegen.annotation.*;
import cn.chenyunlong.common.annotation.FieldDesc;
import cn.chenyunlong.common.constants.ValidStatus;
import cn.chenyunlong.jpa.support.BaseJpaAggregate;
import cn.chenyunlong.jpa.support.converter.ValidStatusConverter;
import cn.chenyunlong.qing.domain.productcenter.inoutrecord.convert.DirectionTypeConverter;
import cn.chenyunlong.qing.domain.productcenter.inoutrecord.convert.InOutStoreTypeConverter;
import cn.chenyunlong.qing.domain.productcenter.inoutrecord.enums.DirectionType;
import cn.chenyunlong.qing.domain.productcenter.inoutrecord.enums.InOutStoreType;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@GenVo
@GenCreator
@GenUpdater
@GenQuery
@GenCreateRequest
@GenUpdateRequest
@GenQueryRequest
@GenResponse
@GenRepository
@GenService
@GenServiceImpl
@GenFeign(serverName = "stanic")
@GenController
@GenMapper
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "goods_life_cycle")
@Data
public class GoodsLifeCycle extends BaseJpaAggregate {

    @FieldDesc(name = "出入库方向")
    @Convert(converter = DirectionTypeConverter.class)
    private DirectionType directionType;

    @FieldDesc(name = "唯一编码")
    private String uniqueCode;

    @FieldDesc(name = "出入库类型")
    @Convert(converter = InOutStoreTypeConverter.class)
    private InOutStoreType inOutStoreType;

    @FieldDesc(name = "仓库ID")
    private Long storeId;

    @FieldDesc(name = "备注")
    private String remark;

    @Convert(converter = ValidStatusConverter.class)
    @IgnoreUpdater
    @IgnoreCreator
    private ValidStatus validStatus;

    public void init() {
        setValidStatus(ValidStatus.VALID);
    }

    public void valid() {
        setValidStatus(ValidStatus.VALID);
    }

    public void invalid() {
        setValidStatus(ValidStatus.INVALID);
    }
}
