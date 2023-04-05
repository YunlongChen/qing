// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.system.job.log.request;

import cn.chenyunlong.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.Long;
import java.lang.String;
import java.util.Date;

import lombok.Data;

@Schema
@Data
public class SysJobLogCreateRequest implements Request {
    @Schema(
            title = "jobLogId",
            description = "jobLogId"
    )
    private Long jobLogId;

    @Schema(
            title = "jobName",
            description = "jobName"
    )
    private String jobName;

    @Schema(
            title = "jobGroup",
            description = "jobGroup"
    )
    private String jobGroup;

    @Schema(
            title = "invokeTarget",
            description = "invokeTarget"
    )
    private String invokeTarget;

    @Schema(
            title = "jobMessage",
            description = "jobMessage"
    )
    private String jobMessage;

    @Schema(
            title = "status",
            description = "status"
    )
    private String status;

    @Schema(
            title = "exceptionInfo",
            description = "exceptionInfo"
    )
    private String exceptionInfo;

    @Schema(
            title = "startTime",
            description = "startTime"
    )
    private Date startTime;

    @Schema(
            title = "endTime",
            description = "endTime"
    )
    private Date endTime;
}
