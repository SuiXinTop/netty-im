package com.suixin.common.core.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName im_group
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImGroup implements Serializable {

    /**
     * 群uuid
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String groupId;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}