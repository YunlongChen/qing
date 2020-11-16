package stan.zhangli.natcross.service.impl;

import org.springframework.stereotype.Service;
import stan.zhangli.natcross.entity.ListenPort;
import stan.zhangli.natcross.mapper.ListenPortMapper;
import stan.zhangli.natcross.service.IListenPortService;

import java.util.List;

@Service
public class IListenPortServiceImpl implements IListenPortService {

    private final ListenPortMapper listenPortMapper;

    public IListenPortServiceImpl(ListenPortMapper listenPortMapper) {
        this.listenPortMapper = listenPortMapper;
    }

    @Override
    public int count() {
        return listenPortMapper.count();
    }

    @Override
    public boolean save(ListenPort listenPort) {
        return listenPortMapper.save(listenPort);
    }

    @Override
    public void removeById(Integer listenPort) {
        listenPortMapper.removeById(listenPort);
    }

    @Override
    public List<ListenPort> list() {
        return listenPortMapper.list();
    }

    @Override
    public ListenPort getByListenPort(Integer listenPort) {
        return listenPortMapper.getByListenPort(listenPort);
    }

    @Override
    public boolean updateById(ListenPort listenPort) {
        return false;
    }
}
