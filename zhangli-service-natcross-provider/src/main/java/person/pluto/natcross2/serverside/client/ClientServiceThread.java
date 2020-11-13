package person.pluto.natcross2.serverside.client;

import lombok.extern.slf4j.Slf4j;
import person.pluto.natcross2.serverside.client.config.IClientServiceConfig;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

/**
 * <p>
 * 客户端服务进程
 * </p>
 *
 * @author Pluto
 * @since 2019-07-05 10:53:33
 */
@Slf4j
public final class ClientServiceThread implements Runnable {

    private Thread myThread = null;

    private boolean isAlive = false;
    private ServerSocket listenServerSocket;

    private IClientServiceConfig<?, ?> config;

    private ExecutorService procExecutorService;

    public ClientServiceThread(IClientServiceConfig<?, ?> config) {
        this.config = config;
    }

    @Override
    public void run() {
        while (isAlive) {
            try {
                Socket listenSocket = listenServerSocket.accept();
                procMethod(listenSocket);
            } catch (Exception e) {
                log.warn("客户端服务进程 轮询等待出现异常", e);
            }
        }
    }

    /**
     * 处理客户端发来的消息
     *
     * @param listenSocket
     * @author Pluto
     * @since 2020-01-03 14:46:36
     */
    public void procMethod(Socket listenSocket) {
        procExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    config.getClientServiceAdapter().procMethod(listenSocket);
                } catch (Exception e) {
                    log.error("处理socket异常", e);
                    try {
                        listenSocket.close();
                    } catch (IOException sce) {
                        log.warn("处理新socket时报错，并关闭socket异常", e);
                    }
                }
            }
        });
    }

    /**
     * 启动
     *
     * @author Pluto
     * @since 2020-01-03 14:05:59
     */
    public void start() throws Exception {
        log.info("client service [{}] starting ...", this.config.getListenPort());
        this.isAlive = true;
        if (myThread == null || !myThread.isAlive()) {
            myThread = new Thread(this);
            myThread.setName("client-server-" + this.formatInfo());

            try {
                // 启动时配置，若启动失败则执行cancell并再次抛出异常让上级处理
                listenServerSocket = new ServerSocket(config.getListenPort());
                procExecutorService = config.newProcExecutorService();
            } catch (Exception e) {
                log.error("create client ServerSocket[{}] faild!", config.getListenPort());
                this.cancell();
                throw e;
            }

            myThread.start();
            log.info("client service [{}] start success", this.config.getListenPort());
        } else {
            log.warn("client service [{}] is started", this.config.getListenPort());
        }
    }

    /**
     * 退出
     *
     * @author Pluto
     * @since 2019-07-18 18:32:03
     */
    public void cancell() {
        log.info("client service [{}] will cancell", this.config.getListenPort());

        isAlive = false;

        if (listenServerSocket != null) {
            try {
                listenServerSocket.close();
                listenServerSocket = null;
            } catch (IOException e) {
                log.warn("监听端口关闭异常", e);
            }
        }

        procExecutorService.shutdownNow();

        if (myThread != null) {
            myThread.interrupt();
            myThread = null;
        }

        log.info("client service [{}] cancell success", this.config.getListenPort());
    }

    /**
     * 获取监听端口
     *
     * @return
     * @author Pluto
     * @since 2019-07-18 18:32:40
     */
    public Integer getListenPort() {
        return this.config.getListenPort();
    }

    /**
     * 格式化为短小的可识别信息
     *
     * @return
     * @author Pluto
     * @since 2020-04-15 14:17:41
     */
    public String formatInfo() {
        return String.valueOf(this.getListenPort());
    }

}
