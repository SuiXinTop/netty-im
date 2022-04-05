package com.suixin.common.core.enmu;

/**
 * 操作状态
 *
 */
public enum BusinessState {

    /**
     * 失败
     */
    FAIL(0,"失败"),

    /**
     * 成功
     */
    SUCCESS(1,"成功");

    private final int status;
    private final String content;

    BusinessState(int status, String content) {
        this.status = status;
        this.content = content;
    }

    public int getType() {
        return status;
    }

    public String getContent() {
        return content;
    }

}
