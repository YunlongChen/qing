package stan.zhangli.natcross.common.model.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.slf4j.Logger;
import stan.zhangli.natcross.common.model.model.enumeration.ResultEnum;

import java.lang.reflect.Field;


/**
 * <p>
 * 常规类型的前后端返回model
 * </p>
 *
 * @author wangmin1994@qq.com
 * @since 2019-03-28 10:45:41
 */
@Data
@EqualsAndHashCode
public class ResultModel {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ResultModel.class);

    public static ResultModel of(String retCode, String retMsg, Object object) {
        return new ResultModel(retCode, retMsg, object);
    }

    public static ResultModel of(ResultEnum resultEnum, Object data) {
        return new ResultModel(resultEnum.getCode(), resultEnum.getName(), data);
    }

    public static ResultModel of(ResultEnum resultEnum) {
        return new ResultModel(resultEnum.getCode(), resultEnum.getName(), null);
    }

    public static ResultModel ofFail(Object data) {
        return new ResultModel(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getName(), data);
    }

    public static ResultModel ofFail() {
        return new ResultModel(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getName(), null);
    }

    public static ResultModel ofSuccess(Object data) {
        return new ResultModel(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getName(), data);
    }

    public static ResultModel ofSuccess() {
        return new ResultModel(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getName(), null);
    }

    private String retCod;
    private String retMsg;
    private Object data;

    private ResultModel(String retCode, String retMsg, Object object) {
        this.retCod = retCode;
        this.retMsg = retMsg;
        this.data = object;
    }

    /**
     * 反射方式修改值
     *
     * @param fieldStr 参数名称
     * @param object   对象
     * @return 响应结果
     * @author wangmin1994@qq.com
     * @since 2019-05-10 14:04:48
     */
    public ResultModel set(String fieldStr, Object object) {
        Field field;
        try {
            field = this.getClass().getDeclaredField(fieldStr);
        } catch (NoSuchFieldException | SecurityException e) {
            log.warn("ResultModel get field faild!", e);
            return this;
        }

        field.setAccessible(true);
        try {
            field.set(this, object);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            log.warn("ResultModel set field faild!", e);
            return this;
        }

        return this;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ResultModel;
    }

}
