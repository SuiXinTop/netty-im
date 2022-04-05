package com.suixin.common.core.enmu;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 业务操作类型
 */
@Getter
public enum BusinessType {

    OTHER(0,"其它"),
    INSERT(1,"新增"),
    UPDATE(2,"修改"),
    DELETE(3,"删除"),
    LOGIN(4,"登录"),
    LOGOUT(5,"退出"),
    GRANT(6,"授权"),
    EXPORT(7,"导出"),
    IMPORT(8,"导入");

    @EnumValue
    private final int type;
    private final String content;

    BusinessType(int type,String content){
        this.type = type;
        this.content = content;
    }

}
