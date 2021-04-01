package chenyunlong.zhangli.service.impl;

import chenyunlong.zhangli.model.entities.anime.AnimeInfo;
import chenyunlong.zhangli.mapper.AnimeInfoMapper;
import chenyunlong.zhangli.mapper.AnimeRecommendMapper;
import chenyunlong.zhangli.model.params.AnimeInfoQuery;
import chenyunlong.zhangli.service.AnimeRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Stan
 */
@Service
public class AnimeRecommendServiceImpl implements AnimeRecommendService {

    @Autowired
    private AnimeRecommendMapper animeRecommendMapper;

    @Autowired
    private AnimeInfoMapper animeInfoMapper;

    @Override
    public List<AnimeInfo> getRecommendAnimeInfoList(Pageable pageable, AnimeInfoQuery animeInfoQuery) {
        return animeInfoMapper.listAnimes(pageable, animeInfoQuery);
    }
}
