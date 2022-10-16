package person.pluto.natcross2.serverside.listen;

import lombok.extern.slf4j.Slf4j;
import person.pluto.natcross2.api.IBelongControl;
import person.pluto.natcross2.api.socketpart.AbsSocketPart;
import person.pluto.natcross2.common.CommonFormat;
import person.pluto.natcross2.serverside.listen.clear.IClearInvalidSocketPartThread;
import person.pluto.natcross2.serverside.listen.config.IListenServerConfig;
import person.pluto.natcross2.serverside.listen.control.IControlSocket;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

/**
 * <p>
 * 监听转发服务进程
 * </p>
 *
 * @author Pluto
 * @since 2019-07-05 10:53:33
 */
@Slf4j
public final class ServerListenThread implements Runnable, IBelongControl {

    private Thread myThread = null;

    private IListenServerConfig config;

    private boolean isAlive = false;
    private ServerSocket listenServerSocket;

    private Map<String, AbsSocketPart> socketPartMap = new HashMap<>();

    private IControlSocket controlSocket;
    private IClearInvalidSocketPartThread clearInvalidSocketPartThread;

    public ServerListenThread(IListenServerConfig config) throws Exception {
        this.config = config;

        // 此处就开始占用端口，防止重复占用端口，和启动时已被占用
        listenServerSocket = this.config.createServerSocket();

        log.info("server listen port[{}] is created!", this.getListenPort());
    }

    @Override
    public void run() {
        while (isAlive) {
            try {
                Socket listenSocket = listenServerSocket.accept();

                // 如果没有控制接收socket，则取消接入，不主动关闭所有接口，防止controlSocket临时掉线，讲道理没有controlSocket也不会启动
                if (controlSocket == null) {
                    listenSocket.close();
                    continue;
                }

                String socketPartKey = CommonFormat.getSocketPartKey(this.getListenPort());

                AbsSocketPart socketPart = config.newSocketPart(this);
                socketPart.setSocketPartKey(socketPartKey);
                socketPart.setRecvSocket(listenSocket);

                socketPartMap.put(socketPartKey, socketPart);
                // 发送指令失败，同controlSocket为空，不使用异步执行，毕竟接口发送只能顺序，异步的方式也会被锁，等同同步
                if (!sendClientWait(socketPartKey)) {
                    socketPartMap.remove(socketPartKey);
                    socketPart.cancel();
                    continue;
                }
            } catch (Exception e) {
                log.warn("监听服务[" + this.getListenPort() + "]发送通知服务异常", e);
                stopListen();
            }
        }
    }

    /**
     * * 告知客户端，有新连接
     *
     * @param socketPartKey
     * @author Pluto
     * @since 2019-07-11 15:45:14
     */
    public boolean sendClientWait(String socketPartKey) {
        log.info("告知新连接 sendClientWait[{}]", socketPartKey);
        boolean sendClientWait = false;

        try {
            sendClientWait = this.controlSocket.sendClientWait(socketPartKey);
        } catch (Exception e) {
            log.error("告知新连接 sendClientWait[" + socketPartKey + "] 发生未知异常", e);
            sendClientWait = false;
        }

        if (!sendClientWait) {
            log.warn("告知新连接 sendClientWait[" + socketPartKey + "] 失败");
            if (this.controlSocket == null || !this.controlSocket.isValid()) {
                // 保证control为置空状态
                stopListen();
            }
            return false;
        }
        return true;
    }

    /**
     * * 启动
     *
     * @author Pluto
     * @since 2020-01-07 09:36:30
     */
    public void start() {
        log.info("server listen port[{}] starting ...", this.getListenPort());
        this.isAlive = true;
        if (myThread == null || !myThread.isAlive()) {

            if (this.clearInvalidSocketPartThread == null) {
                this.clearInvalidSocketPartThread = config.newClearInvalidSocketPartThread(this);
                if (this.clearInvalidSocketPartThread != null) {
                    this.clearInvalidSocketPartThread.start();
                }
            }

            myThread = new Thread(this);
            myThread.setName("server-listen-" + this.formatInfo());
            myThread.start();
        }
        log.info("server listen port[{}] is started!", this.getListenPort());

    }

    /**
     * * 关停监听服务，不注销已经建立的，并置空controlSocket
     *
     * @author Pluto
     * @since 2019-07-18 18:43:43
     */
    public void stopListen() {
        log.info("stopListen[{}]", this.getListenPort());
        isAlive = false;

        if (controlSocket != null) {
            try {
                controlSocket.close();
            } catch (Exception e) {
                log.debug("监听服务控制端口关闭异常", e);
            }
            this.controlSocket = null;
        }

        if (myThread != null) {
            myThread.interrupt();
            myThread = null;
        }
    }

    /**
     * * 退出
     *
     * @author Pluto
     * @since 2020-01-07 09:37:00
     */
    public void cancel() {
        log.info("cancelling[{}]", this.getListenPort());

        this.stopListen();

        if (listenServerSocket != null) {
            try {
                listenServerSocket.close();
            } catch (Exception e) {
                // do no thing
            }
        }

        if (this.clearInvalidSocketPartThread != null) {
            try {
                this.clearInvalidSocketPartThread.cancel();
            } catch (Exception e) {
                // do no thing
            }
            this.clearInvalidSocketPartThread = null;
        }

        Set<String> keySet = socketPartMap.keySet();
        String[] array = keySet.toArray(new String[keySet.size()]);

        for (String key : array) {
            stopSocketPart(key);
        }

        log.debug("cancel[{}] is success", this.getListenPort());
    }

    /**
     * * 停止指定的端口
     *
     * @param socketPartKey
     * @return
     * @author Pluto
     * @since 2019-07-11 16:33:10
     */
    @Override
    public boolean stopSocketPart(String socketPartKey) {
        log.debug("停止接口 stopSocketPart[{}]", socketPartKey);
        AbsSocketPart socketPart = socketPartMap.get(socketPartKey);
        if (socketPart == null) {
            return false;
        }
        socketPart.cancel();
        socketPartMap.remove(socketPartKey);
        return true;
    }

    /**
     * * 清理无效socketPart
     *
     * @author Pluto
     * @since 2019-08-21 12:50:57
     */
    public void clearInvaildSocketPart() {
        log.debug("clearInvaildSocketPart[{}]", this.getListenPort());

        Set<String> keySet = socketPartMap.keySet();
        // 被去除的时候set会变化而导致空值问题
        String[] array = keySet.toArray(new String[keySet.size()]);

        for (String key : array) {

            AbsSocketPart socketPart = socketPartMap.get(key);
            if (socketPart != null && !socketPart.isValid()) {
                stopSocketPart(key);
            }
        }
    }

    /**
     * * 将接受到的连接进行设置组合
     *
     * @param socketPartKey
     * @param sendSocket
     * @return
     */
    public boolean doSetPartClient(String socketPartKey, Socket sendSocket) {
        log.debug("接入接口 doSetPartClient[{}]", socketPartKey);
        AbsSocketPart socketPart = socketPartMap.get(socketPartKey);
        if (socketPart == null) {
            return false;
        }
        socketPart.setSendSocket(sendSocket);

        boolean createPassWay = socketPart.createPassWay();
        if (!createPassWay) {
            socketPart.cancel();
            stopSocketPart(socketPartKey);
            return false;
        }

        return true;
    }

    /**
     * * 设置控制端口
     *
     * @param controlSocket
     * @author Pluto
     * @since 2019-07-18 18:46:05
     */
    public void setControlSocket(Socket socket) {
        log.info("setControlSocket[{}]", this.getListenPort());

        IControlSocket controlSocket = this.config.newControlSocket(socket, null);

        if (this.controlSocket != null) {
            try {
                this.controlSocket.close();
            } catch (Exception e) {
                log.debug("监听服务控制端口关闭异常", e);
            }
            this.controlSocket = null;
        }

        controlSocket.setServerListen(this);
        controlSocket.startRecv();
        this.controlSocket = controlSocket;
        this.start();
    }

    /**
     * * 获取监听端口
     *
     * @return
     * @author Pluto
     * @since 2019-07-18 18:45:57
     */
    public Integer getListenPort() {
        return config.getListenPort();
    }

    /**
     * * 获取已建立的连接
     *
     * @return
     * @author Pluto
     * @since 2019-07-19 16:32:09
     */
    public List<String> getSocketPartList() {
        Set<String> keySet = this.socketPartMap.keySet();
        return Arrays.asList(keySet.toArray(new String[keySet.size()]));
    }

    /**
     * * 获取socket对
     *
     * @return
     * @author Pluto
     * @since 2020-01-07 09:43:08
     */
    public Map<String, AbsSocketPart> getSocketPartMap() {
        return this.socketPartMap;
    }

    /**
     * * 是否激活状态
     *
     * @return
     * @author Pluto
     * @since 2020-01-07 09:43:28
     */
    public Boolean isAlive() {
        return isAlive;
    }

    /**
     * 获取配置
     *
     * @return
     * @author Pluto
     * @since 2020-01-08 16:55:41
     */
    public IListenServerConfig getConfig() {
        return config;
    }

    public String formatInfo() {
        return String.valueOf(this.getListenPort());
    }

}
