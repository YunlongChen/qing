package cn.chenyunlong.qing.domain.auth.admin;

import cn.chenyunlong.common.annotation.FieldDesc;
import cn.chenyunlong.common.constants.ValidStatus;
import cn.chenyunlong.jpa.support.BaseJpaAggregate;
import cn.chenyunlong.jpa.support.converter.ValidStatusConverter;
import cn.hutool.core.util.IdUtil;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@ToString
@Entity
@Table(name = "admin_account")
@Data
public class AdminAccount extends BaseJpaAggregate {

    @FieldDesc(name = "手机号")
    @NotBlank(message = "手机号不能为空")
    private String phone;

    @FieldDesc(name = "密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @FieldDesc(name = "用户名")
    private String username;

    private String uid;

    private String realName;

    @FieldDesc(name = "部门ID")
    private Long departmentId;

    @FieldDesc(name = "额外信息")
    @Column(columnDefinition = "text")
    private String extInfo;

    @Convert(converter = ValidStatusConverter.class)
    private ValidStatus validStatus;

    /**
     * 初始化方法，在创建聚合根时调用
     */
    public void init() {
        setValidStatus(ValidStatus.VALID);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        setPassword(encoder.encode(getPassword()));
        setUid(IdUtil.randomUUID().replaceAll("-", ""));
    }

    public void valid() {
        setValidStatus(ValidStatus.VALID);
    }

    public void invalid() {
        setValidStatus(ValidStatus.INVALID);
    }
}
