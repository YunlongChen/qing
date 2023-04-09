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

package cn.chenyunlong.codegen.processor.service;


import cn.chenyunlong.codegen.annotation.GenServiceImpl;
import cn.chenyunlong.codegen.annotation.SupportedGenTypes;
import cn.chenyunlong.codegen.processor.BaseCodeGenProcessor;
import cn.chenyunlong.codegen.processor.DefaultNameContext;
import cn.chenyunlong.codegen.processor.mapper.GenMapperProcessor;
import cn.chenyunlong.codegen.util.StringUtils;
import cn.chenyunlong.common.constants.CodeEnum;
import cn.chenyunlong.common.exception.BusinessException;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.jpa.support.EntityOperations;
import cn.chenyunlong.jpa.support.domain.BaseEntity;
import com.google.common.base.CaseFormat;
import com.squareup.javapoet.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author gim 获取名称时可以先获取上下文再取，不用一个个的取，这样更方便
 */
@SupportedGenTypes(types = GenServiceImpl.class)
public class GenServiceImplProcessor extends BaseCodeGenProcessor {

    public static final String IMPL_SUFFIX = "ServiceImpl";

    @Override
    public void generateClass(TypeElement typeElement, RoundEnvironment roundEnvironment, boolean useLombok) {
        DefaultNameContext nameContext = getNameContext(typeElement);
        String className = typeElement.getSimpleName() + IMPL_SUFFIX;
        TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder(className)
                .addSuperinterface(ClassName.get(nameContext.getServicePackageName(),
                        nameContext.getServiceClassName()))
                .addAnnotation(Transactional.class)
                .addAnnotation(Service.class)
                .addAnnotation(Slf4j.class)
                .addAnnotation(RequiredArgsConstructor.class)
                .addModifiers(Modifier.PUBLIC);
        if (StringUtils.containsNull(nameContext.getRepositoryPackageName())) {
            return;
        }
        String repositoryFieldName;
        repositoryFieldName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, nameContext.getRepositoryClassName());
        String classFieldName;
        classFieldName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, typeElement.getSimpleName().toString());
        FieldSpec repositoryField;
        repositoryField = FieldSpec
                .builder(ClassName.get(nameContext.getRepositoryPackageName(),
                        nameContext.getRepositoryClassName()), repositoryFieldName)
                .addModifiers(Modifier.PRIVATE, Modifier.FINAL)
                .build();
        typeSpecBuilder.addField(repositoryField);
        createMethod(typeElement, nameContext, repositoryFieldName, classFieldName).ifPresent(typeSpecBuilder::addMethod);
        Optional<MethodSpec> updateMethod = updateMethod(typeElement, nameContext, repositoryFieldName);
        updateMethod.ifPresent(typeSpecBuilder::addMethod);
        validMethod(typeElement, repositoryFieldName).ifPresent(typeSpecBuilder::addMethod);
        invalidMethod(typeElement, repositoryFieldName).ifPresent(typeSpecBuilder::addMethod);
        findByIdMethod(typeElement, nameContext, repositoryFieldName, classFieldName).ifPresent(typeSpecBuilder::addMethod);
        findByPageMethod(typeElement, nameContext, repositoryFieldName).ifPresent(typeSpecBuilder::addMethod);
        String implPackageName = nameContext.getImplPackageName();
        GenServiceImpl annotation = typeElement.getAnnotation(GenServiceImpl.class);
        genJavaSourceFile(implPackageName, annotation.sourcePath(), typeSpecBuilder, annotation.overrideSource());
    }

    @Override
    public String generatePackage(TypeElement typeElement) {
        return typeElement.getAnnotation(GenServiceImpl.class).pkgName();
    }

    /**
     * 创建方法
     *
     * @param typeElement         类型元素，当前的Domain领域对象
     * @param nameContext         名称上下文，上下文信息
     * @param repositoryFieldName 存储库字段名称，JP啊Repository对象字段名称
     * @param classFieldName      类字段名称，作为参数的Class信息，默认：typeElement.getSimpleName().toString()
     * @return {@link Optional}<{@link MethodSpec}>
     */
    private Optional<MethodSpec> createMethod(TypeElement typeElement, DefaultNameContext nameContext,
                                              String repositoryFieldName, String classFieldName) {
        String creatorPackageName = nameContext.getCreatorPackageName();
        String creatorClassName = nameContext.getCreatorClassName();
        boolean containsNull = StringUtils.containsNull(creatorPackageName,
                nameContext.getMapperPackageName());
        if (!containsNull) {
            return Optional.of(MethodSpec.methodBuilder("create" + typeElement.getSimpleName())
                    .addParameter(
                            ClassName.get(creatorPackageName, creatorClassName),
                            "creator")
                    .addModifiers(Modifier.PUBLIC)
                    .addCode(
                            CodeBlock.of(
                                    """
                                            Optional<$T> $L = $T.doCreate($L)
                                            .create(() -> $T.INSTANCE.dtoToEntity(creator))
                                            .update($T::init)
                                            .execute();
                                            """,
                                    typeElement,
                                    classFieldName,
                                    EntityOperations.class,
                                    repositoryFieldName,
                                    ClassName.get(nameContext.getMapperPackageName(),
                                            typeElement.getSimpleName() + GenMapperProcessor.SUFFIX),
                                    typeElement
                            )
                    )
                    .addCode(
                            CodeBlock.of("return $L.isPresent() ? $L.get().getId() : 0;", classFieldName,
                                    classFieldName)
                    )
                    .addJavadoc("createImpl")
                    .addAnnotation(Override.class)
                    .returns(Long.class).build());
        }
        return Optional.empty();
    }

    private Optional<MethodSpec> updateMethod(TypeElement typeElement, DefaultNameContext nameContext,
                                              String repositoryFieldName) {
        boolean containsNull = StringUtils.containsNull(nameContext.getUpdaterPackageName());
        if (!containsNull) {
            return Optional.of(MethodSpec.methodBuilder("update" + typeElement.getSimpleName())
                    .addParameter(
                            ClassName.get(nameContext.getUpdaterPackageName(), nameContext.getUpdaterClassName()),
                            "updater")
                    .addModifiers(Modifier.PUBLIC)
                    .addCode(
                            CodeBlock.of("""
                                            $T.doUpdate($L)
                                            .loadById(updater.getId())
                                            .update(updater::update$L)
                                            .execute();""",
                                    EntityOperations.class, repositoryFieldName, typeElement.getSimpleName())
                    )
                    .addJavadoc("update")
                    .addAnnotation(Override.class)
                    .build());
        }
        return Optional.empty();
    }

    private Optional<MethodSpec> validMethod(TypeElement typeElement, String repositoryFieldName) {
        return Optional.of(MethodSpec.methodBuilder("valid" + typeElement.getSimpleName())
                .addParameter(Long.class, "id")
                .addModifiers(Modifier.PUBLIC)
                .addCode(
                        CodeBlock.of("""
                                        $T.doUpdate($L)
                                        .loadById(id)
                                        .update($T::valid)
                                        .execute();""",
                                EntityOperations.class, repositoryFieldName, BaseEntity.class)
                )
                .addJavadoc("valid")
                .addAnnotation(Override.class)
                .build());
    }

    private Optional<MethodSpec> invalidMethod(TypeElement typeElement, String repositoryFieldName) {
        return Optional.of(MethodSpec.methodBuilder("invalid" + typeElement.getSimpleName())
                .addParameter(Long.class, "id")
                .addModifiers(Modifier.PUBLIC)
                .addCode(
                        CodeBlock.of("""
                                        $T.doUpdate($L)
                                        .loadById(id)
                                        .update($T::invalid)
                                        .execute();""",
                                EntityOperations.class, repositoryFieldName, BaseEntity.class)
                )
                .addJavadoc("invalid")
                .addAnnotation(Override.class)
                .build());
    }

    private Optional<MethodSpec> findByIdMethod(TypeElement typeElement,
                                                DefaultNameContext nameContext, String repositoryFieldName,
                                                String classFieldName) {
        boolean containsNull = StringUtils.containsNull(nameContext.getVoPackageName());
        if (!containsNull) {
            return Optional.of(MethodSpec.methodBuilder("findById")
                    .addParameter(Long.class, "id")
                    .addModifiers(Modifier.PUBLIC)
                    .addCode(
                            CodeBlock.of("$T $L =  $L.findById(id);\n",
                                    ParameterizedTypeName.get(ClassName.get(Optional.class),
                                            ClassName.get(typeElement)), classFieldName, repositoryFieldName)
                    ).addCode(
                            CodeBlock.of("return new $T($L.orElseThrow(() -> new $T($T.NotFindError)));",
                                    ClassName.get(nameContext.getVoPackageName(), nameContext.getVoClassName()),
                                    classFieldName,
                                    BusinessException.class, CodeEnum.class)
                    )
                    .addJavadoc("findById")
                    .addAnnotation(Override.class)
                    .returns(ClassName.get(nameContext.getVoPackageName(), nameContext.getVoClassName()))
                    .build());
        }
        return Optional.empty();
    }

    private static ClassName getBooleanBuilder() {
        return ClassName.get("com.querydsl.core", "BooleanBuilder");
    }

    private Optional<MethodSpec> findByPageMethod(TypeElement typeElement,
                                                  DefaultNameContext nameContext, String repositoryFieldName) {
        boolean containsNull = StringUtils.containsNull(nameContext.getQueryPackageName(),
                nameContext.getVoPackageName());
        if (!containsNull) {
            MethodSpec methodSpec = MethodSpec.methodBuilder("findByPage")
                    .addParameter(ParameterizedTypeName.get(ClassName.get(PageRequestWrapper.class),
                                    ClassName.get(nameContext.getQueryPackageName(), nameContext.getQueryClassName())),
                            "query")
                    .addModifiers(Modifier.PUBLIC)
                    .addCode(
                            CodeBlock.of("$T booleanBuilder = new $T();\n", getBooleanBuilder(), getBooleanBuilder())
                    )
                    .addCode(
                            CodeBlock.of("""
                                            $T<$T> page = $L.findAll(booleanBuilder,
                                                    $T.of(query.getPage() - 1, query.getPageSize(), $T.by(
                                                        $T.DESC, "createdAt")));
                                            """, Page.class, typeElement,
                                    repositoryFieldName,
                                    PageRequest.class, Sort.class, Direction.class)
                    )
                    .addCode(
                            CodeBlock.of(
                                    """
                                            return new $T<>(page.getContent()
                                            .stream().map($T::new)
                                            .collect($T.toList()), page.getPageable(), page.getTotalElements());
                                            """,
                                    PageImpl.class,
                                    ClassName.get(nameContext.getVoPackageName(), nameContext.getVoClassName()),
                                    Collectors.class)
                    )
                    .addJavadoc("findByPage")
                    .addAnnotation(Override.class)
                    .returns(ParameterizedTypeName.get(ClassName.get(Page.class),
                            ClassName.get(nameContext.getVoPackageName(), nameContext.getVoClassName())))
                    .build();
            return Optional.of(methodSpec);
        }
        return Optional.empty();
    }

}
