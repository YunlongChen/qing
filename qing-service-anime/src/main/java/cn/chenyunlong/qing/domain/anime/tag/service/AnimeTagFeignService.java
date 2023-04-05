// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.tag.service;

import cn.chenyunlong.common.model.JsonResult;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.anime.tag.request.AnimeTagCreateRequest;
import cn.chenyunlong.qing.domain.anime.tag.request.AnimeTagQueryRequest;
import cn.chenyunlong.qing.domain.anime.tag.request.AnimeTagUpdateRequest;
import cn.chenyunlong.qing.domain.anime.tag.response.AnimeTagResponse;

import java.lang.Long;
import java.lang.String;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "xxxSrv",
        contextId = "animeTagClient",
        path = "animeTag/v1"
)
public interface AnimeTagFeignService {
    /**
     * createRequest
     */
    @PostMapping("createAnimeTag")
    JsonResult<Long> createAnimeTag(@RequestBody AnimeTagCreateRequest request);

    /**
     * update request
     */
    @PostMapping("updateAnimeTag")
    JsonResult<String> updateAnimeTag(@RequestBody AnimeTagUpdateRequest request);

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    JsonResult<String> validAnimeTag(@PathVariable("id") Long id);

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    JsonResult<String> invalidAnimeTag(@PathVariable("id") Long id);

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    JsonResult<AnimeTagResponse> findById(@PathVariable("id") Long id);

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    JsonResult<PageResult<AnimeTagResponse>> findByPage(
            @RequestBody PageRequestWrapper<AnimeTagQueryRequest> request);
}
