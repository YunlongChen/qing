// ---Auto Generated by Project Qing ---
package cn.chenyunlong.qing.domain.activity.request;

import cn.chenyunlong.common.model.Request;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema
public class ActivityQueryRequest implements Request {

    private String activityId;
    private String username;
    private String activityName;
    private String activityContent;
    private String attachmentAddress;
    private Integer attachmentType;
    private Integer publishState;
}
