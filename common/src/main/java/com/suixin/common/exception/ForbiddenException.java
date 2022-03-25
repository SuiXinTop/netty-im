package com.suixin.common.exception;

/**
 * <p>File：ForbiddenException.java</p>
 * <p>Title: 权限不足</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2019 2019年8月8日 下午5:38:33</p>
 * <p>Company:  </p>
 *
 * @author zmr
 * @version 1.0
 */
public class ForbiddenException extends RuntimeException {

    private static final long serialVersionUID = -4552488542483342775L;

    private static final String DEFAULT_MSG = "权限不足，拒绝访问";

    public ForbiddenException(String msg) {
        super(msg);
    }

    public ForbiddenException() {
        super(DEFAULT_MSG);
    }
}
