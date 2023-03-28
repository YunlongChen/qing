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
package cn.chenyunlong.qing.domain.system.job.job.service;

import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.qing.domain.system.job.job.creator.SysJobCreator;
import cn.chenyunlong.qing.domain.system.job.job.query.SysJobQuery;
import cn.chenyunlong.qing.domain.system.job.job.updater.SysJobUpdater;
import cn.chenyunlong.qing.domain.system.job.job.vo.SysJobVO;
import org.springframework.data.domain.Page;

public interface ISysJobService {
    /**
     * create
     */
    Long createSysJob(SysJobCreator creator);

    /**
     * update
     */
    void updateSysJob(SysJobUpdater updater);

    /**
     * valid
     */
    void validSysJob(Long id);

    /**
     * invalid
     */
    void invalidSysJob(Long id);

    /**
     * findById
     */
    SysJobVO findById(Long id);

    /**
     * findByPage
     */
    Page<SysJobVO> findByPage(PageRequestWrapper<SysJobQuery> query);
}
