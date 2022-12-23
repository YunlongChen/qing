// ---Auto Generated by Project Qing ---
package cn.chenyunlong.qing.domain.system.job.log.response;

import cn.chenyunlong.common.model.AbstractJpaResponse;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema
public class SysJobLogResponse extends AbstractJpaResponse {
    @Schema(
            title = "jobLogId"
    )
    private Long jobLogId;

    @Schema(
            title = "jobName"
    )
    private String jobName;

    @Schema(
            title = "jobGroup"
    )
    private String jobGroup;

    @Schema(
            title = "invokeTarget"
    )
    private String invokeTarget;

    @Schema(
            title = "jobMessage"
    )
    private String jobMessage;

    @Schema(
            title = "status"
    )
    private String status;

    @Schema(
            title = "exceptionInfo"
    )
    private String exceptionInfo;

    @Schema(
            title = "startTime"
    )
    private Date startTime;

    @Schema(
            title = "endTime"
    )
    private Date endTime;

    public Long getJobLogId() {
        return jobLogId;
    }

    public void setJobLogId(Long jobLogId) {
        this.jobLogId = jobLogId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getInvokeTarget() {
        return invokeTarget;
    }

    public void setInvokeTarget(String invokeTarget) {
        this.invokeTarget = invokeTarget;
    }

    public String getJobMessage() {
        return jobMessage;
    }

    public void setJobMessage(String jobMessage) {
        this.jobMessage = jobMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
