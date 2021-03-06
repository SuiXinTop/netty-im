package com.suixin.common.core.enmu;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 操作状态
 *
 */
@Getter
public enum BusinessState {

    FAIL(0,"失败"),

    SUCCESS(1,"成功");

    @EnumValue
    private final int status;
    private final String content;

    BusinessState(int status, String content) {
        this.status = status;
        this.content = content;
    }

}
