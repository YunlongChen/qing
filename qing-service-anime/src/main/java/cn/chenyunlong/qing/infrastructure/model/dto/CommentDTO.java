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

package cn.chenyunlong.qing.infrastructure.model.dto;

import cn.chenyunlong.qing.domain.anime.comment.Comment;
import cn.chenyunlong.qing.infrastructure.model.dto.base.OutputConverter;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Stan
 */
@Data
public class CommentDTO implements OutputConverter<CommentDTO, Comment> {
    private Long id;
    private String username;
    private String content;
    private LocalDateTime createTime;
    private Long mid;

}
