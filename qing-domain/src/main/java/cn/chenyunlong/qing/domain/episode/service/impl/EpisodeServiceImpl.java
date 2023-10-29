package cn.chenyunlong.qing.domain.episode.service.impl;

import cn.chenyunlong.common.constants.CodeEnum;
import cn.chenyunlong.common.exception.BusinessException;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.jpa.support.EntityOperations;
import cn.chenyunlong.jpa.support.domain.BaseEntity;
import cn.chenyunlong.qing.domain.episode.Episode;
import cn.chenyunlong.qing.domain.episode.dto.creator.EpisodeCreator;
import cn.chenyunlong.qing.domain.episode.dto.query.EpisodeQuery;
import cn.chenyunlong.qing.domain.episode.dto.updater.EpisodeUpdater;
import cn.chenyunlong.qing.domain.episode.dto.vo.EpisodeVO;
import cn.chenyunlong.qing.domain.episode.mapper.EpisodeMapper;
import cn.chenyunlong.qing.domain.episode.repository.EpisodeRepository;
import cn.chenyunlong.qing.domain.episode.service.IEpisodeService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class EpisodeServiceImpl implements IEpisodeService {
    private final EpisodeRepository episodeRepository;

    /**
     * createImpl
     */
    @Override
    public Long createEpisode(EpisodeCreator creator) {
        Optional<Episode> episode = EntityOperations.doCreate(episodeRepository)
            .create(() -> EpisodeMapper.INSTANCE.dtoToEntity(creator))
            .update(Episode::init)
            .execute();
        return episode.isPresent() ? episode.get().getId() : 0;
    }

    /**
     * update
     */
    @Override
    public void updateEpisode(EpisodeUpdater updater) {
        EntityOperations.doUpdate(episodeRepository)
            .loadById(updater.getId())
            .update(updater::updateEpisode)
            .execute();
    }

    /**
     * valid
     */
    @Override
    public void validEpisode(Long id) {
        EntityOperations.doUpdate(episodeRepository)
            .loadById(id)
            .update(BaseEntity::valid)
            .execute();
    }

    /**
     * invalid
     */
    @Override
    public void invalidEpisode(Long id) {
        EntityOperations.doUpdate(episodeRepository)
            .loadById(id)
            .update(BaseEntity::invalid)
            .execute();
    }

    /**
     * findById
     */
    @Override
    public EpisodeVO findById(Long id) {
        Optional<Episode> episode = episodeRepository.findById(id);
        return new EpisodeVO(
            episode.orElseThrow(() -> new BusinessException(CodeEnum.NotFindError)));
    }

    /**
     * findByPage
     */
    @Override
    public Page<EpisodeVO> findByPage(PageRequestWrapper<EpisodeQuery> query) {
        PageRequest pageRequest =
            PageRequest.of(query.getPage(), query.getPageSize(), Sort.Direction.DESC, "createdAt");
        return episodeRepository.findAll(pageRequest).map(EpisodeVO::new);
    }
}
