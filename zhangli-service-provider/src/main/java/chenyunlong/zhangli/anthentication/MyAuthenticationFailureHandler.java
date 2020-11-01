package chenyunlong.zhangli.anthentication;

import chenyunlong.zhangli.model.ResultUtil;
import chenyunlong.zhangli.model.vo.ApiResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Stan
 */
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private final Logger logger = LoggerFactory.getLogger(MyAuthenticationFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {

        ApiResult result;
        if (exception instanceof UsernameNotFoundException || exception instanceof BadCredentialsException) {
            result = ResultUtil.fail(exception.getMessage());
        } else if (exception instanceof LockedException) {
            result = ResultUtil.fail("账户被锁定，请联系管理员!");
        } else if (exception instanceof CredentialsExpiredException) {
            result = ResultUtil.fail("证书过期，请联系管理员!");
        } else if (exception instanceof AccountExpiredException) {
            result = ResultUtil.fail("账户过期，请联系管理员!");
        } else if (exception instanceof DisabledException) {
            result = ResultUtil.fail("账户被禁用，请联系管理员!");
        } else {
            logger.error("登录失败：", exception);
            result = ResultUtil.fail("登录失败!");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }
}
