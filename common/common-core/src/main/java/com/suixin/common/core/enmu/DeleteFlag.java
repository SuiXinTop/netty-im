package com.suixin.common.core.enmu;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum DeleteFlag {

    undelete(0, "正常"),
    delete(1, "删除");

    @EnumValue
    private final int flag;
    private final String content;

    DeleteFlag(int flag, String content) {
        this.flag = flag;
        this.content = content;
    }

}
