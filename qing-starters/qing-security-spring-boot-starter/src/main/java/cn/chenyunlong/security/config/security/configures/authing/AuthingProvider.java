/*
 * Copyright (c) 2023  YunLong Chen
 * Project Qing is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *          http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND,
 * EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT,
 * MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 *
 */

package cn.chenyunlong.security.config.security.configures.authing;

import cn.authing.sdk.java.client.AuthenticationClient;
import cn.authing.sdk.java.dto.authentication.OIDCTokenResponse;
import cn.authing.sdk.java.model.AuthenticationClientOptions;
import cn.chenyunlong.security.config.security.AuthingConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;

@Component
@Slf4j
@RequiredArgsConstructor
public class AuthingProvider implements AuthenticationProvider {

    private final AuthingConfig authing;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        AuthingToken authingToken = (AuthingToken) authentication;
        log.info("密码登录逻辑开始");
        log.info("code:{},state:{}", authingToken.getToken(), authingToken.getState());
        // 登录成功，返回登录结果
        authentication.setAuthenticated(true);

        // 设置初始化参数
        AuthenticationClientOptions clientOptions = new AuthenticationClientOptions();
        clientOptions.setAppId(authing.getAppId()); // Authing 应用 ID
        clientOptions.setAppSecret(authing.getAppSecret()); // Authing 应用密钥
        clientOptions.setAppHost(authing.getAppHost()); // Authing 应用域名，如 https://example.authing.cn。注意：Host
        // 地址为示例样式，不同版本用户池的应用 Host 地址形式有所差异，实际地址以 自建应用->应用配置->认证配置 下 `认证地址 `字段为准。
        clientOptions.setRedirectUri(authing.getRedirectUrl()); // Authing 应用配置的登录回调地址
        // 初始化 AuthenticationClient
        AuthenticationClient authenticationClient;
        try {
            authenticationClient = new AuthenticationClient(clientOptions);
        } catch (IOException | ParseException e) {
            throw new AuthenticationCredentialsNotFoundException("Authing配置错误");
        }
        try {
            OIDCTokenResponse accessTokenByCode =
                    authenticationClient.getAccessTokenByCode(((AuthingToken) authentication).getToken());
            ((AuthingToken) authentication).setResponse(accessTokenByCode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return AuthingToken.class.isAssignableFrom(authentication);
    }
}
