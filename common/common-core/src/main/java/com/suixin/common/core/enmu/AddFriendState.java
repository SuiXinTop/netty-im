package com.suixin.common.core.enmu;


public enum AddFriendState {

    SUCCESS(0, "OK"),
    USER_NOT_EXIST(1, "无此用户..."),
    NOT_YOURSELF(2, "不能添加你自己..."),
    ALREADY_FRIENDS(3, "该用户已经是你的好友...");

    public final int state;
    public final String msg;

    AddFriendState(int state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public int getState() {
        return state;
    }

    public static String getMsgByKey(int state) {
        for (AddFriendState type : AddFriendState.values()) {
            if (type.getState() == state) {
                return type.msg;
            }
        }
        return null;
    }

}
