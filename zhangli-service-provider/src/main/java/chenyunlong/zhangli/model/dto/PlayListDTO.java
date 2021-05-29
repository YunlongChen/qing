package chenyunlong.zhangli.model.dto;

import chenyunlong.zhangli.model.dto.base.OutputConverter;
import chenyunlong.zhangli.model.entities.anime.PlaylistEntity;
import lombok.Data;

import java.util.List;

/**
 * @author Stan
 */
@Data
public class PlayListDTO implements OutputConverter<PlayListDTO, PlaylistEntity> {
    private Long id;
    private Long animeId;
    private String name;
    private String description;
    private List<AnimeEpisodeDTO> episodeList;
}
