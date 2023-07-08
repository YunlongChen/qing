// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.updater;

import cn.chenyunlong.qing.domain.anime.AnimeInfo;
import cn.chenyunlong.qing.domain.anime.PlayStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.util.Optional;

@Schema
@Data
public class AnimeInfoUpdater {
  @Schema(
      title = "name"
  )
  private String name;

  @Schema(
      title = "instruction"
  )
  private String instruction;

  @Schema(
      title = "districtId"
  )
  private Long districtId;

  @Schema(
      title = "districtName"
  )
  private String districtName;

  @Schema(
      title = "coverUrl"
  )
  private String coverUrl;

  @Schema(
      title = "typeId"
  )
  private Long typeId;

  @Schema(
      title = "typeName"
  )
  private String typeName;

  @Schema(
      title = "originalName"
  )
  private String originalName;

  @Schema(
      title = "otherName"
  )
  private String otherName;

  @Schema(
      title = "author"
  )
  private String author;

  @Schema(
      title = "company"
  )
  private String company;

  @Schema(
      title = "premiereDate"
  )
  private LocalDate premiereDate;

  @Schema(
      title = "playStatus"
  )
  private PlayStatus playStatus;

  @Schema(
      title = "plotType"
  )
  private String plotType;

  @Schema(
      title = "tags"
  )
  private String tags;

  @Schema(
      title = "officialWebsite"
  )
  private String officialWebsite;

  @Schema(
      title = "playHeat"
  )
  private String playHeat;

  @Schema(
      title = "orderNo"
  )
  private Integer orderNo;

  private Long id;

  public void updateAnimeInfo(AnimeInfo param) {
    Optional.ofNullable(getName()).ifPresent(param::setName);
    Optional.ofNullable(getInstruction()).ifPresent(param::setInstruction);
    Optional.ofNullable(getDistrictId()).ifPresent(param::setDistrictId);
    Optional.ofNullable(getDistrictName()).ifPresent(param::setDistrictName);
    Optional.ofNullable(getCoverUrl()).ifPresent(param::setCoverUrl);
    Optional.ofNullable(getTypeId()).ifPresent(param::setTypeId);
    Optional.ofNullable(getTypeName()).ifPresent(param::setTypeName);
    Optional.ofNullable(getOriginalName()).ifPresent(param::setOriginalName);
    Optional.ofNullable(getOtherName()).ifPresent(param::setOtherName);
    Optional.ofNullable(getAuthor()).ifPresent(param::setAuthor);
    Optional.ofNullable(getCompany()).ifPresent(param::setCompany);
    Optional.ofNullable(getPremiereDate()).ifPresent(param::setPremiereDate);
    Optional.ofNullable(getPlayStatus()).ifPresent(param::setPlayStatus);
    Optional.ofNullable(getPlotType()).ifPresent(param::setPlotType);
    Optional.ofNullable(getTags()).ifPresent(param::setTags);
    Optional.ofNullable(getOfficialWebsite()).ifPresent(param::setOfficialWebsite);
    Optional.ofNullable(getPlayHeat()).ifPresent(param::setPlayHeat);
    Optional.ofNullable(getOrderNo()).ifPresent(param::setOrderNo);
  }
}
