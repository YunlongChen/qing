package cn.chenyunlong.qing.application.manager.repository.jpa;

import cn.chenyunlong.jpa.support.BaseJpaRepository;
import cn.chenyunlong.qing.domain.anime.anime.AnimeTagRel;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeTagJpaRepository extends BaseJpaRepository<AnimeTagRel, Long> {

}
