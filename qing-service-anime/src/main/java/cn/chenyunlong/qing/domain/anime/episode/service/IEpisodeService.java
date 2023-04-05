// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.episode.service;

import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.qing.domain.anime.episode.creator.EpisodeCreator;
import cn.chenyunlong.qing.domain.anime.episode.query.EpisodeQuery;
import cn.chenyunlong.qing.domain.anime.episode.updater.EpisodeUpdater;
import cn.chenyunlong.qing.domain.anime.episode.vo.EpisodeVO;
import org.springframework.data.domain.Page;

public interface IEpisodeService {
    /**
     * create
     */
    Long createEpisode(EpisodeCreator creator);

    /**
     * update
     */
    void updateEpisode(EpisodeUpdater updater);

    /**
     * valid
     */
    void validEpisode(Long id);

    /**
     * invalid
     */
    void invalidEpisode(Long id);

    /**
     * findById
     */
    EpisodeVO findById(Long id);

    /**
     * findByPage
     */
    Page<EpisodeVO> findByPage(PageRequestWrapper<EpisodeQuery> query);
}
