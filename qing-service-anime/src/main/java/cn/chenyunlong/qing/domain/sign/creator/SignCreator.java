// ---Auto Generated by Qing-Generator ---
package cn.chenyunlong.qing.domain.sign.creator;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema
@Data
public class SignCreator {
    @Schema(
            title = "UserId"
    )
    private Long userId;

    @Schema(
            title = "DateMonth"
    )
    private Long dateMonth;

    @Schema(
            title = "Mask"
    )
    private Integer mask;

    @Schema(
            title = "ContinueSignMonth"
    )
    private Integer continueSignMonth;
}
