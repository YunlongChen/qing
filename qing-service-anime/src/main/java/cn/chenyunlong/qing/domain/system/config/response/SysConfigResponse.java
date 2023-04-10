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
package cn.chenyunlong.qing.domain.system.config.response;

import cn.chenyunlong.common.model.AbstractJpaResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema
@Data
@EqualsAndHashCode(
        callSuper = true
)
public class SysConfigResponse extends AbstractJpaResponse {
    @Schema(
            title = "configId",
            description = "configId"
    )
    private Long configId;

    @Schema(
            title = "configName",
            description = "configName"
    )
    private String configName;

    @Schema(
            title = "configKey",
            description = "configKey"
    )
    private String configKey;

    @Schema(
            title = "configValue",
            description = "configValue"
    )
    private String configValue;

    @Schema(
            title = "configType",
            description = "configType"
    )
    private String configType;

    @Schema(
            title = "params",
            description = "params"
    )
    private String params;
}
