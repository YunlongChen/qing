package chenyunlong.zhangli.natcross.server;

import chenyunlong.zhangli.natcross.entity.ListenPort;
import chenyunlong.zhangli.natcross.enumeration.PortTypeEnum;
import chenyunlong.zhangli.natcross.model.CertModel;
import chenyunlong.zhangli.natcross.model.SecretModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import person.pluto.natcross2.serverside.listen.ListenServerControl;
import person.pluto.natcross2.serverside.listen.config.IListenServerConfig;
import person.pluto.natcross2.serverside.listen.config.SecretSimpleListenServerConfig;
import person.pluto.natcross2.serverside.listen.config.SimpleListenServerConfig;
import person.pluto.natcross2.serverside.listen.serversocket.ICreateServerSocket;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.security.KeyStore;

/**
 * <p>
 * 内网穿透综合服务类
 * </p>
 *
 * @author Pluto
 * @since 2020-01-10 09:50:07
 */
@Service
public class NatcrossServer {

    @Autowired
    private SecretModel secret;

    @Autowired
    private CertModel certModel;

    /**
     * 获取https监听端口
     *
     * @param sslKeyStorePath
     * @param sslKeyStorePassword
     * @return
     * @author Pluto
     * @since 2020-01-10 11:59:33
     */
    private ICreateServerSocket newHTTPsCreateServerSocket(String sslKeyStorePath, String sslKeyStorePassword) {
        return new ICreateServerSocket() {
            @Override
            public ServerSocket createServerSocket(int listenPort) throws Exception {
                try (FileInputStream sslKeyStoreFile = new FileInputStream(sslKeyStorePath)) {
                    KeyStore kstore = KeyStore.getInstance("PKCS12");
                    kstore.load(sslKeyStoreFile, sslKeyStorePassword.toCharArray());
                    KeyManagerFactory keyFactory = KeyManagerFactory.getInstance("sunx509");
                    keyFactory.init(kstore, sslKeyStorePassword.toCharArray());

                    SSLContext ctx = SSLContext.getInstance("TLSv1.2");
                    ctx.init(keyFactory.getKeyManagers(), null, null);

                    SSLServerSocketFactory serverSocketFactory = ctx.getServerSocketFactory();

                    return serverSocketFactory.createServerSocket(listenPort);
                }
            }
        };
    }

    /**
     * 创建新的监听
     *
     * @param listenPortModel
     * @return
     * @author Pluto
     * @since 2020-01-10 10:09:24
     */
    public boolean createNewListen(ListenPort listenPortModel) {
        SimpleListenServerConfig config;

        if (secret.isValid()) {
            SecretSimpleListenServerConfig secretConfig = new SecretSimpleListenServerConfig(
                    listenPortModel.getListenPort());
            secretConfig.setBaseAesKey(secret.getAeskey());
            secretConfig.setTokenKey(secret.getTokenKey());

            config = secretConfig;
        } else {
            SimpleListenServerConfig simpleConfig = new SimpleListenServerConfig(listenPortModel.getListenPort());
            config = simpleConfig;
        }

        if (PortTypeEnum.HTTPS.equals(listenPortModel.getPortTypeEnum())) {
            String sslKeyStoreFileName;
            String sslKeyStorePassword;

            if (StringUtils.isAnyBlank(listenPortModel.getCertPath(), listenPortModel.getCertPassword())) {
                sslKeyStoreFileName = certModel.getDefaultCertName();
                sslKeyStorePassword = certModel.getDefaultCertPassword();
            } else {
                sslKeyStoreFileName = listenPortModel.getCertPath();
                sslKeyStorePassword = listenPortModel.getCertPassword();
            }

            config.setCreateServerSocket(this.newHTTPsCreateServerSocket(certModel.formatCertPath(sslKeyStoreFileName),
                    sslKeyStorePassword));
        }

        return ListenServerControl.createNewListenServer(config) != null;
    }

    /**
     * 创建新的监听
     *
     * @param listenPort
     * @return
     * @author Pluto
     * @since 2020-01-10 10:09:37
     */
    public boolean createNewListen(int listenPort) {
        IListenServerConfig config;

        if (secret.isValid()) {
            SecretSimpleListenServerConfig secretConfig = new SecretSimpleListenServerConfig(listenPort);
            secretConfig.setBaseAesKey(secret.getAeskey());
            secretConfig.setTokenKey(secret.getTokenKey());

            config = secretConfig;
        } else {
            SimpleListenServerConfig simpleConfig = new SimpleListenServerConfig(listenPort);
            config = simpleConfig;
        }

        return ListenServerControl.createNewListenServer(config) != null;
    }

    /**
     * 移除某个监听
     *
     * @param listenPort
     * @return
     * @author Pluto
     * @since 2020-01-10 10:10:52
     */
    public boolean removeListen(int listenPort) {
        return ListenServerControl.remove(listenPort);
    }

}
