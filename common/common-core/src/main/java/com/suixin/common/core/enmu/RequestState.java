package com.suixin.common.core.enmu;


import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;


@Getter
public enum RequestState {

    NO_PASS(0, "未通过"),
    PASS(1, "通过"),
    IGNORE(2,"未处理");

    @EnumValue
    public final int type;
    public final String content;

    RequestState(int type, String content) {
        this.type = type;
        this.content = content;
    }

    public static String getMsgByType(int type) {
        for (RequestState requestState : RequestState.values()) {
            if (requestState.getType() == type) {
                return requestState.content;
            }
        }
        return null;
    }

}
