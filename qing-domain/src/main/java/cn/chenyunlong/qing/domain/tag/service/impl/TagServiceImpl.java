package cn.chenyunlong.qing.domain.tag.service.impl;

import cn.chenyunlong.common.constants.CodeEnum;
import cn.chenyunlong.common.exception.BusinessException;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.jpa.support.EntityOperations;
import cn.chenyunlong.jpa.support.domain.BaseEntity;
import cn.chenyunlong.qing.domain.tag.Tag;
import cn.chenyunlong.qing.domain.tag.dto.creator.TagCreator;
import cn.chenyunlong.qing.domain.tag.dto.query.TagQuery;
import cn.chenyunlong.qing.domain.tag.dto.updater.TagUpdater;
import cn.chenyunlong.qing.domain.tag.dto.vo.TagVO;
import cn.chenyunlong.qing.domain.tag.mapper.TagMapper;
import cn.chenyunlong.qing.domain.tag.repository.TagRepository;
import cn.chenyunlong.qing.domain.tag.service.ITagService;
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
public class TagServiceImpl implements ITagService {
    private final TagRepository tagRepository;

    /**
     * createImpl
     */
    @Override
    public Long createTag(TagCreator creator) {
        Optional<Tag> tag = EntityOperations.doCreate(tagRepository)
            .create(() -> TagMapper.INSTANCE.dtoToEntity(creator))
            .update(Tag::init)
            .execute();
        return tag.isPresent() ? tag.get().getId() : 0;
    }

    /**
     * update
     */
    @Override
    public void updateTag(TagUpdater updater) {
        EntityOperations.doUpdate(tagRepository)
            .loadById(updater.getId())
            .update(updater::updateTag)
            .execute();
    }

    /**
     * valid
     */
    @Override
    public void validTag(Long id) {
        EntityOperations.doUpdate(tagRepository)
            .loadById(id)
            .update(BaseEntity::valid)
            .execute();
    }

    /**
     * invalid
     */
    @Override
    public void invalidTag(Long id) {
        EntityOperations.doUpdate(tagRepository)
            .loadById(id)
            .update(BaseEntity::invalid)
            .execute();
    }

    /**
     * findById
     */
    @Override
    public TagVO findById(Long id) {
        Optional<Tag> tag = tagRepository.findById(id);
        return new TagVO(tag.orElseThrow(() -> new BusinessException(CodeEnum.NotFindError)));
    }

    /**
     * findByPage
     */
    @Override
    public Page<TagVO> findByPage(PageRequestWrapper<TagQuery> query) {
        PageRequest pageRequest =
            PageRequest.of(query.getPage(), query.getPageSize(), Sort.Direction.DESC, "createdAt");
        return tagRepository.findAll(pageRequest).map(TagVO::new);
    }
}
