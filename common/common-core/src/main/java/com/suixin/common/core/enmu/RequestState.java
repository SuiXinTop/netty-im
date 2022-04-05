package com.suixin.common.core.enmu;


public enum RequestState {

    NO_PASS(0, "未通过"),
    PASS(1, "通过"),
    IGNORE(2,"未处理");

    public final int type;
    public final String msg;

    RequestState(int type, String msg) {
        this.type = type;
        this.msg = msg;
    }

    public int getType() {
        return type;
    }

    public static String getMsgByType(int type) {
        for (RequestState requestState : RequestState.values()) {
            if (requestState.getType() == type) {
                return requestState.msg;
            }
        }
        return null;
    }

}
