package cn.chenyunlong.qing.web.web.system;

import cn.chenyunlong.common.model.JsonResult;
import cn.chenyunlong.qing.config.security.utils.JwtTokenUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class IndexController {

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Value("${qing.security.jwt.header}")
    private String tokenHeader;

    @PostMapping("/refreshToken")
    public JsonResult<Map<String, Object>> refreshToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String oldToken) {
        String token;
        // 如果 token 已经过期, 那么就不支持续约新的 token 了
        if (!jwtTokenUtil.isTokenExpired(oldToken)) {
            token = jwtTokenUtil.refreshHeadToken(oldToken);
            Map<String, Object> map = new HashMap<>();
            map.put("token", token);
            map.put("tokenHeader", tokenHeader);
            return JsonResult.success(map);
        }
        return JsonResult.fail("token已过期");
    }

}
