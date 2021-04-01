package chenyunlong.zhangli.service.impl;

import chenyunlong.zhangli.model.entities.UploadFile;
import chenyunlong.zhangli.mapper.FileMapper;
import chenyunlong.zhangli.service.FileUploadService;
import org.springframework.stereotype.Service;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    private final FileMapper fileMapper;

    public FileUploadServiceImpl(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }


    @Override
    public void saveFile(UploadFile uploadFile) {
        fileMapper.save(uploadFile);
    }
}
