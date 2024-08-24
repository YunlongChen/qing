package cn.chenyunlong.qing.domain.anime.episode.repository;

import cn.chenyunlong.jpa.support.BaseRepository;
import cn.chenyunlong.qing.domain.anime.episode.Episode;

public interface EpisodeRepository extends BaseRepository<Episode, Long> {

    Integer findMaxEpisodeNumberByPlayListId(Long playListId);
}
