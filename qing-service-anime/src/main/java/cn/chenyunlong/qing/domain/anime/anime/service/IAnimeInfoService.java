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
