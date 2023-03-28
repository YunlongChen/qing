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
package cn.chenyunlong.qing.domain.anime.tag.service;

import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.qing.domain.anime.tag.creator.AnimeTagCreator;
import cn.chenyunlong.qing.domain.anime.tag.query.AnimeTagQuery;
import cn.chenyunlong.qing.domain.anime.tag.updater.AnimeTagUpdater;
import cn.chenyunlong.qing.domain.anime.tag.vo.AnimeTagVO;
import org.springframework.data.domain.Page;

import java.util.List;

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
     * findById
     */
    List<AnimeTagVO> listAll();

    /**
     * findByPage
     */
    Page<AnimeTagVO> findByPage(PageRequestWrapper<AnimeTagQuery> query);
}
