// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.tag.service;

import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.qing.domain.anime.tag.creator.AnimeTagCreator;
import cn.chenyunlong.qing.domain.anime.tag.query.AnimeTagQuery;
import cn.chenyunlong.qing.domain.anime.tag.updater.AnimeTagUpdater;
import cn.chenyunlong.qing.domain.anime.tag.vo.AnimeTagVO;

import java.lang.Long;

import org.springframework.data.domain.Page;

public interface IAnimeTagService {
    /**
     * create
     */
    Long createAnimeTag(AnimeTagCreator creator);

    /**
     * update
     */
    void updateAnimeTag(AnimeTagUpdater updater);

    /**
     * valid
     */
    void validAnimeTag(Long id);

    /**
     * invalid
     */
    void invalidAnimeTag(Long id);

    /**
     * findById
     */
    AnimeTagVO findById(Long id);

    /**
     * findByPage
     */
    Page<AnimeTagVO> findByPage(PageRequestWrapper<AnimeTagQuery> query);
}
