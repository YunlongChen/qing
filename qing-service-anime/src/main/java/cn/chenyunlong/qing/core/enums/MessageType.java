/*
 * Copyright (c) 2019-2022 YunLong Chen
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

package cn.chenyunlong.qing.core.enums;

/**
 * @author Stan
 */

public enum MessageType implements ValueEnum<Integer> {

    /**
     * 普通消息
     */
    SIMPLE_MESSAGE(0),
    /**
     * 带图片的消息
     */
    MESSAGE_WITH_IMG(1);


    private String typeName;

    private final Integer value;

    MessageType(int i) {
        this.value = i;
    }

    /**
     * Gets enum value.
     *
     * @return enum value
     */
    @Override
    public Integer getValue() {
        return value;
    }
}
