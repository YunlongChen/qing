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

package com.only4play.jpa.support;

import cn.chenyunlong.common.exception.ValidationException;
import cn.chenyunlong.common.model.ValidateResult;
import cn.chenyunlong.common.validator.ValidateGroup;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.util.CollectionUtils.isEmpty;

/**
 * 基础实体操作
 *
 * @author gim 2022/3/5 10:07 下午
 * @date 2022/10/24
 */
public abstract class BaseEntityOperation implements EntityOperation {

    static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    /**
     * 进行验证 泛型
     *
     * @param t     t 泛型对象
     * @param group
     */
    public <T> void doValidate(T t, Class<? extends ValidateGroup> group) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t, group, Default.class);
        if (!isEmpty(constraintViolations)) {
            List<ValidateResult> results = constraintViolations.stream()
                    .map(cv -> new ValidateResult(cv.getPropertyPath().toString(), cv.getMessage()))
                    .collect(Collectors.toList());
            throw new ValidationException(results);
        }
    }
}
