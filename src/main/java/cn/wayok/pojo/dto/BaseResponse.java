package cn.wayok.pojo.dto;

import cn.wayok.common.ReturnCode;
import cn.wayok.common.ReturnMsg;
import cn.wayok.exception.NotFoundException;
import cn.wayok.exception.ServerException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author caojingwei
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {

    private int code;
    private String msg;
    private String details;
    private T data;

    /**
     * 返回一个未找到异常
     * @param t
     */
    public static <T extends BaseResponse> BaseResponse error(NotFoundException t) {

        return BaseResponse.builder()
            .code(t.getCode())
            .msg(t.getMsg())
            .details(t.getDetails())
            .build();
    }

    /**
     * 返回一个未知异常
     */
    public static <T extends Throwable> BaseResponse unknowError(T t) {
        ServerException e = ServerException.unknownError(t);

        return BaseResponse.builder()
            .code(e.getCode())
            .msg(e.getMsg())
            .details(e.getDetails())
            .build();
    }

    /**
     * 返回一个正确的结果
     */
    public static <T> BaseResponse ok(T t) {
        return BaseResponse.builder()
            .code(ReturnCode.OK)
            .data(t)
            .build();
    }

}
