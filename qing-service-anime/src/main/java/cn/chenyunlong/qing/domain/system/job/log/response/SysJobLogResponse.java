// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.system.job.log.response;

import cn.chenyunlong.common.model.AbstractJpaResponse;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema
public class SysJobLogResponse extends AbstractJpaResponse {
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
}
