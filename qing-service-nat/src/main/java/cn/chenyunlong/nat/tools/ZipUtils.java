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

package cn.chenyunlong.nat.tools;

import org.apache.commons.lang3.tuple.Pair;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * <p>
 * 压缩工具类
 * </p>
 */
public final class ZipUtils {

    private static final int BUFFER_SIZE = 4 * 1024;

    /**
     * 压缩方法zip
     *
     * @param sourcePairList 源流对（主要针对网络流环境，避免了先存目录再压缩的尬境），左键为文件名，右键为输入流
     * @param outputStream   输出流，依然可以使用网络输出流，避免先存再发
     * @throws RuntimeException 运行时异常
     */
    public static void toZip(List<Pair<String, InputStream>> sourcePairList, OutputStream outputStream) throws RuntimeException {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int len = -1;
            for (Pair<String, InputStream> sourcePair : sourcePairList) {
                InputStream sourceInputStream = sourcePair.getRight();

                zipOutputStream.putNextEntry(new ZipEntry(sourcePair.getLeft()));
                while ((len = sourceInputStream.read(buffer)) != -1) {
                    zipOutputStream.write(buffer, 0, len);
                }
                zipOutputStream.closeEntry();
                // 流已读完，在此关闭即可
                sourceInputStream.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("zip error from ZipUtils", e);
        }
    }

}
