package cn.chenyunlong.qing.domain.productcenter.store;

import cn.chenyunlong.codegen.annotation.GenController;
import cn.chenyunlong.codegen.annotation.GenCreateRequest;
import cn.chenyunlong.codegen.annotation.GenCreator;
import cn.chenyunlong.codegen.annotation.GenFeign;
import cn.chenyunlong.codegen.annotation.GenMapper;
import cn.chenyunlong.codegen.annotation.GenQuery;
import cn.chenyunlong.codegen.annotation.GenQueryRequest;
import cn.chenyunlong.codegen.annotation.GenRepository;
import cn.chenyunlong.codegen.annotation.GenResponse;
import cn.chenyunlong.codegen.annotation.GenService;
import cn.chenyunlong.codegen.annotation.GenServiceImpl;
import cn.chenyunlong.codegen.annotation.GenUpdateRequest;
import cn.chenyunlong.codegen.annotation.GenUpdater;
import cn.chenyunlong.codegen.annotation.GenVo;
import cn.chenyunlong.codegen.annotation.IgnoreCreator;
import cn.chenyunlong.codegen.annotation.IgnoreUpdater;
import cn.chenyunlong.common.annotation.FieldDesc;
import cn.chenyunlong.common.constants.ValidStatus;
import cn.chenyunlong.jpa.support.BaseJpaAggregate;
import cn.chenyunlong.jpa.support.converter.ValidStatusConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


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
@Table(name = "store")
public class Store extends BaseJpaAggregate {

    @FieldDesc(name = "仓库名称")
    private String name;

    @FieldDesc(name = "备注")
    private String description;

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
