package cn.chenyunlong.qing.domain.productcenter.product;

import cn.chenyunlong.codegen.annotation.*;
import cn.chenyunlong.common.annotation.FieldDesc;
import cn.chenyunlong.common.constants.ValidStatus;
import cn.chenyunlong.jpa.support.BaseJpaAggregate;
import cn.chenyunlong.jpa.support.converter.ValidStatusConverter;
import cn.chenyunlong.qing.infrustructure.converter.ProductTypeConverter;
import cn.chenyunlong.qing.infrustructure.converter.SerializeTypeConverter;
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
@Table(name = "product")
@Data
public class Product extends BaseJpaAggregate {

    @FieldDesc(name = "模板Id")
    private Long templateId;

    @FieldDesc(name = "品牌ID")
    private Long brandId;

    @FieldDesc(name = "编码")
    private String code;

    @FieldDesc(name = "名称")
    private String name;

    @FieldDesc(name = "分类ID")
    private Long categoryId;

    @FieldDesc(name = "描述")
    private String description;

    @FieldDesc(name = "产品类型")
    @Convert(converter = ProductTypeConverter.class)
    private ProductType type;

    @FieldDesc(name = "序列化类型")
    @Convert(converter = SerializeTypeConverter.class)
    private SerializeType serializeType;

    private Long pid;

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