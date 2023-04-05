// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.permission.service;

import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.qing.domain.permission.creator.PermissionCreator;
import cn.chenyunlong.qing.domain.permission.query.PermissionQuery;
import cn.chenyunlong.qing.domain.permission.updater.PermissionUpdater;
import cn.chenyunlong.qing.domain.permission.vo.PermissionVO;

import java.lang.Long;

import org.springframework.data.domain.Page;

public interface IPermissionService {
    /**
     * create
     */
    Long createPermission(PermissionCreator creator);

    /**
     * update
     */
    void updatePermission(PermissionUpdater updater);

    /**
     * valid
     */
    void validPermission(Long id);

    /**
     * invalid
     */
    void invalidPermission(Long id);

    /**
     * findById
     */
    PermissionVO findById(Long id);

    /**
     * findByPage
     */
    Page<PermissionVO> findByPage(PageRequestWrapper<PermissionQuery> query);
}
