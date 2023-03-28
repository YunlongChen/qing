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

// ---Auto Generated by Project Qing ---
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
