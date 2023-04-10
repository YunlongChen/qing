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
package cn.chenyunlong.qing.domain.file.response;

import cn.chenyunlong.common.model.AbstractJpaResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Schema
@Data
@EqualsAndHashCode(
        callSuper = true
)
public class UploadFileResponse extends AbstractJpaResponse {
  @Schema(
          title = "fileId",
          description = "fileId"
  )
  private Long fileId;

  @Schema(
          title = "fileName",
          description = "fileName"
  )
  private String fileName;

  @Schema(
          title = "mimeType",
          description = "mimeType"
  )
  private String mimeType;

  @Schema(
          title = "url",
          description = "url"
  )
  private String url;

  @Schema(
          title = "fileSize",
          description = "fileSize"
  )
  private Long fileSize;
}
