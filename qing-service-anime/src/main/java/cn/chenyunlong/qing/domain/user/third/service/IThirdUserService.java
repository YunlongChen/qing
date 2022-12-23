// ---Auto Generated by Project Qing ---
package cn.chenyunlong.qing.domain.user.third.service;

import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.qing.domain.user.third.creator.ThirdUserCreator;
import cn.chenyunlong.qing.domain.user.third.query.ThirdUserQuery;
import cn.chenyunlong.qing.domain.user.third.updater.ThirdUserUpdater;
import cn.chenyunlong.qing.domain.user.third.vo.ThirdUserVO;
import org.springframework.data.domain.Page;

public interface IThirdUserService {
    /**
     * create
     */
    Long createThirdUser(ThirdUserCreator creator);

    /**
     * update
     */
    void updateThirdUser(ThirdUserUpdater updater);

    /**
     * valid
     */
    void validThirdUser(Long id);

    /**
     * invalid
     */
    void invalidThirdUser(Long id);

    /**
     * findById
     */
    ThirdUserVO findById(Long id);

    /**
     * findByPage
     */
    Page<ThirdUserVO> findByPage(PageRequestWrapper<ThirdUserQuery> query);
}
