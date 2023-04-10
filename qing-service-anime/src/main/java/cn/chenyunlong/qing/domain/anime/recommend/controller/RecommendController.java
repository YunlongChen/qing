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
package cn.chenyunlong.qing.domain.anime.recommend.controller;

import cn.chenyunlong.common.constants.CodeEnum;
import cn.chenyunlong.common.model.JsonResult;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.anime.recommend.creator.RecommendCreator;
import cn.chenyunlong.qing.domain.anime.recommend.mapper.RecommendMapper;
import cn.chenyunlong.qing.domain.anime.recommend.query.RecommendQuery;
import cn.chenyunlong.qing.domain.anime.recommend.request.RecommendCreateRequest;
import cn.chenyunlong.qing.domain.anime.recommend.request.RecommendQueryRequest;
import cn.chenyunlong.qing.domain.anime.recommend.request.RecommendUpdateRequest;
import cn.chenyunlong.qing.domain.anime.recommend.response.RecommendResponse;
import cn.chenyunlong.qing.domain.anime.recommend.service.IRecommendService;
import cn.chenyunlong.qing.domain.anime.recommend.updater.RecommendUpdater;
import cn.chenyunlong.qing.domain.anime.recommend.vo.RecommendVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("api/v1/recommend")
@RequiredArgsConstructor
public class RecommendController {
    private final IRecommendService recommendService;

    /**
     * createRequest
     */
    @PostMapping
    public JsonResult<Long> createRecommend(@RequestBody RecommendCreateRequest request) {
        RecommendCreator creator = RecommendMapper.INSTANCE.request2Dto(request);
        return JsonResult.success(recommendService.createRecommend(creator));
    }

    /**
     * update request
     */
    @PostMapping("updateRecommend")
    public JsonResult<String> updateRecommend(@RequestBody RecommendUpdateRequest request) {
        RecommendUpdater updater = RecommendMapper.INSTANCE.request2Updater(request);
        recommendService.updateRecommend(updater);
        return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    public JsonResult<String> validRecommend(@PathVariable Long id) {
        recommendService.validRecommend(id);
        return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    public JsonResult<String> invalidRecommend(@PathVariable Long id) {
        recommendService.invalidRecommend(id);
        return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    public JsonResult<RecommendResponse> findById(@PathVariable Long id) {
        RecommendVO vo = recommendService.findById(id);
        RecommendResponse response = RecommendMapper.INSTANCE.vo2CustomResponse(vo);
        return JsonResult.success(response);
    }

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    public JsonResult<PageResult<RecommendResponse>> findByPage(
            @RequestBody PageRequestWrapper<RecommendQueryRequest> request) {
        PageRequestWrapper<RecommendQuery> wrapper = new PageRequestWrapper<>();
        wrapper.setBean(RecommendMapper.INSTANCE.request2Query(request.getBean()));
        wrapper.setSorts(request.getSorts());
        wrapper.setPageSize(request.getPageSize());
        wrapper.setPage(request.getPage());
        Page<RecommendVO> page = recommendService.findByPage(wrapper);
        return JsonResult.success(
                PageResult.of(
                        page.getContent().stream()
                                .map(RecommendMapper.INSTANCE::vo2CustomResponse)
                                .collect(Collectors.toList()),
                        page.getTotalElements(),
                        page.getSize(),
                        page.getNumber())
        );
    }
}
