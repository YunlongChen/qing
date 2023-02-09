package cn.chenyunlong.qing.domain.anime.anime.domainservice;


import cn.chenyunlong.common.constants.BaseEnum;

import java.util.Optional;

public enum InOutType implements BaseEnum {

    IN(1, "入库"),
    OUT(2, "出库");

    private Integer code;
    private String name;
    InOutType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static Optional<InOutType> of(Integer code) {
        return Optional.ofNullable(BaseEnum.parseByCode(InOutType.class, code));
    }

    @Override
    public Integer getValue() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }

}
