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
package cn.chenyunlong.qing.domain.system.job.job.updater;

import cn.chenyunlong.qing.domain.system.job.job.SysJob;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.Long;
import java.lang.String;
import java.util.Optional;

import lombok.Data;

@Schema
@Data
public class SysJobUpdater {
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

    private Long id;

    public void updateSysJob(SysJob param) {
        Optional.ofNullable(getJobId()).ifPresent(v -> param.setJobId(v));
        Optional.ofNullable(getJobName()).ifPresent(v -> param.setJobName(v));
        Optional.ofNullable(getJobGroup()).ifPresent(v -> param.setJobGroup(v));
        Optional.ofNullable(getInvokeTarget()).ifPresent(v -> param.setInvokeTarget(v));
        Optional.ofNullable(getCronExpression()).ifPresent(v -> param.setCronExpression(v));
        Optional.ofNullable(getMisfirePolicy()).ifPresent(v -> param.setMisfirePolicy(v));
        Optional.ofNullable(getConcurrent()).ifPresent(v -> param.setConcurrent(v));
        Optional.ofNullable(getStatus()).ifPresent(v -> param.setStatus(v));
    }
}
