package com.suixin.common.enmu;


public enum AttendState {

    SUCCESS(0, "OK"),
    USER_NOT_EXIST(1, "无此用户..."),
    NOT_YOURSELF(2, "不能添加你自己..."),
    ALREADY_FRIENDS(3, "该用户已经是你的好友...");

    public final int status;
    public final String msg;

    AttendState(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public static String getMsgByKey(int status) {
        for (AttendState type : AttendState.values()) {
            if (type.getStatus() == status) {
                return type.msg;
            }
        }
        return null;
    }

}
