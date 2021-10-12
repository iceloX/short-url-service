package cn.wayok.exception;


import cn.wayok.common.ReturnCode;
import cn.wayok.common.ReturnMsg;
import lombok.Getter;
import lombok.Setter;

/**
 * @author caojingwei
 */
@Getter
@Setter
public class NotFoundException extends BaseExcepiton {

    public NotFoundException() {
        super(ReturnCode.NOT_FOUND_ERROR, ReturnMsg.NOT_FOUND);
    }
}
