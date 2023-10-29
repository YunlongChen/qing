package cn.chenyunlong.qing.domain.zan.service.impl;

import cn.chenyunlong.common.constants.CodeEnum;
import cn.chenyunlong.common.exception.BusinessException;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.jpa.support.EntityOperations;
import cn.chenyunlong.jpa.support.domain.BaseEntity;
import cn.chenyunlong.qing.domain.zan.Zan;
import cn.chenyunlong.qing.domain.zan.dto.creator.ZanCreator;
import cn.chenyunlong.qing.domain.zan.dto.query.ZanQuery;
import cn.chenyunlong.qing.domain.zan.dto.updater.ZanUpdater;
import cn.chenyunlong.qing.domain.zan.dto.vo.ZanVO;
import cn.chenyunlong.qing.domain.zan.mapper.ZanMapper;
import cn.chenyunlong.qing.domain.zan.repository.ZanRepository;
import cn.chenyunlong.qing.domain.zan.request.ZanCreateRequest;
import cn.chenyunlong.qing.domain.zan.service.IZanService;
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
public class ZanServiceImpl implements IZanService {
    private final ZanRepository zanRepository;

    /**
     * createImpl
     */
    @Override
    public Long createZan(ZanCreator creator) {
        Optional<Zan> zan = EntityOperations.doCreate(zanRepository)
            .create(() -> ZanMapper.INSTANCE.dtoToEntity(creator))
            .update(Zan::init)
            .execute();
        return zan.isPresent() ? zan.get().getId() : 0;
    }

    /**
     * update
     */
    @Override
    public void updateZan(ZanUpdater updater) {
        EntityOperations.doUpdate(zanRepository)
            .loadById(updater.getId())
            .update(updater::updateZan)
            .execute();
    }

    /**
     * valid
     */
    @Override
    public void validZan(Long id) {
        EntityOperations.doUpdate(zanRepository)
            .loadById(id)
            .update(BaseEntity::valid)
            .execute();
    }

    /**
     * invalid
     */
    @Override
    public void invalidZan(Long id) {
        EntityOperations.doUpdate(zanRepository)
            .loadById(id)
            .update(BaseEntity::invalid)
            .execute();
    }

    /**
     * findById
     */
    @Override
    public ZanVO findById(Long id) {
        Optional<Zan> zan = zanRepository.findById(id);
        return new ZanVO(zan.orElseThrow(() -> new BusinessException(CodeEnum.NotFindError)));
    }

    /**
     * findByPage
     */
    @Override
    public Page<ZanVO> findByPage(PageRequestWrapper<ZanQuery> query) {
        PageRequest pageRequest =
            PageRequest.of(query.getPage(), query.getPageSize(), Sort.Direction.DESC, "createdAt");
        return zanRepository.findAll(pageRequest).map(ZanVO::new);
    }

    @Override
    public Long like(ZanCreateRequest creator) {
        return null;
    }
}
