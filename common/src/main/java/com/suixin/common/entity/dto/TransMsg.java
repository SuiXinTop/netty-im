package com.suixin.common.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransMsg implements Serializable {

    private int action;//动作类型

    private int chatType;

    private String extend;//扩展字段

}
