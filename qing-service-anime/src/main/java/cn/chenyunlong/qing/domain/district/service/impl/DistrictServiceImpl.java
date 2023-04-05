// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.district.service.impl;

import cn.chenyunlong.common.constants.CodeEnum;
import cn.chenyunlong.common.exception.BusinessException;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.jpa.support.EntityOperations;
import cn.chenyunlong.jpa.support.domain.BaseEntity;
import cn.chenyunlong.qing.domain.district.District;
import cn.chenyunlong.qing.domain.district.creator.DistrictCreator;
import cn.chenyunlong.qing.domain.district.mapper.DistrictMapper;
import cn.chenyunlong.qing.domain.district.query.DistrictQuery;
import cn.chenyunlong.qing.domain.district.repository.DistrictRepository;
import cn.chenyunlong.qing.domain.district.service.IDistrictService;
import cn.chenyunlong.qing.domain.district.updater.DistrictUpdater;
import cn.chenyunlong.qing.domain.district.vo.DistrictVO;
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
public class DistrictServiceImpl implements IDistrictService {
    private final DistrictRepository districtRepository;

    /**
     * createImpl
     */
    @Override
    public Long createDistrict(DistrictCreator creator) {
        Optional<District> district = EntityOperations.doCreate(districtRepository)
                .create(() -> DistrictMapper.INSTANCE.dtoToEntity(creator))
                .update(District::init)
                .execute();
        return district.isPresent() ? district.get().getId() : 0;
    }

    /**
     * update
     */
    @Override
    public void updateDistrict(DistrictUpdater updater) {
        EntityOperations.doUpdate(districtRepository)
                .loadById(updater.getId())
                .update(updater::updateDistrict)
                .execute();
    }

    /**
     * valid
     */
    @Override
    public void validDistrict(Long id) {
        EntityOperations.doUpdate(districtRepository)
                .loadById(id)
                .update(BaseEntity::valid)
                .execute();
    }

    /**
     * invalid
     */
    @Override
    public void invalidDistrict(Long id) {
        EntityOperations.doUpdate(districtRepository)
                .loadById(id)
                .update(BaseEntity::invalid)
                .execute();
    }

    /**
     * findById
     */
    @Override
    public DistrictVO findById(Long id) {
        Optional<District> district = districtRepository.findById(id);
        return new DistrictVO(district.orElseThrow(() -> new BusinessException(CodeEnum.NotFindError)));
    }

    /**
     * findByPage
     */
    @Override
    public Page<DistrictVO> findByPage(PageRequestWrapper<DistrictQuery> query) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        Page<District> page = districtRepository.findAll(booleanBuilder,
                PageRequest.of(query.getPage() - 1, query.getPageSize(), Sort.by(
                        Sort.Direction.DESC, "createdAt")));
        return new PageImpl<>(page.getContent()
                .stream().map(DistrictVO::new)
                .collect(Collectors.toList()), page.getPageable(), page.getTotalElements());
    }
}
