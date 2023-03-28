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
package cn.chenyunlong.qing.domain.district.mapper;

import cn.chenyunlong.common.mapper.DateMapper;
import cn.chenyunlong.common.mapper.GenericEnumMapper;
import cn.chenyunlong.qing.domain.district.District;
import cn.chenyunlong.qing.domain.district.creator.DistrictCreator;
import cn.chenyunlong.qing.domain.district.query.DistrictQuery;
import cn.chenyunlong.qing.domain.district.request.DistrictCreateRequest;
import cn.chenyunlong.qing.domain.district.request.DistrictQueryRequest;
import cn.chenyunlong.qing.domain.district.request.DistrictUpdateRequest;
import cn.chenyunlong.qing.domain.district.response.DistrictResponse;
import cn.chenyunlong.qing.domain.district.updater.DistrictUpdater;
import cn.chenyunlong.qing.domain.district.vo.DistrictVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
        uses = {
                GenericEnumMapper.class,
                DateMapper.class
        }
)
public interface DistrictMapper {
    DistrictMapper INSTANCE = Mappers.getMapper(DistrictMapper.class);

    District dtoToEntity(DistrictCreator dto);

    DistrictUpdater request2Updater(DistrictUpdateRequest request);

    DistrictCreator request2Dto(DistrictCreateRequest request);

    DistrictQuery request2Query(DistrictQueryRequest request);

    DistrictResponse vo2Response(DistrictVO vo);

    default DistrictResponse vo2CustomResponse(DistrictVO vo) {
        DistrictResponse response = vo2Response(vo);
        return response;
    }
}
