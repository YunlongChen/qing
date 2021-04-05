package chenyunlong.zhangli.controller.api;

import chenyunlong.zhangli.common.annotation.Log;
import chenyunlong.zhangli.model.entities.AnimeType;
import chenyunlong.zhangli.model.entities.District;
import chenyunlong.zhangli.model.entities.Version;
import chenyunlong.zhangli.model.support.ApiResult;
import chenyunlong.zhangli.service.AnimeTypeService;
import chenyunlong.zhangli.service.DistrictService;
import chenyunlong.zhangli.service.VersionService;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Stan
 */
@Validated
@Api(tags = "anime")
@RestController
@RequestMapping("api/district")
public class AnimeController {
    private final DistrictService districtService;
    private final VersionService versionService;
    private final AnimeTypeService animeTypeService;

    public AnimeController(DistrictService districtService, VersionService versionService, AnimeTypeService animeTypeService) {
        this.districtService = districtService;
        this.versionService = versionService;
        this.animeTypeService = animeTypeService;
    }

    @GetMapping("list")
    public ApiResult<List<District>> getDistrictList() {
        return ApiResult.success(districtService.getAllDistrict());
    }

    @GetMapping("version/list")
    public ApiResult<List<Version>> getVersionList() {
        return ApiResult.success(versionService.getAllVersions());
    }

    @Log("获取所有类型信息")
    @GetMapping("type/list")
    public ApiResult<List<AnimeType>> getAnimeInfoService() {
        return ApiResult.success(animeTypeService.getAllTypeInfo());
    }

    @Log("获取所有类型信息")
    @PostMapping("type/add")
    public ApiResult<AnimeType> addAnimeType(@Valid @RequestBody AnimeType animeType) {
        animeTypeService.addAnimeType(animeType);
        return ApiResult.success();
    }

}
