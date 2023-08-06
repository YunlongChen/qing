// ---Auto Generated by Qing-Generator --
package cn.chenyunlong.qing.domain.file.service.impl;

import cn.chenyunlong.common.constants.CodeEnum;
import cn.chenyunlong.common.exception.BusinessException;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.jpa.support.EntityOperations;
import cn.chenyunlong.jpa.support.domain.BaseEntity;
import cn.chenyunlong.qing.domain.file.UploadFile;
import cn.chenyunlong.qing.domain.file.creator.UploadFileCreator;
import cn.chenyunlong.qing.domain.file.mapper.UploadFileMapper;
import cn.chenyunlong.qing.domain.file.query.UploadFileQuery;
import cn.chenyunlong.qing.domain.file.repository.UploadFileRepository;
import cn.chenyunlong.qing.domain.file.service.IUploadFileService;
import cn.chenyunlong.qing.domain.file.updater.UploadFileUpdater;
import cn.chenyunlong.qing.domain.file.vo.UploadFileVO;
import java.lang.Long;
import java.lang.Override;
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
public class UploadFileServiceImpl implements IUploadFileService {
    private final UploadFileRepository uploadFileRepository;

    /**
     * createImpl
     */
    @Override
    public Long createUploadFile(UploadFileCreator creator) {
        Optional<UploadFile> uploadFile = EntityOperations.doCreate(uploadFileRepository)
        .create(() -> UploadFileMapper.INSTANCE.dtoToEntity(creator))
        .update(UploadFile::init)
        .execute();
        return uploadFile.isPresent() ? uploadFile.get().getId() : 0;
    }

    /**
     * update
     */
    @Override
    public void updateUploadFile(UploadFileUpdater updater) {
        EntityOperations.doUpdate(uploadFileRepository)
        .loadById(updater.getId())
        .update(updater::updateUploadFile)
        .execute();
    }

    /**
     * valid
     */
    @Override
    public void validUploadFile(Long id) {
        EntityOperations.doUpdate(uploadFileRepository)
        .loadById(id)
        .update(BaseEntity::valid)
        .execute();
    }

    /**
     * invalid
     */
    @Override
    public void invalidUploadFile(Long id) {
        EntityOperations.doUpdate(uploadFileRepository)
        .loadById(id)
        .update(BaseEntity::invalid)
        .execute();
    }

    /**
     * findById
     */
    @Override
    public UploadFileVO findById(Long id) {
        Optional<UploadFile> uploadFile =  uploadFileRepository.findById(id);
        return new UploadFileVO(uploadFile.orElseThrow(() -> new BusinessException(CodeEnum.NotFindError)));
    }

    /**
     * findByPage
     */
    @Override
    public Page<UploadFileVO> findByPage(PageRequestWrapper<UploadFileQuery> query) {
        PageRequest pageRequest = PageRequest.of(query.getPage(), query.getPageSize(), Sort.Direction.DESC, "createdAt");
        return uploadFileRepository.findAll(pageRequest).map(UploadFileVO::new);
    }
}
