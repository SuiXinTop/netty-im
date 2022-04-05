package com.suixin.common.core.enmu;

public enum MsgType {

    SINGLE(1, "私聊消息"),
    GROUP(2, "群聊消息");

    private final int type;
    private final String content;

    MsgType(int type, String content){
        this.type = type;
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

}
