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

package cn.chenyunlong.qing.domain.anime.anime.domainservice.model.biz;

import cn.chenyunlong.qing.domain.anime.anime.domainservice.model.meta.InOutBizType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 批量出入库模型
 */
@Data
public class BatchInOutModel {

    private String name;

    @Schema(name = "出入库类型")
    private InOutBizType inOutBizType;

    @Schema(name = "操作用户")
    private String operateUser;

    @Schema(name = "仓库Id")
    private Long houseId;

    @Schema(name = "动漫唯一编码")
    private List<Long> animeIds;

    @Schema(name = "批次号")
    private String batchNo;

    @Schema(name = "skuId")
    private Long skuId;
}
