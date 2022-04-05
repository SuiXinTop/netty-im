package com.suixin.common.core.enmu;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum GenderType {

    FEMALE(0, "女"),
    MALE(1, "男"),
    HIDE(2, "隐藏");

    @EnumValue
    private final int type;
    private final String content;

    GenderType(int type, String content) {
        this.type = type;
        this.content = content;
    }

}
