package com.suixin.common.core.entity.dto;


import com.suixin.common.core.enmu.MsgAction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransMsg implements Serializable {

    /**
     * 推送类型
     */
    private MsgAction action;

    /**
     * 私聊/群聊
     */
    private int chatType;

    /**
     * 扩展字段
     */
    private String extend;

}
