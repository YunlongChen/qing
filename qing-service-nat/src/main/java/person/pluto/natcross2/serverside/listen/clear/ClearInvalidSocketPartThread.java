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

package person.pluto.natcross2.serverside.listen.clear;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import person.pluto.natcross2.serverside.listen.ServerListenThread;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 清理无效端口
 * </p>
 *
 * @author Pluto
 * @since 2019-08-21 12:59:03
 */
@Slf4j
@NoArgsConstructor
public class ClearInvalidSocketPartThread implements IClearInvalidSocketPartThread {

    private Thread myThread = null;

    private boolean isAlive = false;

    private ServerListenThread serverListenThread;

    /**
     * 清理间隔
     */
    @Setter
    @Getter
    private Long clearIntervalSeconds = 10L;

    public ClearInvalidSocketPartThread(ServerListenThread serverListenThread) {
        this.setServerListenThread(serverListenThread);
    }

    @Override
    public void run() {
        while (isAlive) {
            serverListenThread.clearInvaildSocketPart();

            try {
                TimeUnit.SECONDS.sleep(clearIntervalSeconds);
            } catch (InterruptedException e) {
                // do no thing
            }
        }
    }

    @Override
    public void start() {
        this.isAlive = true;
        if (myThread == null || !myThread.isAlive()) {
            myThread = new Thread(this);
            myThread.setName("clear-invalid-socket-part-" + serverListenThread.formatInfo());
            myThread.start();
        }
        log.info("ClearInvalidSocketPartThread for [{}] started !", this.serverListenThread.getListenPort());
    }

    @Override
    public void cancel() {
        this.isAlive = false;
        if (myThread != null) {
            myThread.interrupt();
            myThread = null;
        }
        log.info("ClearInvalidSocketPartThread for [{}] cancell !", this.serverListenThread.getListenPort());
    }

    @Override
    public void setServerListenThread(ServerListenThread serverListenThread) {
        this.serverListenThread = serverListenThread;
    }

}
