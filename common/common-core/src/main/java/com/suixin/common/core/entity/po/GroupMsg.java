package com.suixin.common.core.entity.po;

import com.suixin.common.core.entity.dto.TransMsg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName group_msg
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupMsg extends TransMsg implements Serializable {
    /**
     * 自增主键
     */
    private Integer msgId;

    /**
     * 发送者id
     */
    private Integer senderId;

    /**
     * 群id
     */
    private Integer groupId;

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

    private static final long serialVersionUID = 1L;

}