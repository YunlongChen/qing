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

package cn.chenyunlong.qing.domain.third.wechat.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 微信消息
 *
 * @author Stan
 * @since 2022/11/26
 */
@Slf4j
@Service
public class WeChatMessageService {
    //构建一个队列
    private static final Map<String, Long> messages = new ConcurrentHashMap<>();

    /**
     * 查看消息是否重复了
     *
     * @param signature 消息签名
     * @return 消息是否重复
     */
    public boolean isDuplicated(String signature) {

        boolean isDuplicated = messages.containsKey(signature);
        log.debug("是否被处理：" + isDuplicated);
        if (!isDuplicated) {
            messages.put(signature, System.currentTimeMillis());
        }

        Long currentMills = System.currentTimeMillis();

        for (String key : messages.keySet()) {
            Long aLong = messages.get(key);
            if (currentMills - aLong > 10000) {
                messages.remove(key);
            }
        }
        return isDuplicated;
    }
}
