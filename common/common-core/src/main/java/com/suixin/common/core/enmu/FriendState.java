package com.suixin.common.core.enmu;


import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum FriendState {

    SUCCESS(0, "OK"),
    USER_NOT_EXIST(1, "无此用户..."),
    NOT_YOURSELF(2, "不能添加你自己..."),
    ALREADY_FRIENDS(3, "该用户已经是你的好友...");

    @EnumValue
    public final int state;
    public final String msg;

    FriendState(int state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public static String getMsgByKey(int state) {
        for (FriendState type : FriendState.values()) {
            if (type.getState() == state) {
                return type.msg;
            }
        }
        return null;
    }

}
