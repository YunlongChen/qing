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

package cn.chenyunlong.codegen.processor.updater;

import cn.chenyunlong.codegen.annotation.GenUpdater;
import cn.chenyunlong.codegen.annotation.IgnoreUpdater;
import cn.chenyunlong.codegen.annotation.SupportedGenTypes;
import cn.chenyunlong.codegen.processor.AbstractCodeGenProcessor;
import cn.chenyunlong.codegen.util.StringUtils;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

/**
 * 更新一代处理器
 *
 * @author Gim
 * @date 2019/11/28 19:33
 */

@SupportedGenTypes(types = GenUpdater.class)
public class GenUpdaterProcessor extends AbstractCodeGenProcessor {

    public static final String SUFFIX = "Updater";

    /**
     * 生成类
     *
     * @param typeElement      类型元素
     * @param roundEnvironment 周围环境
     * @param useLombok        使用lombok
     */
    @Override
    public void generateClass(TypeElement typeElement, RoundEnvironment roundEnvironment, boolean useLombok) {

        Set<VariableElement> variableElements =
                findFields(typeElement, element -> Objects.isNull(element.getAnnotation(IgnoreUpdater.class)));
        String sourceClassName = typeElement.getSimpleName() + SUFFIX;
        TypeSpec.Builder builder =
                TypeSpec.classBuilder(sourceClassName).addModifiers(Modifier.PUBLIC).addAnnotation(Schema.class);

        if (useLombok) {
            builder.addAnnotation(Data.class);
        }

        addSetterAndGetterMethod(builder, variableElements, useLombok);
        CodeBlock.Builder codeBlockBuilder = CodeBlock.builder();
        for (VariableElement variableElement : variableElements) {
            codeBlockBuilder.addStatement("$T.ofNullable($L()).ifPresent(param::$L)", Optional.class, StringUtils.getterName(variableElement
                    .getSimpleName()
                    .toString()), StringUtils.setterName(variableElement.getSimpleName().toString()));
        }
        MethodSpec.Builder methodBuilder;
        methodBuilder = MethodSpec
                .methodBuilder("update" + typeElement.getSimpleName())
                .addModifiers(Modifier.PUBLIC)
                .addParameter(TypeName.get(typeElement.asType()), "param")
                .addCode(codeBlockBuilder.build())
                .returns(void.class);
        builder.addMethod(methodBuilder.build());

        addIdField(builder, useLombok);
        genJavaSourceFile(typeElement, builder);
    }

    /**
     * 获取子包名称
     *
     * @param typeElement 类型元素
     * @return 生成的文件package
     */
    @Override
    public String getSubPackageName(TypeElement typeElement) {
        return "updater";
    }

}
