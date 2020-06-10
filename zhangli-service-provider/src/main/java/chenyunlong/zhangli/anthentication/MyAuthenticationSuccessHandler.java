package chenyunlong.zhangli.anthentication;

import chenyunlong.zhangli.entities.User;
import chenyunlong.zhangli.model.ResultUtil;
import chenyunlong.zhangli.model.response.ApiResult;
import chenyunlong.zhangli.properties.ZhangliProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private static final Logger log = LoggerFactory.getLogger(MyAuthenticationSuccessHandler.class);
    public static final String RETURN_TYPE = "html"; // 登录成功时，用来判断是返回json数据还是跳转html页面


    private final RedisTemplate redisTemplate;
    private final ZhangliProperties zhangliProperties;

    public MyAuthenticationSuccessHandler(RedisTemplate redisTemplate, SecurityProperties securityProperties, ZhangliProperties zhangliProperties) {
        this.redisTemplate = redisTemplate;
        this.zhangliProperties = zhangliProperties;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        SecurityUser user = null;

        ObjectMapper objectMapper = new ObjectMapper();
        String username = (String) authentication.getPrincipal();
        //添加一个jwt Token
        JwtBuilder builder = Jwts.builder();
//        设置主体信息
        String token = builder.setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + zhangliProperties.getSecurity().getJwtTimeOut()))//        设置过期时间
                .setId(authentication.getPrincipal().toString())
                .signWith(SignatureAlgorithm.HS512, zhangliProperties.getSecurity().getSecretKey())
                .compact();
        ApiResult success = ResultUtil.success(token);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(success));
    }
}
