package cn.wayok.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常类型，支持国际化
 *
 * <p>
 *
 * @author caojingwei
 */
@Getter
@Setter
public class BaseExcepiton extends RuntimeException {

    /**
     * 返回的错误码
     */
    protected int code;

    /**
     * 错误的栈信息
     */
    protected String details;

    /**
     * 错误类型
     */
    protected String msg;


    public BaseExcepiton(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseExcepiton(int code, Throwable e, String msg) {
        this(code, msg);
        this.details =
            e.getMessage() == null ? e.toString() : e.getMessage();
    }
}
