// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.sign.vo;

import cn.chenyunlong.common.model.AbstractBaseJpaVO;
import cn.chenyunlong.qing.domain.sign.Sign;
import io.swagger.v3.oas.annotations.media.Schema;

import java.lang.Integer;
import java.lang.Long;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Schema
@Data
@EqualsAndHashCode(
        callSuper = true
)
@NoArgsConstructor(
        access = AccessLevel.PROTECTED
)
public class SignVO extends AbstractBaseJpaVO {
    @Schema(
            title = "userId"
    )
    private Long userId;

    @Schema(
            title = "dateMonth"
    )
    private Long dateMonth;

    @Schema(
            title = "mask"
    )
    private Integer mask;

    @Schema(
            title = "continueSignMonth"
    )
    private Integer continueSignMonth;

    public SignVO(Sign source) {
        super();
        this.setUserId(source.getUserId());
        this.setDateMonth(source.getDateMonth());
        this.setMask(source.getMask());
        this.setContinueSignMonth(source.getContinueSignMonth());
    }
}
