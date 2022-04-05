package com.suixin.common.core.enmu;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum MsgType {

    SINGLE(1, "私聊消息"),
    GROUP(2, "群聊消息");

    @EnumValue
    private final int type;
    private final String content;

    MsgType(int type, String content){
        this.type = type;
        this.content = content;
    }

}
