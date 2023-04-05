// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.anime.service;

import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.qing.domain.anime.anime.creator.AnimeInfoCreator;
import cn.chenyunlong.qing.domain.anime.anime.query.AnimeInfoQuery;
import cn.chenyunlong.qing.domain.anime.anime.updater.AnimeInfoUpdater;
import cn.chenyunlong.qing.domain.anime.anime.vo.AnimeInfoVO;
import org.springframework.data.domain.Page;

public interface IAnimeInfoService {
  /**
   * create
   */
  Long createAnimeInfo(AnimeInfoCreator creator);

  /**
   * update
   */
  void updateAnimeInfo(AnimeInfoUpdater updater);

  /**
   * valid
   */
  void validAnimeInfo(Long id);

  /**
   * invalid
   */
  void invalidAnimeInfo(Long id);

  /**
   * findById
   */
  AnimeInfoVO findById(Long id);

  /**
   * findByPage
   */
  Page<AnimeInfoVO> findByPage(PageRequestWrapper<AnimeInfoQuery> query);
}
