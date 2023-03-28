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

// ---Auto Generated by Project Qing ---
package cn.chenyunlong.qing.domain.activity.request;

import cn.chenyunlong.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class ActivityCreateRequest implements Request {
    @Schema(
            title = "activityId"
    )
    private String activityId;

    @Schema(
            title = "username"
    )
    private String username;

    @Schema(
            title = "activityName"
    )
    private String activityName;

    @Schema(
            title = "activityContent"
    )
    private String activityContent;

    @Schema(
            title = "attachmentAddress"
    )
    private String attachmentAddress;

    @Schema(
            title = "attachmentType"
    )
    private Integer attachmentType;

    @Schema(
            title = "publishState"
    )
    private Integer publishState;
}
