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

// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.codegen.test.domain.updater.gen.updater;

import cn.chenyunlong.codegen.test.domain.updater.TestUpdaterObject;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Optional;

@Schema
@Data
public class TestUpdaterObjectUpdater {
    @Schema(
            title = "username",
            description = "用户名"
    )
    private String username;

    @Schema(
            title = "password",
            description = "用户名"
    )
    private String password;

    private Long id;

    public void updateTestUpdaterObject(TestUpdaterObject param) {
        Optional.ofNullable(getUsername()).ifPresent(param::setUsername);
        Optional.ofNullable(getPassword()).ifPresent(param::setPassword);
    }
}
