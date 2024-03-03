package cn.chenyunlong.security.enums;

import lombok.Getter;

public enum AuthProvider {


    /**
     * 微信登录
     */
    WECHAT("wechat"),
    /**
     * QQ登录
     */
    QQ("qq"),
    /**
     * Github登录
     */
    GITHUB("github"),
    /**
     * google 登录
     */
    GOOGLE("google"),

    AUTHING("authing");


    @Getter
    private final String providerId;

    AuthProvider(String providerId) {
        this.providerId = providerId;
    }
}
