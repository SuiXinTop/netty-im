package com.suixin.common.core.enmu;


public enum MsgSignFlag {

    unsigned(0, "未签收"),
    signed(1, "已签收");

    public final int type;
    public final String content;

    MsgSignFlag(int type, String content) {
        this.type = type;
        this.content = content;
    }

    public int getType() {
        return type;
    }
}
