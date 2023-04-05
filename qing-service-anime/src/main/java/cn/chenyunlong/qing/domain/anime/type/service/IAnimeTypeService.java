// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.type.service;

import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.qing.domain.anime.type.creator.AnimeTypeCreator;
import cn.chenyunlong.qing.domain.anime.type.query.AnimeTypeQuery;
import cn.chenyunlong.qing.domain.anime.type.updater.AnimeTypeUpdater;
import cn.chenyunlong.qing.domain.anime.type.vo.AnimeTypeVO;
import org.springframework.data.domain.Page;

public interface IAnimeTypeService {
    /**
     * create
     */
    Long createAnimeType(AnimeTypeCreator creator);

    /**
     * update
     */
    void updateAnimeType(AnimeTypeUpdater updater);

    /**
     * valid
     */
    void validAnimeType(Long id);

    /**
     * invalid
     */
    void invalidAnimeType(Long id);

    /**
     * findById
     */
    AnimeTypeVO findById(Long id);

    /**
     * findByPage
     */
    Page<AnimeTypeVO> findByPage(PageRequestWrapper<AnimeTypeQuery> query);
}
