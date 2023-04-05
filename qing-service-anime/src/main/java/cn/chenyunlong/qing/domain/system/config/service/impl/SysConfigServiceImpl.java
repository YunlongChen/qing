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
package cn.chenyunlong.qing.domain.system.config.service.impl;

import cn.chenyunlong.common.constants.CodeEnum;
import cn.chenyunlong.common.exception.BusinessException;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.jpa.support.EntityOperations;
import cn.chenyunlong.jpa.support.domain.BaseEntity;
import cn.chenyunlong.qing.domain.system.config.SysConfig;
import cn.chenyunlong.qing.domain.system.config.creator.SysConfigCreator;
import cn.chenyunlong.qing.domain.system.config.mapper.SysConfigMapper;
import cn.chenyunlong.qing.domain.system.config.query.SysConfigQuery;
import cn.chenyunlong.qing.domain.system.config.repository.SysConfigRepository;
import cn.chenyunlong.qing.domain.system.config.service.ISysConfigService;
import cn.chenyunlong.qing.domain.system.config.updater.SysConfigUpdater;
import cn.chenyunlong.qing.domain.system.config.vo.SysConfigVO;
import com.querydsl.core.BooleanBuilder;

import java.lang.Long;
import java.lang.Override;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class SysConfigServiceImpl implements ISysConfigService {
    private final SysConfigRepository sysConfigRepository;

    /**
     * createImpl
     */
    @Override
    public Long createSysConfig(SysConfigCreator creator) {
        Optional<SysConfig> sysConfig = EntityOperations.doCreate(sysConfigRepository)
                .create(() -> SysConfigMapper.INSTANCE.dtoToEntity(creator))
                .update(SysConfig::init)
                .execute();
        return sysConfig.isPresent() ? sysConfig.get().getId() : 0;
    }

    /**
     * update
     */
    @Override
    public void updateSysConfig(SysConfigUpdater updater) {
        EntityOperations.doUpdate(sysConfigRepository)
                .loadById(updater.getId())
                .update(updater::updateSysConfig)
                .execute();
    }

    /**
     * valid
     */
    @Override
    public void validSysConfig(Long id) {
        EntityOperations.doUpdate(sysConfigRepository)
                .loadById(id)
                .update(BaseEntity::valid)
                .execute();
    }

    /**
     * invalid
     */
    @Override
    public void invalidSysConfig(Long id) {
        EntityOperations.doUpdate(sysConfigRepository)
                .loadById(id)
                .update(BaseEntity::invalid)
                .execute();
    }

    /**
     * findById
     */
    @Override
    public SysConfigVO findById(Long id) {
        Optional<SysConfig> sysConfig = sysConfigRepository.findById(id);
        return new SysConfigVO(sysConfig.orElseThrow(() -> new BusinessException(CodeEnum.NotFindError)));
    }

    /**
     * findByPage
     */
    @Override
    public Page<SysConfigVO> findByPage(PageRequestWrapper<SysConfigQuery> query) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        Page<SysConfig> page = sysConfigRepository.findAll(booleanBuilder,
                PageRequest.of(query.getPage() - 1, query.getPageSize(), Sort.by(
                        Sort.Direction.DESC, "createdAt")));
        return new PageImpl<>(page.getContent()
                .stream().map(SysConfigVO::new)
                .collect(Collectors.toList()), page.getPageable(), page.getTotalElements());
    }
}
