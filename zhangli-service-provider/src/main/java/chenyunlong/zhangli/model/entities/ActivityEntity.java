package chenyunlong.zhangli.model.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Stan
 */
@Data
@TableName("activity")
public class ActivityEntity {
    private String activityId;
    private String username;
    private String activityName;
    private String activityContent;
    private String attachmentAddress;
    private Integer attachmentType;
    private Attachment attachement;
    private Date createTime;
    private Date modifyTime;
    private Integer publishState;
}
