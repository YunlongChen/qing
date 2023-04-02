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
package cn.chenyunlong.qing.domain.system.job.log.request;

import cn.chenyunlong.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.Long;
import java.lang.String;
import java.util.Date;

@Schema
public class SysJobLogUpdateRequest implements Request {
    @Schema(
            title = "JobLogId",
            description = "jobLogId"
    )
    private Long jobLogId;

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
            title = "JobMessage",
            description = "jobMessage"
    )
    private String jobMessage;

    @Schema(
            title = "Status",
            description = "status"
    )
    private String status;

    @Schema(
            title = "ExceptionInfo",
            description = "exceptionInfo"
    )
    private String exceptionInfo;

    @Schema(
            title = "StartTime",
            description = "startTime"
    )
    private Date startTime;

    @Schema(
            title = "EndTime",
            description = "endTime"
    )
    private Date endTime;

    private Long id;
}
