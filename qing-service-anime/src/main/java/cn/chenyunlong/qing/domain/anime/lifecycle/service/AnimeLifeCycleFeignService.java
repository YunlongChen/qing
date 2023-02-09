// ---Auto Generated by Project Qing ---
package cn.chenyunlong.qing.domain.anime.lifecycle.service;

import cn.chenyunlong.common.model.JsonObject;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.anime.lifecycle.request.AnimeLifeCycleCreateRequest;
import cn.chenyunlong.qing.domain.anime.lifecycle.request.AnimeLifeCycleQueryRequest;
import cn.chenyunlong.qing.domain.anime.lifecycle.request.AnimeLifeCycleUpdateRequest;
import cn.chenyunlong.qing.domain.anime.lifecycle.response.AnimeLifeCycleResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "xxxSrv",
        contextId = "animeLifeCycleClient",
        path = "animeLifeCycle/v1"
)
public interface AnimeLifeCycleFeignService {
    /**
     * createRequest
     */
    @PostMapping("createAnimeLifeCycle")
    JsonObject<Long> createAnimeLifeCycle(@RequestBody AnimeLifeCycleCreateRequest request);

    /**
     * update request
     */
    @PostMapping("updateAnimeLifeCycle")
    JsonObject<String> updateAnimeLifeCycle(@RequestBody AnimeLifeCycleUpdateRequest request);

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    JsonObject<String> validAnimeLifeCycle(@PathVariable("id") Long id);

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    JsonObject<String> invalidAnimeLifeCycle(@PathVariable("id") Long id);

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    JsonObject<AnimeLifeCycleResponse> findById(@PathVariable("id") Long id);

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    JsonObject<PageResult<AnimeLifeCycleResponse>> findByPage(
            @RequestBody PageRequestWrapper<AnimeLifeCycleQueryRequest> request);
}
