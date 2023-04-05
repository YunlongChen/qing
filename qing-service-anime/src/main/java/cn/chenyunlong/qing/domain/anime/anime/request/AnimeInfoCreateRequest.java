// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.anime.anime.request;

import cn.chenyunlong.common.model.Request;
import cn.chenyunlong.qing.domain.anime.anime.PlayStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Schema
@Data
public class AnimeInfoCreateRequest implements Request {
  @Schema(
          title = "Name",
          description = "name"
  )
  private String name;

  @Schema(
          title = "Instruction",
          description = "instruction"
  )
  private String instruction;

  @Schema(
          title = "DistrictId",
          description = "districtId"
  )
  private Long districtId;

  @Schema(
          title = "DistrictName",
          description = "districtName"
  )
  private String districtName;

  @Schema(
          title = "CoverUrl",
          description = "coverUrl"
  )
  private String coverUrl;

  @Schema(
          title = "TypeId",
          description = "typeId"
  )
  private Long typeId;

  @Schema(
          title = "TypeName",
          description = "typeName"
  )
  private String typeName;

  @Schema(
          title = "OriginalName",
          description = "originalName"
  )
  private String originalName;

  @Schema(
          title = "OtherName",
          description = "otherName"
  )
  private String otherName;

  @Schema(
          title = "Author",
          description = "author"
  )
  private String author;

  @Schema(
          title = "Company",
          description = "company"
  )
  private String company;

  @Schema(
          title = "PremiereDate",
          description = "premiereDate"
  )
  private LocalDate premiereDate;

  @Schema(
          title = "PlayStatus",
          description = "playStatus"
  )
  private PlayStatus playStatus;

  @Schema(
          title = "PlotType",
          description = "plotType"
  )
  private String plotType;

  @Schema(
          title = "Tags",
          description = "tags"
  )
  private String tags;

  @Schema(
          title = "OfficialWebsite",
          description = "officialWebsite"
  )
  private String officialWebsite;

  @Schema(
          title = "PlayHeat",
          description = "playHeat"
  )
  private String playHeat;

  @Schema(
          title = "OrderNo",
          description = "orderNo"
  )
  private Integer orderNo;
}
