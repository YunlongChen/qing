/*
 * Copyright (c) 2019-2023  YunLong Chen
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

package cn.chenyunlong.qing.infrastructure.security.filter;

import cn.chenyunlong.qing.infrastructure.config.properties.QingProperties;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author Stan
 */
public class MyAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {
    private final Logger logger = LoggerFactory.getLogger(MyAuthenticationProcessingFilter.class);
    private static final String TOKEN = "Authorization";


    public MyAuthenticationProcessingFilter(QingProperties qingProperties) {
        super(new AntPathRequestMatcher("/login", "POST"));
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException {
        //TODO 完善认证过程
        UsernamePasswordAuthenticationToken authRequest;
        authRequest = new UsernamePasswordAuthenticationToken("", "", null);
        return this.getAuthenticationManager().authenticate(authRequest);
    }


}
