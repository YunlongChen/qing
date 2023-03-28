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

package cn.chenyunlong.nat.tools;

import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * html标签过滤工具
 * </p>
 *
 * @author wangmin1994@qq.com
 * @since 2019-06-27 15:10:22
 */
public class EscapeTools {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(EscapeTools.class);

    /**
     * 过滤所有字段
     *
     * @param object
     * @author wangmin1994@qq.com
     * @since 2019-06-27 15:08:35
     */
    public static void escapeHtml4All(Object object) {
        escapeHtml4IgnoreSet(object, null);
    }

    /**
     * 过滤html标签，指定字段
     *
     * @param object
     * @param names
     * @author wangmin1994@qq.com
     * @since 2019-06-27 14:45:09
     */
    public static void escapeHtml4Aggregation(Object object, Object... names) {
        for (Object name : names) {
            escapeHtml4One(object, name);
        }
    }

    /**
     * 忽略指定字段
     *
     * @param object
     * @param names
     * @author wangmin1994@qq.com
     * @since 2019-06-27 15:08:54
     */
    public static void escapeHtml4Ignore(Object object, Object... names) {
        Set<Object> nameSet = new HashSet<>();
        nameSet.addAll(Arrays.asList(names));
        escapeHtml4IgnoreSet(object, nameSet);
    }

    /**
     * 忽略执行字段set方式
     *
     * @param object
     * @param nameSet
     * @author wangmin1994@qq.com
     * @since 2019-06-27 15:09:07
     */
    public static void escapeHtml4IgnoreSet(Object object, Set<Object> nameSet) {
        if (object instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) object;
            Set<?> keySet = map.keySet();
            for (Object key : keySet) {
                if (nameSet != null && nameSet.contains(key)) {
                    continue;
                }
                escapeHtml4One(object, key);
            }
        } else {
            Class<?> clazz = object.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (nameSet != null && nameSet.contains(field.getName())) {
                    continue;
                }
                escapeHtml4One(object, field.getName());
            }
        }
    }

    /**
     * 处理过滤指定字段
     *
     * @param object
     * @param name
     * @author wangmin1994@qq.com
     * @since 2019-06-27 15:09:17
     */
    public static void escapeHtml4One(Object object, Object name) {
        if (object == null || name == null) {
            return;
        }
        try {
            if (object instanceof Map) {
                Class<?> clazz = object.getClass();
                Method getMethod = clazz.getMethod("get", Object.class);
                Object value = getMethod.invoke(object, name);
                if (value instanceof String) {
                    value = StringEscapeUtils.escapeHtml4((String) value);
                    Method putMethod = clazz.getMethod("put", Object.class, Object.class);
                    putMethod.invoke(object, name, value);
                }
            } else {
                if (!(name instanceof String)) {
                    return;
                }
                Class<?> clazz = object.getClass();
                Field field = clazz.getDeclaredField((String) name);
                field.setAccessible(true);
                Object value = field.get(object);
                if (value instanceof String) {
                    value = StringEscapeUtils.escapeHtml4((String) value);
                    field.set(object, value);
                }
            }
        } catch (Exception e) {
            log.error("field escape error", e);
        }
    }
}
