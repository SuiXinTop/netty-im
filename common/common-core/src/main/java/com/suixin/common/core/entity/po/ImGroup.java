package com.suixin.common.core.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName im_group
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImGroup implements Serializable {

    /**
     * 自增主键
     */
    private Integer groupId;

    /**
     * 群uuid
     */
    private String uuid;

    /**
     * 群名称
     */
    private String groupName;

    /**
     * 群信息
     */
    private String groupInfo;

    /**
     * 群状态（封禁/正常）
     */
    private Integer groupState;

    /**
     * 是否删除
     */
    private String deleteFlag;

    /**
     * 群创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

}