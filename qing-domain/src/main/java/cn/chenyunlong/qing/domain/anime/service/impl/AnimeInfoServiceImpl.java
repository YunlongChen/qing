/*
 * Copyright (c) 2019-2023  YunLong Chen
 * Project Qing is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *          https://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 *
 */

// ---Auto Generated by Qing-Generator ---

package cn.chenyunlong.qing.domain.anime.service.impl;

import cn.chenyunlong.common.constants.CodeEnum;
import cn.chenyunlong.common.exception.BusinessException;
import cn.chenyunlong.jpa.support.BaseJpaAggregate;
import cn.chenyunlong.jpa.support.EntityOperations;
import cn.chenyunlong.qing.domain.anime.AnimeInfo;
import cn.chenyunlong.qing.domain.anime.creator.AnimeInfoCreator;
import cn.chenyunlong.qing.domain.anime.mapper.AnimeInfoMapper;
import cn.chenyunlong.qing.domain.anime.repository.AnimeInfoRepository;
import cn.chenyunlong.qing.domain.anime.service.IAnimeInfoService;
import cn.chenyunlong.qing.domain.anime.updater.AnimeInfoUpdater;
import cn.chenyunlong.qing.domain.anime.vo.AnimeInfoVO;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class AnimeInfoServiceImpl implements IAnimeInfoService {
    private final AnimeInfoRepository animeInfoRepository;

    /**
     * createImpl
     */
    @Override
    public Long createAnimeInfo(AnimeInfoCreator creator) {
        Optional<AnimeInfo> animeInfo = EntityOperations
            .doCreate(animeInfoRepository)
            .create(() -> AnimeInfoMapper.INSTANCE.dtoToEntity(creator))
            .update(AnimeInfo::init)
            .execute();
        return animeInfo.isPresent() ? animeInfo.get().getId() : 0;
    }

    /**
     * update
     */
    @Override
    public void updateAnimeInfo(AnimeInfoUpdater updater) {
        EntityOperations
            .doUpdate(animeInfoRepository)
            .loadById(updater.getId())
            .update(updater::updateAnimeInfo)
            .execute();
    }

    /**
     * valid
     */
    @Override
    public void validAnimeInfo(Long id) {
        EntityOperations.doUpdate(animeInfoRepository).loadById(id).update(BaseJpaAggregate::valid)
            .execute();
    }

    /**
     * invalid
     */
    @Override
    public void invalidAnimeInfo(Long id) {
        EntityOperations.doUpdate(animeInfoRepository).loadById(id)
            .update(BaseJpaAggregate::invalid).execute();
    }

    /**
     * findById
     */
    @Override
    public AnimeInfoVO findById(Long id) {
        Optional<AnimeInfo> animeInfo = animeInfoRepository.findById(id);
        return new AnimeInfoVO(
            animeInfo.orElseThrow(() -> new BusinessException(CodeEnum.NotFindError)));
    }

    /**
     * findByPage
     */
    @Override
    public Page<AnimeInfoVO> findByPage(AnimeInfo query, PageRequest pageRequest) {
        Page<AnimeInfo> page = animeInfoRepository.findAll(pageRequest);
        return page.map(AnimeInfoMapper.INSTANCE::entityToVo);
    }
}
