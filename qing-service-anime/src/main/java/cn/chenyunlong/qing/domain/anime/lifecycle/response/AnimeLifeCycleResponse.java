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
package cn.chenyunlong.qing.domain.anime.lifecycle.response;

import cn.chenyunlong.common.model.AbstractJpaResponse;
import cn.chenyunlong.qing.domain.anime.anime.domainservice.model.meta.InOutBizType;
import cn.chenyunlong.qing.domain.anime.anime.domainservice.model.meta.InOutType;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public class AnimeLifeCycleResponse extends AbstractJpaResponse {
    @Schema(
            title = "Name",
            description = "资产名称"
    )
    private String name;

    @Schema(
            title = "AssetsId",
            description = "资产Id"
    )
    private Long assetsId;

    @Schema(
            title = "SkuId",
            description = "skuId"
    )
    private Long skuId;

    @Schema(
            title = "UniqueCode",
            description = "唯一编码"
    )
    private String uniqueCode;

    @Schema(
            title = "HouseName",
            description = "仓库名称"
    )
    private String houseName;

    @Schema(
            title = "HouseId",
            description = "仓库id"
    )
    private Long houseId;

    @Schema(
            title = "InOutBizType",
            description = "出入库业务类型"
    )
    private InOutBizType inOutBizType;

    @Schema(
            title = "InOutType",
            description = "出入类型"
    )
    private InOutType inOutType;

    @Schema(
            title = "OperateUser",
            description = "操作人"
    )
    private String operateUser;

    @Schema(
            title = "GenBatchNo",
            description = "唯一批次号"
    )
    private String genBatchNo;

    @Schema(
            title = "BatchNo",
            description = "批次号"
    )
    private String batchNo;
}
