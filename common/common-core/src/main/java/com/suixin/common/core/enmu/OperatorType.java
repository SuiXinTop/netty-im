package com.suixin.common.core.enmu;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;


/**
 * 操作人类别
 * 
 */
@Getter
public enum OperatorType {

    OTHER(0,"其他"),
    MANAGE(1,"后台用户"),
    USER(2,"手机端用户");

    @EnumValue
    private final int type;
    private final String content;

    OperatorType(int type, String content) {
        this.type = type;
        this.content = content;
    }

}
