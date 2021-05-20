package chenyunlong.zhangli.model.dto.anime;

import chenyunlong.zhangli.model.dto.base.OutputConverter;
import chenyunlong.zhangli.model.dto.bilibili.AnimeInfoDTO;
import chenyunlong.zhangli.model.entities.anime.AnimeInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Stan
 */
@Data
@ToString
@EqualsAndHashCode
public class AnimeInfoUpdateDTO implements OutputConverter<AnimeInfoUpdateDTO, AnimeInfo> {

    private Long id;
    private String name;
    @JsonProperty("isnew")
    private Boolean isNew = true;

    @JsonProperty("wd")
    public Integer getWd() {
        return premiereDate != null ? premiereDate.getDayOfWeek().ordinal() : 1;
    }

    @JsonProperty("mtime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime premiereDate = LocalDateTime.now();
    @JsonProperty("namefornew")
    private String nameForNew;
}
