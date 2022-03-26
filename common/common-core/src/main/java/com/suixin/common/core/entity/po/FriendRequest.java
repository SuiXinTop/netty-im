package com.suixin.common.core.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName friend_request
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendRequest implements Serializable {
    /**
     * 自增主键
     */
    private Integer requestId;

    /**
     * 发送者
     */
    private Integer senderId;

    /**
     * 接收者
     */
    private Integer receiverId;

    /**
     * 请求状态。0：未通过；1：通过；2：未处理
     */
    private Integer requestState;

    /**
     * 请求创建时间
     */
    private Date requestDate;

    /**
     * 请求操作时间
     */
    private Date operateDate;

    private static final long serialVersionUID = 1L;

}