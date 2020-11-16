package stan.zhangli.natcross.model;

import lombok.*;

import java.io.File;

/**
 * <p>
 * 证书配置模型
 * </p>
 *
 * @author Pluto
 * @since 2020-01-10 11:45:28
 */
@Data
public class CertModel {

    /**
     * 证书存放基础路径
     */
    private String basePath;
    /**
     * 默认证书名（支持相对路径）
     */
    private String defaultCertName;
    /**
     * 默认证书密码（明文）
     */
    private String defaultCertPassword;

    public CertModel() {
    }

    public String formatCertPath(String certName) {
        return this.basePath + File.separator + certName;
    }

    public String formatDefaultCertPath() {
        return this.formatCertPath(this.defaultCertName);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CertModel;
    }

}
