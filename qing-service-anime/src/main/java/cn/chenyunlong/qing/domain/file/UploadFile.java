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

package cn.chenyunlong.qing.domain.file;

import cn.chenyunlong.codegen.annotation.*;
import cn.chenyunlong.common.annotation.FieldDesc;
import cn.chenyunlong.jpa.support.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Stan
 */
@Data
@EqualsAndHashCode(callSuper = false)
@GenVo
@GenCreator
@GenUpdater
@GenRepository
@GenService
@GenServiceImpl
@GenController(description = "创建服务")
@GenQuery
@GenCreateRequest
@GenUpdateRequest
@GenQueryRequest
@GenResponse
@GenFeign
@GenMapper
@GenBase(basePackage = "cn.chenyunlong.qing.domain.file")
@Entity
@Table(name = "upload_file")
public class UploadFile extends BaseEntity {

    private Long fileId;

    @FieldDesc(name = "文件名称")
    private String fileName;

    @FieldDesc(name = "文件类型", description = "文件描述信息")
    private String mimeType;

    @FieldDesc(name = "文件地址", description = "文件上传地址")
    private String url;

    @FieldDesc(name = "文件大小")
    private Long fileSize;

}
