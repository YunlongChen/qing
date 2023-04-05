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
package cn.chenyunlong.qing.domain.activity.updater;

import cn.chenyunlong.qing.domain.activity.Activity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Optional;

@Schema
@Data
public class ActivityUpdater {
    @Schema(
            title = "ActivityId"
    )
    private String activityId;

    @Schema(
            title = "Username",
            description = "username"
    )
    private String username;

    @Schema(
            title = "ActivityName",
            description = "activityName"
    )
    private String activityName;

    @Schema(
            title = "ActivityContent",
            description = "activityContent"
    )
    private String activityContent;

    @Schema(
            title = "AttachmentAddress",
            description = "attachmentAddress"
    )
    private String attachmentAddress;

    @Schema(
            title = "AttachmentType",
            description = "attachmentType"
    )
    private Integer attachmentType;

    @Schema(
            title = "PublishState",
            description = "publishState"
    )
    private Integer publishState;

    private Long id;

    public void updateActivity(Activity param) {
        Optional.ofNullable(getActivityId()).ifPresent(v -> param.setActivityId(v));
        Optional.ofNullable(getUsername()).ifPresent(v -> param.setUsername(v));
        Optional.ofNullable(getActivityName()).ifPresent(v -> param.setActivityName(v));
        Optional.ofNullable(getActivityContent()).ifPresent(v -> param.setActivityContent(v));
        Optional.ofNullable(getAttachmentAddress()).ifPresent(v -> param.setAttachmentAddress(v));
        Optional.ofNullable(getAttachmentType()).ifPresent(v -> param.setAttachmentType(v));
        Optional.ofNullable(getPublishState()).ifPresent(v -> param.setPublishState(v));
    }
}
