/*
 * Copyright (c) 2019-2022 YunLong Chen
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

package cn.chenyunlong.qing.model.entities.sys;

import cn.chenyunlong.qing.annotation.Excel;
import cn.chenyunlong.qing.core.constant.ScheduleConstants;
import cn.chenyunlong.qing.core.domain.BaseEntity;
import cn.chenyunlong.qing.utils.StringUtils;
import cn.chenyunlong.qing.utils.quartz.CronUtils;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 定时任务调度表 sys_job
 *
 * @author stan
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_job")
public class SysJob extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 任务ID
     */
    @TableId
    @Excel(name = "任务序号", cellType = Excel.ColumnType.NUMERIC)
    private Long jobId;

    /**
     * 任务名称
     */
    @NotBlank(message = "任务名称不能为空")
    @Size(max = 64, message = "任务名称不能超过64个字符")
    @Excel(name = "任务名称")
    private String jobName;

    /**
     * 任务组名
     */
    @Excel(name = "任务组名")
    private String jobGroup;

    /**
     * 调用目标字符串
     */
    @NotBlank(message = "调用目标字符串不能为空")
    @Size(max = 1000, message = "调用目标字符串长度不能超过500个字符")
    @Excel(name = "调用目标字符串")
    private String invokeTarget;

    /**
     * cron执行表达式
     */
    @NotBlank(message = "Cron执行表达式不能为空")
    @Size(max = 255, message = "Cron执行表达式不能超过255个字符")
    @Excel(name = "执行表达式 ")
    private String cronExpression;

    /**
     * cron计划策略
     */
    @Excel(name = "计划策略 ", readConverterExp = "0=默认,1=立即触发执行,2=触发一次执行,3=不触发立即执行")
    private String misfirePolicy = ScheduleConstants.MISFIRE_DEFAULT;

    /**
     * 是否并发执行（0允许 1禁止）
     */
    @Excel(name = "并发执行", readConverterExp = "0=允许,1=禁止")
    private String concurrent;

    /**
     * 任务状态（0正常 1暂停）
     */
    @Excel(name = "任务状态", readConverterExp = "0=正常,1=暂停")
    private String status;

    @SuppressWarnings("unused")
    public Date getNextValidTime() {
        if (StringUtils.isNotEmpty(cronExpression)) {
            return CronUtils.getNextExecution(cronExpression);
        }
        return null;
    }

}
