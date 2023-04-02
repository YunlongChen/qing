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
package cn.chenyunlong.qing.domain.system.job.job.response;

import cn.chenyunlong.common.model.AbstractJpaResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema
@Data
@EqualsAndHashCode(callSuper = false)
public class SysJobResponse extends AbstractJpaResponse {
    @Schema(
            title = "JobId",
            description = "jobId"
    )
    private Long jobId;

    @Schema(
            title = "JobName",
            description = "jobName"
    )
    private String jobName;

    @Schema(
            title = "JobGroup",
            description = "jobGroup"
    )
    private String jobGroup;

    @Schema(
            title = "InvokeTarget",
            description = "invokeTarget"
    )
    private String invokeTarget;

    @Schema(
            title = "CronExpression",
            description = "cronExpression"
    )
    private String cronExpression;

    @Schema(
            title = "MisfirePolicy",
            description = "misfirePolicy"
    )
    private String misfirePolicy;

    @Schema(
            title = "Concurrent",
            description = "concurrent"
    )
    private String concurrent;

    @Schema(
            title = "Status",
            description = "status"
    )
    private String status;
}
