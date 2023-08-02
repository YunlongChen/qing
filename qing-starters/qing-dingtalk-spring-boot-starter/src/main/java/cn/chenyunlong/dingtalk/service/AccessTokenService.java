package cn.chenyunlong.dingtalk.service;

import com.aliyun.dingtalkoauth2_1_0.Client;
import com.aliyun.dingtalkoauth2_1_0.models.GetAccessTokenRequest;
import com.aliyun.dingtalkoauth2_1_0.models.GetAccessTokenResponse;
import com.aliyun.dingtalkoauth2_1_0.models.GetAccessTokenResponseBody;
import com.aliyun.tea.TeaException;
import jakarta.annotation.PostConstruct;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 获取token服务
 *
 * @author Jack.kj@alibaba-inc.com
 * @date 2022/10/2022/10/19
 */
@Slf4j
@Service
public class AccessTokenService {
    private Client auth2Client;

    @Value("${app.appKey}")
    private String appKey;

    @Value("${app.appSecret}")
    private String appSecret;

    private volatile AccessToken accessToken;

    /**
     * 启动获取一个Token
     */
    @PostConstruct
    public void init() throws Exception {
        if (Objects.isNull(appKey)) {
            throw new RuntimeException("please set jvm dingtalk.open.appKey=xxx");
        }

        if (Objects.isNull(appSecret)) {
            throw new RuntimeException("please set jvm dingtalk.open.appSecret=xxx");
        }

        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config();
        config.protocol = "https";
        config.regionId = "central";
        auth2Client = new Client(config);

        // 重试三次如果失败，应用启动不成功，否则启动无意义
        int maxTryTimes = 3;
        while (maxTryTimes-- > 0) {
            if (refreshAccessToken()) {
                break;
            }

            Thread.sleep(100);
        }

        if (maxTryTimes <= 0) {
            throw new RuntimeException(
                "fail to get accessToken from remote, try 3 times, please check your appKey" +
                    " and appSecret");
        }
    }

    private Boolean refreshAccessToken() {
        GetAccessTokenRequest getAccessTokenRequest =
            new GetAccessTokenRequest().setAppKey(appKey).setAppSecret(appSecret);

        try {
            GetAccessTokenResponse getAccessTokenResponse =
                auth2Client.getAccessToken(getAccessTokenRequest);
            if (Objects.isNull(getAccessTokenResponse) ||
                Objects.isNull(getAccessTokenResponse.body)) {
                log.error(
                    "AccessTokenService_getTokenFromRemoteServer getAccessToken return error," +
                        " response={}", getAccessTokenResponse);
                return false;
            }

            GetAccessTokenResponseBody body = getAccessTokenResponse.body;
            if (Objects.isNull(body.accessToken) || Objects.isNull(body.expireIn)) {
                log.error(
                    "AccessTokenService_getTokenFromRemoteServer getAccessToken invalid token, token or expireIn" +
                        " maybe null, accessToken={}, expireIn={}", body.accessToken,
                    body.expireIn);
                return false;
            }

            AccessToken accessToken = new AccessToken();
            accessToken.setAccessToken(body.accessToken);
            accessToken.setExpireTimestamp(System.currentTimeMillis() + body.expireIn * 1000);
            this.accessToken = accessToken;
            log.info("refresh access token success, expireIn={}", body.expireIn);
            return true;
        } catch (TeaException e) {
            log.error("AccessTokenService_getTokenFromRemoteServer getAccessToken throw " +
                "TeaException, errCode={}, errorMessage={}", e.getCode(), e.getMessage(), e);
            return false;
        } catch (Exception e) {
            log.error("AccessTokenService_getTokenFromRemoteServer getAccessToken throw Exception",
                e);
            return false;
        }
    }

    /**
     * 定时检查Token是否过期，过期的了就去刷一下
     */
    @Scheduled(fixedRate = 60 * 1000)
    public void checkAccessToken() {
        if (Objects.isNull(accessToken)) {
            return;
        }

        // check before expired in 10 minutes
        long advanceCheckTime = 10 * 60L;
        if (accessToken.expireTimestamp - System.currentTimeMillis() > advanceCheckTime * 1000L) {
            return;
        }

        refreshAccessToken();
    }

    public String getAccessToken() {
        return accessToken.accessToken;
    }

    public boolean isTokenNearlyExpired() {
        // if expired timestamp nearly 5000ms, should not send requests
        return accessToken.expireTimestamp < System.currentTimeMillis() - 5000L;
    }

    @Getter
    @Setter
    static class AccessToken {
        private String accessToken;
        private Long expireTimestamp;
    }
}
