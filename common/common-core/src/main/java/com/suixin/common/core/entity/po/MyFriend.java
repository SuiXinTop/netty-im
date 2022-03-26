package com.suixin.common.core.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName my_friend
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyFriend implements Serializable {
    /**
     * 自增主键
     */
    private Integer friendId;

    /**
     * 用户1id
     */
    private Integer firstUserId;

    /**
     * 用户2id
     */
    private Integer secondUserId;

    /**
     * 添加时间
     */
    private Date createTime;

    /**
     * 是否删除
     */
    private Integer deleteFlag;

    private static final long serialVersionUID = 1L;

}