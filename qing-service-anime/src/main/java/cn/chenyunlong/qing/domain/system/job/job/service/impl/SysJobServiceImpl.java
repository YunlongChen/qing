// ---Auto Generated by Project Qing ---
package cn.chenyunlong.qing.domain.system.job.job.service.impl;

import cn.chenyunlong.common.constants.CodeEnum;
import cn.chenyunlong.common.exception.BusinessException;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.jpa.support.EntityOperations;
import cn.chenyunlong.qing.domain.system.job.job.SysJob;
import cn.chenyunlong.qing.domain.system.job.job.creator.SysJobCreator;
import cn.chenyunlong.qing.domain.system.job.job.mapper.SysJobMapper;
import cn.chenyunlong.qing.domain.system.job.job.query.SysJobQuery;
import cn.chenyunlong.qing.domain.system.job.job.repository.SysJobRepository;
import cn.chenyunlong.qing.domain.system.job.job.service.ISysJobService;
import cn.chenyunlong.qing.domain.system.job.job.updater.SysJobUpdater;
import cn.chenyunlong.qing.domain.system.job.job.vo.SysJobVO;
import cn.chenyunlong.qing.infrastructure.domain.BaseEntity;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class SysJobServiceImpl implements ISysJobService {
    private final SysJobRepository sysJobRepository;

    /**
     * createImpl
     */
    @Override
    public Long createSysJob(SysJobCreator creator) {
        Optional<SysJob> sysJob = EntityOperations.doCreate(sysJobRepository)
                .create(() -> SysJobMapper.INSTANCE.dtoToEntity(creator))
                .update(BaseEntity::init)
                .execute();
        return sysJob.isPresent() ? sysJob.get().getId() : 0;
    }

    /**
     * update
     */
    @Override
    public void updateSysJob(SysJobUpdater updater) {
        EntityOperations.doUpdate(sysJobRepository)
                .loadById(updater.getId())
                .update(e -> updater.updateSysJob(e))
                .execute();
    }

    /**
     * valid
     */
    @Override
    public void validSysJob(Long id) {
        EntityOperations.doUpdate(sysJobRepository)
                .loadById(id)
                .update(e -> e.valid())
                .execute();
    }

    /**
     * invalid
     */
    @Override
    public void invalidSysJob(Long id) {
        EntityOperations.doUpdate(sysJobRepository)
                .loadById(id)
                .update(e -> e.invalid())
                .execute();
    }

    /**
     * findById
     */
    @Override
    public SysJobVO findById(Long id) {
        Optional<SysJob> sysJob = sysJobRepository.findById(id);
        return new SysJobVO(sysJob.orElseThrow(() -> new BusinessException(CodeEnum.NotFindError)));
    }

    /**
     * findByPage
     */
    @Override
    public Page<SysJobVO> findByPage(PageRequestWrapper<SysJobQuery> query) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        Page<SysJob> page = sysJobRepository.findAll(booleanBuilder,
                PageRequest.of(query.getPage() - 1, query.getPageSize(), Sort.by(
                        Sort.Direction.DESC, "createdAt")));
        return new PageImpl<>(page.getContent()
                .stream().map(SysJobVO::new)
                .collect(Collectors.toList()), page.getPageable(), page.getTotalElements());
    }
}
