package chenyunlong.zhangli.core.domain;

import chenyunlong.zhangli.utils.StringUtils;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Base entity.
 *
 * @author Stan
 * @date 2021/05/22
 */
@Data
public class BaseEntity {

    /**
     * Create time.
     */
    private LocalDateTime createTime;

    /**
     * Update time.
     */
    private LocalDateTime updateTime;

    /**
     * 搜索值
     */
    private String searchValue;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 备注
     */
    private String remark;

    public BaseEntity() {
    }


    /**
     * 数据检查
     */
    public void preCheck() {
        if (createBy == null) {
            createTime = LocalDateTime.now();
        }
        if (updateTime == null) {
            updateTime = LocalDateTime.now();
        }
        if (StringUtils.isEmpty(searchValue)) {
            searchValue = "";
        }
        if (StringUtils.isEmpty(createBy)) {
            createBy = "system";
        }
        if (StringUtils.isEmpty(updateBy)) {
            updateBy = "";
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BaseEntity;
    }

}
