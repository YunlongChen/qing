package cn.chenyunlong.qing.domain.auth.admin.dto.request;

import cn.chenyunlong.common.model.Request;
import lombok.Data;

import java.util.List;

@Data
public class UserRolesRequest implements Request {

    private Long accountId;

    private List<Long> roleIds;
}
