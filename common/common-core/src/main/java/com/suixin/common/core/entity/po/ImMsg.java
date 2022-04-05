package com.suixin.common.core.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ImMsg implements Serializable {

    /**
     * 发送者id
     */
    private Integer senderId;

    /**
     * 消息类型
     */
    private Integer msgType;

    /**
     * 消息内容
     */
    private String msgContent;

    /**
     * 消息创建时间
     */
    private Date createTime;

}
