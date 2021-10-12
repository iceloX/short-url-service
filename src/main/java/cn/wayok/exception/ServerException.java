package cn.wayok.exception;

import cn.wayok.common.ReturnCode;
import cn.wayok.common.ReturnMsg;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author icelo
 * @date 2021/10/4
 */
@Getter
@Setter
public class ServerException extends BaseExcepiton {

    public ServerException(int code, String msg) {
        super(code, msg);
    }

    public ServerException(int code, Throwable e, String msg) {
        super(code, e, msg);
    }

    public static ServerException unknownError(Throwable e) {
        return new ServerException(ReturnCode.SERVER_ERROR, e, ReturnMsg.SERVER_ERROR);
    }

    public static ServerException serverException(Throwable cause) {
        return new ServerException(ReturnCode.SERVER_ERROR, ReturnMsg.SERVER_ERROR);
    }
}
