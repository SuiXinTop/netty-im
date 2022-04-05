package com.suixin.common.core.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName group_user
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupUser implements Serializable {
    /**
     * 自增主键
     */
    private Integer relationId;

    /**
     * 群号id
     */
    private Integer groupId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 群内身份 （普通/管理/群主）
     */
    private Integer groupRole;

    /**
     * 入群时间
     */
    private Date createDate;

    /**
     * 是否退出
     */
    private Integer deleteFlag;

    private static final long serialVersionUID = 1L;

}