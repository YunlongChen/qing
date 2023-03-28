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
package cn.chenyunlong.qing.domain.anime.tag.service.impl;

import cn.chenyunlong.common.constants.CodeEnum;
import cn.chenyunlong.common.exception.BusinessException;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.jpa.support.EntityOperations;
import cn.chenyunlong.qing.domain.anime.tag.AnimeTag;
import cn.chenyunlong.qing.domain.anime.tag.creator.AnimeTagCreator;
import cn.chenyunlong.qing.domain.anime.tag.mapper.AnimeTagMapper;
import cn.chenyunlong.qing.domain.anime.tag.query.AnimeTagQuery;
import cn.chenyunlong.qing.domain.anime.tag.repository.AnimeTagRepository;
import cn.chenyunlong.qing.domain.anime.tag.service.IAnimeTagService;
import cn.chenyunlong.qing.domain.anime.tag.updater.AnimeTagUpdater;
import cn.chenyunlong.qing.domain.anime.tag.vo.AnimeTagVO;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class AnimeTagServiceImpl implements IAnimeTagService {
    private final AnimeTagRepository animeTagRepository;

    /**
     * createImpl
     */
    @Override
    public Long createAnimeTag(AnimeTagCreator creator) {
        Optional<AnimeTag> animeTag = EntityOperations.doCreate(animeTagRepository)
                .create(() -> AnimeTagMapper.INSTANCE.dtoToEntity(creator))
                .update(e -> e.init())
                .execute();
        return animeTag.isPresent() ? animeTag.get().getId() : 0;
    }

    /**
     * update
     */
    @Override
    public void updateAnimeTag(AnimeTagUpdater updater) {
        EntityOperations.doUpdate(animeTagRepository)
                .loadById(updater.getId())
                .update(e -> updater.updateAnimeTag(e))
                .execute();
    }

    /**
     * valid
     */
    @Override
    public void validAnimeTag(Long id) {
        EntityOperations.doUpdate(animeTagRepository)
                .loadById(id)
                .update(e -> e.valid())
                .execute();
    }

    /**
     * invalid
     */
    @Override
    public void invalidAnimeTag(Long id) {
        EntityOperations.doUpdate(animeTagRepository)
                .loadById(id)
                .update(e -> e.invalid())
                .execute();
    }

    /**
     * findById
     */
    @Override
    public AnimeTagVO findById(Long id) {
        Optional<AnimeTag> animeTag = animeTagRepository.findById(id);
        return new AnimeTagVO(animeTag.orElseThrow(() -> new BusinessException(CodeEnum.NotFindError)));
    }

    /**
     * @return
     */
    @Override
    public List<AnimeTagVO> listAll() {
        return animeTagRepository.findAll().stream().map(AnimeTagMapper.INSTANCE::entityToVo).toList();
    }

    /**
     * findByPage
     */
    @Override
    public Page<AnimeTagVO> findByPage(PageRequestWrapper<AnimeTagQuery> query) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        Page<AnimeTag> page = animeTagRepository.findAll(booleanBuilder,
                PageRequest.of(query.getPage() - 1, query.getPageSize(), Sort.by(
                        Sort.Direction.DESC, "createdAt")));
        return new PageImpl<>(page.getContent()
                .stream().map(AnimeTagVO::new)
                .collect(Collectors.toList()), page.getPageable(), page.getTotalElements());
    }
}
