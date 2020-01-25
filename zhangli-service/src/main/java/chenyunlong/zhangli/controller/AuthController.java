package chenyunlong.zhangli.controller;

import chenyunlong.zhangli.annotation.Log;
import chenyunlong.zhangli.entities.User;
import chenyunlong.zhangli.entities.UserInfo;
import chenyunlong.zhangli.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.converters.Auto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.netty.util.internal.StringUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthGithubRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("authrize")
public class AuthController {

    @Autowired
    private AuthGithubRequest authRequest;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private UserService userService;

    @PostMapping("auth")
    public String login(
            @RequestBody String code
    ) {
        authRequest.login(code);
        return "登陆状态";
    }

    /**
     * 表单登陆接口
     *
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    @Log("通过表单登陆")
    @ApiOperation("通过表单登陆")
    @PostMapping("formLogin")
    public String formLofin(@RequestParam String userName, @RequestParam String password) {

        if (StringUtil.isNullOrEmpty(userName)) {
            return "username required";
        }
        if (StringUtil.isNullOrEmpty(password)) {
            return "password required";
        }
        User user = new User(userName, password);

        User userInfo = userService.login(user);
        return String.valueOf(userInfo);
    }

    /**
     * 跳转到登陆表单
     *
     * @return
     */
    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:" + authRequest.authorize());
        return modelAndView;
    }

    @GetMapping("access_token")
    public String accessToken(@RequestParam String code) throws JsonProcessingException {

        AuthResponse authResponse = authRequest.login(code);
        AuthUser user = (AuthUser) authResponse.getData();


        String jwt = Jwts.builder()
                .claim("authorities", "权限内容")//配置用户角色
                .setSubject(objectMapper.writeValueAsString(user))
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS512, "sang@123")
                .compact();
        redisTemplate.opsForValue().set(jwt, user);
        return jwt;
    }

    @GetMapping("getUserInfo")
    public String getUserInfo(HttpSession session) throws JsonProcessingException {


        Object userInfo = session.getAttribute("userInfo");
        if (userInfo != null) {
            log.debug(userInfo.toString());
        } else {
            userInfo = "Staninc";
            log.debug("没有用户信息！");
        }

        return objectMapper.writeValueAsString(userInfo);
    }
}
