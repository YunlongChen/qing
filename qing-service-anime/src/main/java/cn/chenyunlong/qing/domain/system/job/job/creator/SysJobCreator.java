// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.system.job.job.creator;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class SysJobCreator {
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
