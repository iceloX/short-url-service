package cn.wayok.exception;

import cn.wayok.pojo.dto.BaseResponse;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 全局异常处理类 Global exception handling class
 * 用于拦截处理所有控制器全局性的异常。 Used to intercept all controller global exceptions
 *
 * @author icelo
 **/

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    /**
     * 404类型异常
     */
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    ResponseEntity handleNotFoundException(HttpServletRequest req, NotFoundException e) {
        LOGGER.error("Not found exception", e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(BaseResponse.error(e));
    }

    /**
     * 兜底的异常处理
     */
    @ExceptionHandler(Exception.class)
    ResponseEntity handleServerException(HttpServletRequest req, Exception e) {
        LOGGER.error("unknown error:", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(BaseResponse.unknowError(e));
    }

    /**
     * 404 没有匹配到 controller 异常
     */
    @Override
    protected ResponseEntity handleNoHandlerFoundException(NoHandlerFoundException ex,
        HttpHeaders headers, HttpStatus status, WebRequest request) {
        LOGGER.error("unknow exception", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(BaseResponse.unknowError(ex));
    }
}
