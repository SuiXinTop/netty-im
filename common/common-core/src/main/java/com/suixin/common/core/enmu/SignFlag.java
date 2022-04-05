package com.suixin.common.core.enmu;


public enum SignFlag {

    unsigned(0, "未签收"),
    signed(1, "已签收");

    private final int status;
    private final String content;

    SignFlag(int status, String content) {
        this.status = status;
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public String getContent() {
        return content;
    }
}
