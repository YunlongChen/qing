/*
 * Copyright (c) 2019-2023  YunLong Chen
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

package cn.chenyunlong.qing.domain.anime.comment;

import cn.chenyunlong.codegen.annotation.*;
import cn.chenyunlong.jpa.support.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;

/**
 * 用户评论信息
 *
 * @author Stan
 */
@GenBase(basePackage = "cn.chenyunlong.qing.domain.anime.comment")
@GenVo
@GenController
@GenCreator
@GenUpdater
@GenRepository
@GenService
@GenServiceImpl
@GenQuery
@GenCreateRequest
@GenUpdateRequest
@GenQueryRequest
@GenResponse
@GenFeign
@GenMapper
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "anime_comment")
public class Comment extends BaseEntity {
    private Long cid;
    private String username;
    private String content;
    private String ipAddress;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Comment comment = (Comment) o;
        return getId() != null && Objects.equals(getId(), comment.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
