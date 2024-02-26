package cn.chenyunlong.qing.domain.zan.service;

import cn.chenyunlong.qing.domain.zan.LikeModel;
import org.springframework.plugin.core.Plugin;

/**
 * 短信插件
 */
public interface LikePlugin extends Plugin<LikeModel> {

    /**
     * 发送短信
     *
     * @param phone 手机号
     * @param content 短信内容
     */
    void sendSms(String phone, String content);

    @Override
    boolean supports(LikeModel likeModel);
}
