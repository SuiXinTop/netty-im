package com.suixin.common.core.entity.po;

import com.suixin.common.core.entity.dto.TransMsg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName im_msg
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ImMsg extends TransMsg implements Serializable {
    /**
     * 自增主键
     */
    private Integer msgId;

    /**
     * 发送者
     */
    private Integer senderId;

    /**
     * 接收者
     */
    private Integer receiverId;

    /**
     * 消息类型
     */
    private Integer msgType;

    /**
     * 消息内容
     */
    private String msgContent;

    /**
     * 发送时间
     */
    private Date createTime;

    /**
     * 是否签收（0/1）
     */
    private Integer signFlag;

    private static final long serialVersionUID = 1L;

}