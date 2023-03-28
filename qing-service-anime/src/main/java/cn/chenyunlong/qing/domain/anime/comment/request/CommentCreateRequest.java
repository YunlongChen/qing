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
package cn.chenyunlong.qing.domain.anime.comment.request;

import cn.chenyunlong.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class CommentCreateRequest implements Request {
    @Schema(
            title = "cid"
    )
    private Long cid;

    @Schema(
            title = "username"
    )
    private String username;

    @Schema(
            title = "content"
    )
    private String content;

    @Schema(
            title = "ipAddress"
    )
    private String ipAddress;
}
