package com.suixin.common.core.exception.user;

/**
 * 用户锁定异常类
 * 
 * @author ruoyi
 */
public class UserBlockedException extends UserException {
    private static final long serialVersionUID = 1L;

    public UserBlockedException() {
        super("账户锁定，请稍后再试");
    }
}
