package cn.chenyunlong.qing.application.manager.repository.jpa;

import cn.chenyunlong.jpa.support.BaseJpaRepository;
import cn.chenyunlong.qing.domain.auth.platform.Platform;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformJpaRepository extends BaseJpaRepository<Platform, Long> {

}
