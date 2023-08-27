// ---Auto Generated by Qing-Generator --
package cn.chenyunlong.qing.domain.episode.service;

import cn.chenyunlong.common.model.JsonResult;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.common.model.PageResult;
import cn.chenyunlong.qing.domain.episode.request.EpisodeCreateRequest;
import cn.chenyunlong.qing.domain.episode.request.EpisodeQueryRequest;
import cn.chenyunlong.qing.domain.episode.request.EpisodeUpdateRequest;
import cn.chenyunlong.qing.domain.episode.response.EpisodeResponse;
import java.lang.Long;
import java.lang.String;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "stanic",
        contextId = "episodeClient",
        path = "episode/v1"
)
public interface EpisodeFeignService {
    /**
     * createRequest
     */
    @PostMapping("createEpisode")
    JsonResult<Long> createEpisode(@RequestBody EpisodeCreateRequest request);

    /**
     * update request
     */
    @PostMapping("updateEpisode")
    JsonResult<String> updateEpisode(@RequestBody EpisodeUpdateRequest request);

    /**
     * valid
     */
    @PostMapping("valid/{id}")
    JsonResult<String> validEpisode(@PathVariable("id") Long id);

    /**
     * invalid
     */
    @PostMapping("invalid/{id}")
    JsonResult<String> invalidEpisode(@PathVariable("id") Long id);

    /**
     * findById
     */
    @GetMapping("findById/{id}")
    JsonResult<EpisodeResponse> findById(@PathVariable("id") Long id);

    /**
     * findByPage request
     */
    @PostMapping("findByPage")
    JsonResult<PageResult<EpisodeResponse>> findByPage(
            @RequestBody PageRequestWrapper<EpisodeQueryRequest> request);
}
