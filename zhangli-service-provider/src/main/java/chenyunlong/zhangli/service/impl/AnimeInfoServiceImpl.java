package chenyunlong.zhangli.service.impl;

import chenyunlong.zhangli.entities.AnimeType;
import chenyunlong.zhangli.entities.anime.AnimeEpisodeEntity;
import chenyunlong.zhangli.entities.anime.AnimeEpisodeEntityExample;
import chenyunlong.zhangli.entities.anime.AnimeInfo;
import chenyunlong.zhangli.mapper.AnimeEpisodeMapper;
import chenyunlong.zhangli.mapper.AnimeInfoMapper;
import chenyunlong.zhangli.mapper.AnimeTypeMapper;
import chenyunlong.zhangli.model.agefans.AgePlayInfoModel;
import chenyunlong.zhangli.model.params.AnimeInfoQuery;
import chenyunlong.zhangli.model.vo.anime.AnimeEpisodeVo;
import chenyunlong.zhangli.model.vo.anime.AnimeInfoRankModel;
import chenyunlong.zhangli.model.vo.anime.AnimeInfoVo;
import chenyunlong.zhangli.service.AnimeInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author Stan
 */
@Slf4j
@Service
public class AnimeInfoServiceImpl implements AnimeInfoService {
    private final AnimeInfoMapper animeInfoMapper;
    private final RestTemplate restTemplate;
    private final AnimeEpisodeMapper animeEpisodeMapper;
    private final AnimeTypeMapper animeTypeMapper;


    public AnimeInfoServiceImpl(AnimeInfoMapper animeInfoMapper,
                                RestTemplate restTemplate,
                                AnimeEpisodeMapper animeEpisodeMapper,
                                AnimeTypeMapper animeTypeMapper) {
        this.animeInfoMapper = animeInfoMapper;
        this.restTemplate = restTemplate;
        this.animeEpisodeMapper = animeEpisodeMapper;
        this.animeTypeMapper = animeTypeMapper;
    }

    @Override
    public AnimeInfoRankModel getRankPage(Pageable pageable, AnimeInfoQuery animeInfoQuery) {
        long count = animeInfoMapper.count(animeInfoQuery);
        List<AnimeInfo> animeInfoList;
        if (count > 0) {
            animeInfoList = animeInfoMapper.listAnimes(pageable, animeInfoQuery);
        } else {
            animeInfoList = new LinkedList<>();
        }
        return new AnimeInfoRankModel(animeInfoList, count);
    }

    @Override
    public void add(AnimeInfo animeInfo) {
        animeInfoMapper.insert(animeInfo);
    }

    /**
     * @param movieId 动漫ID
     */
    @Override
    public AnimeInfoVo getMovieDetail(Long movieId) {
        AnimeInfo animeInfo = animeInfoMapper.selectAnimationDetail(movieId);
        if (animeInfo == null) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        AnimeInfoVo animeInfoVo = objectMapper.convertValue(animeInfo, AnimeInfoVo.class);
        AnimeEpisodeEntityExample episodeEntityExample = new AnimeEpisodeEntityExample();
        episodeEntityExample.createCriteria().andAnimeIdEqualTo(animeInfo.getId());
        List<AnimeEpisodeEntity> episodes = animeEpisodeMapper.selectByExample(episodeEntityExample);
        List<AnimeEpisodeVo> episodeVos = new LinkedList<>();
        episodes.forEach(episode -> episodeVos.add(objectMapper.convertValue(episode, AnimeEpisodeVo.class)));
        animeInfoVo.setEpisodes(episodeVos);
        return animeInfoVo;
    }

    @Override
    public long getTotalCount(String query) {
        return animeInfoMapper.countByNameLike(query);
    }

    @Override
    public List<AnimeInfo> query(Pageable pageable, AnimeInfoQuery animeInfo) {

        return animeInfoMapper.selectAnimationW(animeInfo, pageable.getOffset(), pageable.getPageSize());
    }

    /**
     * 获取播放页数据
     *
     * @param animeId    动漫ID
     * @param sourceType 播放分类
     * @param ep         片段
     * @return 动漫播放页参数信息
     */
    @Override
    public AnimeInfoVo getPlayDetail(Long animeId, int sourceType, int ep) {
        AnimeInfo animeInfo = animeInfoMapper.selectAnimationDetail(animeId);
        return new ObjectMapper().convertValue(animeInfo, AnimeInfoVo.class);
    }

    @Override
    public void updateAnime(AnimeInfo animeInfo) {
        animeInfoMapper.update(animeInfo);
    }

    @Override
    public void deleteAnime(Long animeId) {
        animeInfoMapper.deleteByAnimeId(animeId);
    }

    @Override
    public List<AnimeType> getAllAnimeType() {
        return animeTypeMapper.listTypes();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AnimeType addAnimeType(AnimeType animeType) {
        animeTypeMapper.addAnimeType(animeType);
        return animeType;
    }

    @Override
    public Page<AnimeInfo> getUpdateAnimeInfo(Integer page, Integer pageSize) {

        long total = animeInfoMapper.getUpdateAnimeCount();
        Pageable pageRequest = PageRequest.of(page, pageSize);
        List<AnimeInfo> animeInfoList = animeInfoMapper.selectAnimeByUpdateTime(pageRequest);
        return new PageImpl<>(animeInfoList, pageRequest, total);
    }

    /**
     * 获取推荐用户列表
     *
     * @return 推荐动漫列表
     */
    @Override
    public List<AnimeInfo> getRecommendAnimeInfoList() {
        return animeInfoMapper.listRecommendAnimeInfo();
    }

    /**
     * 获取动漫的播放信息
     *
     * @param movieId 动漫ID
     * @return 动漫的所有集数
     */
    @Override
    public List<AnimeEpisodeEntity> getAnimeEpisodes(Long movieId) {
        AnimeEpisodeEntityExample example = new AnimeEpisodeEntityExample();
        example.createCriteria().andAnimeIdEqualTo(movieId);
        return animeEpisodeMapper.selectByExample(example);
    }

    private void getPlayDetail() {
        String url = "https://www.agefans.tv/_getplay?aid=20120053&playindex=3&epindex=2&r=";
        String referUrl = "https://www.agefans.tv/_getplay?aid=20200101&playindex=3&epindex=1&r=123123123";
        String cookie = "fikker-ebUR-LnSf=gv7ZifqFiXqnepunyf30wdJReFQl52IZ";
        String playUrl = "https://play.agefans.tv/_getplay2?kp=4zPeWaqNhi20IUkB6rXFO2pAJ1otsSb%2FIzpjyjuYSXKly9zoxWCaSFno%2FSoM8yFblxl8IVjeTJ5eIaCbwj%2BgpYDwjV02ZDL8dxaEsoxzUR9hzjeC4pd38w%3D%3D";

        try {
            String requestUrl = url + new Random().nextDouble();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Host", "play.agefans.tv");
            ResponseEntity<AgePlayInfoModel> response = restTemplate.exchange(
                    playUrl,
                    HttpMethod.GET,
                    new HttpEntity<String>(headers),
                    AgePlayInfoModel.class);
            AgePlayInfoModel responseBody = response.getBody();

            log.info("获取地址成功了！");
            log.info("获取地址成功了！:" + responseBody);
        } catch (Exception exception) {
            log.error("获取信息错误", exception);
        }
    }
}
