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
            title = "jobId",
            description = "jobId"
    )
    private Long jobId;

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
            title = "cronExpression",
            description = "cronExpression"
    )
    private String cronExpression;

    @Schema(
            title = "misfirePolicy",
            description = "misfirePolicy"
    )
    private String misfirePolicy;

    @Schema(
            title = "concurrent",
            description = "concurrent"
    )
    private String concurrent;

    @Schema(
            title = "status",
            description = "status"
    )
    private String status;

    private Long id;

    public void updateSysJob(SysJob param) {
        Optional.ofNullable(getJobId()).ifPresent(param::setJobId);
        Optional.ofNullable(getJobName()).ifPresent(param::setJobName);
        Optional.ofNullable(getJobGroup()).ifPresent(param::setJobGroup);
        Optional.ofNullable(getInvokeTarget()).ifPresent(param::setInvokeTarget);
        Optional.ofNullable(getCronExpression()).ifPresent(param::setCronExpression);
        Optional.ofNullable(getMisfirePolicy()).ifPresent(param::setMisfirePolicy);
        Optional.ofNullable(getConcurrent()).ifPresent(param::setConcurrent);
        Optional.ofNullable(getStatus()).ifPresent(param::setStatus);
    }
}
