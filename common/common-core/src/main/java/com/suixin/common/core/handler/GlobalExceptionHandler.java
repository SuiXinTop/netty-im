package com.suixin.common.core.handler;

import com.suixin.common.core.constant.HttpConstant;
import com.suixin.common.core.entity.dto.RestMsg;
import com.suixin.common.core.exception.ForbiddenException;
import com.suixin.common.core.exception.ServiceException;
import com.suixin.common.core.exception.UnauthorizedException;
import com.suixin.common.core.exception.user.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * The type Global exception handler.
 *
 * @author STARS
 * @创建者 SuiXinTop
 * @创建时间 2021 -11-07
 * @描述
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 请求方式不支持
     *
     * @param e the e
     * @return the rest msg
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public RestMsg<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e) {
        return RestMsg.fail("请求方式不支持");
    }

    /**
     * 参数校验异常
     *
     * @param e the e
     * @return rest msg
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RestMsg<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        //打印校验住的所有的错误信息
        StringBuilder msg = new StringBuilder("参数错误：[");
        List<ObjectError> list = e.getAllErrors();
        for (ObjectError item : list) {
            msg.append(item.getDefaultMessage()).append(',');
        }
        msg.deleteCharAt(msg.length() - 1);
        msg.append(']');
        return RestMsg.fail(msg.toString());
    }

    /**
     * Handle 未登录异常
     *
     * @param e the e
     * @return the rest msg
     */
    @ExceptionHandler(UnauthorizedException.class)
    public RestMsg<Object> handleUnauthorizedException(UnauthorizedException e) {
        return RestMsg.fail(HttpConstant.UNAUTHORIZED, e.getMessage(), null);
    }


    /**
     * Handle 权限不足异常
     *
     * @param e the e
     * @return the rest msg
     */
    @ExceptionHandler(ForbiddenException.class)
    public RestMsg<Object> handleForbiddenException(ForbiddenException e) {
        return RestMsg.fail(HttpConstant.FORBIDDEN, e.getMessage(), null);
    }

    /**
     * 用户异常
     *
     * @param e the e
     * @return the rest msg
     */
    @ExceptionHandler(UserException.class)
    public RestMsg<Object> handleUserException(UserException e) {
        return RestMsg.fail(e.getMessage());
    }

    /**
     * 业务
     *
     * @param e the e
     * @return the rest msg
     */
    @ExceptionHandler(ServiceException.class)
    public RestMsg<Object> handleServiceException(ServiceException e) {
        return RestMsg.fail(e.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     *
     * @param e the e
     * @return the rest msg
     */
    @ExceptionHandler(RuntimeException.class)
    public RestMsg<Object> handleRuntimeException(RuntimeException e) {
        return RestMsg.fail(e.getMessage());
    }


    /**
     * 系统异常
     *
     * @param e the e
     * @return the rest msg
     */
    @ExceptionHandler(Exception.class)
    public RestMsg<Object> handleException(Exception e) {
        return RestMsg.fail(e.getMessage());
    }
}
