// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.tag.controller;

import cn.chenyunlong.common.constants.CodeEnum;
import cn.chenyunlong.common.model.JsonResult;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.anime.tag.creator.AnimeTagCreator;
import cn.chenyunlong.qing.domain.anime.tag.mapper.AnimeTagMapper;
import cn.chenyunlong.qing.domain.anime.tag.query.AnimeTagQuery;
import cn.chenyunlong.qing.domain.anime.tag.request.AnimeTagCreateRequest;
import cn.chenyunlong.qing.domain.anime.tag.request.AnimeTagQueryRequest;
import cn.chenyunlong.qing.domain.anime.tag.request.AnimeTagUpdateRequest;
import cn.chenyunlong.qing.domain.anime.tag.response.AnimeTagResponse;
import cn.chenyunlong.qing.domain.anime.tag.service.IAnimeTagService;
import cn.chenyunlong.qing.domain.anime.tag.updater.AnimeTagUpdater;
import cn.chenyunlong.qing.domain.anime.tag.vo.AnimeTagVO;

import java.lang.Long;
import java.lang.String;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("animeTag/v1")
@RequiredArgsConstructor
public class AnimeTagController {
    private final IAnimeTagService animeTagService;

    /**
     * createRequest
     */
    @PostMapping
    public JsonResult<Long> createAnimeTag(@RequestBody AnimeTagCreateRequest request) {
        AnimeTagCreator creator = AnimeTagMapper.INSTANCE.request2Dto(request);
        return JsonResult.success(animeTagService.createAnimeTag(creator));
    }

    /**
     * update request
     */
    @PostMapping("updateAnimeTag")
    public JsonResult<String> updateAnimeTag(@RequestBody AnimeTagUpdateRequest request) {
        AnimeTagUpdater updater = AnimeTagMapper.INSTANCE.request2Updater(request);
        animeTagService.updateAnimeTag(updater);
        return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    public JsonResult<String> validAnimeTag(@PathVariable Long id) {
        animeTagService.validAnimeTag(id);
        return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    public JsonResult<String> invalidAnimeTag(@PathVariable Long id) {
        animeTagService.invalidAnimeTag(id);
        return JsonResult.success(CodeEnum.Success.getName());
    }

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    public JsonResult<AnimeTagResponse> findById(@PathVariable Long id) {
        AnimeTagVO vo = animeTagService.findById(id);
        AnimeTagResponse response = AnimeTagMapper.INSTANCE.vo2CustomResponse(vo);
        return JsonResult.success(response);
    }

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    public JsonResult<PageResult<AnimeTagResponse>> findByPage(
            @RequestBody PageRequestWrapper<AnimeTagQueryRequest> request) {
        PageRequestWrapper<AnimeTagQuery> wrapper = new PageRequestWrapper<>();
        wrapper.setBean(AnimeTagMapper.INSTANCE.request2Query(request.getBean()));
        wrapper.setSorts(request.getSorts());
        wrapper.setPageSize(request.getPageSize());
        wrapper.setPage(request.getPage());
        Page<AnimeTagVO> page = animeTagService.findByPage(wrapper);
        return JsonResult.success(
                PageResult.of(
                        page.getContent().stream()
                                .map(AnimeTagMapper.INSTANCE::vo2CustomResponse)
                                .collect(Collectors.toList()),
                        page.getTotalElements(),
                        page.getSize(),
                        page.getNumber())
        );
    }
}
