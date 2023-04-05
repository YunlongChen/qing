/*
 * Copyright (c) 2023  YunLong Chen
 * Project Qing is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *          http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 *
 */

// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.system.config.vo;

import cn.chenyunlong.common.model.AbstractBaseJpaVO;
import cn.chenyunlong.qing.domain.system.config.SysConfig;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.Long;
import java.lang.String;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Schema
@Data
@EqualsAndHashCode(
        callSuper = true
)
@NoArgsConstructor(
        access = AccessLevel.PROTECTED
)
public class SysConfigVO extends AbstractBaseJpaVO {
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

    public SysConfigVO(SysConfig source) {
        super();
        this.setConfigId(source.getConfigId());
        this.setConfigName(source.getConfigName());
        this.setConfigKey(source.getConfigKey());
        this.setConfigValue(source.getConfigValue());
        this.setConfigType(source.getConfigType());
        this.setParams(source.getParams());
    }
}
