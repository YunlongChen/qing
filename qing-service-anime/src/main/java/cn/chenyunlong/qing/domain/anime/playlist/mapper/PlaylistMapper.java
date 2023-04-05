// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.playlist.mapper;

import cn.chenyunlong.common.mapper.DateMapper;
import cn.chenyunlong.common.mapper.GenericEnumMapper;
import cn.chenyunlong.qing.domain.anime.playlist.Playlist;
import cn.chenyunlong.qing.domain.anime.playlist.creator.PlaylistCreator;
import cn.chenyunlong.qing.domain.anime.playlist.query.PlaylistQuery;
import cn.chenyunlong.qing.domain.anime.playlist.request.PlaylistCreateRequest;
import cn.chenyunlong.qing.domain.anime.playlist.request.PlaylistQueryRequest;
import cn.chenyunlong.qing.domain.anime.playlist.request.PlaylistUpdateRequest;
import cn.chenyunlong.qing.domain.anime.playlist.response.PlaylistResponse;
import cn.chenyunlong.qing.domain.anime.playlist.updater.PlaylistUpdater;
import cn.chenyunlong.qing.domain.anime.playlist.vo.PlaylistVO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        uses = {
                GenericEnumMapper.class,
                DateMapper.class
        },
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PlaylistMapper {
    PlaylistMapper INSTANCE = Mappers.getMapper(PlaylistMapper.class);

    Playlist dtoToEntity(PlaylistCreator dto);

    PlaylistUpdater request2Updater(PlaylistUpdateRequest request);

    PlaylistCreator request2Dto(PlaylistCreateRequest request);

    PlaylistQuery request2Query(PlaylistQueryRequest request);

    PlaylistResponse vo2Response(PlaylistVO vo);

    default PlaylistResponse vo2CustomResponse(PlaylistVO vo) {
        return vo2Response(vo);
    }
}
