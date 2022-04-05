package com.suixin.common.core.enmu;


import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum StateType {

    exception(0, "异常"),
    normal(1, "正常");

    @EnumValue
    private final int state;
    private final String content;

    StateType(int state, String content) {
        this.state = state;
        this.content = content;
    }

}
