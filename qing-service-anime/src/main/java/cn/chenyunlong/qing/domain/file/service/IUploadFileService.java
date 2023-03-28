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
package cn.chenyunlong.qing.domain.file.service;

import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.qing.domain.file.creator.UploadFileCreator;
import cn.chenyunlong.qing.domain.file.query.UploadFileQuery;
import cn.chenyunlong.qing.domain.file.updater.UploadFileUpdater;
import cn.chenyunlong.qing.domain.file.vo.UploadFileVO;
import org.springframework.data.domain.Page;

public interface IUploadFileService {
    /**
     * create
     */
    Long createUploadFile(UploadFileCreator creator);

    /**
     * update
     */
    void updateUploadFile(UploadFileUpdater updater);

    /**
     * valid
     */
    void validUploadFile(Long id);

    /**
     * invalid
     */
    void invalidUploadFile(Long id);

    /**
     * findById
     */
    UploadFileVO findById(Long id);

    /**
     * findByPage
     */
    Page<UploadFileVO> findByPage(PageRequestWrapper<UploadFileQuery> query);
}
