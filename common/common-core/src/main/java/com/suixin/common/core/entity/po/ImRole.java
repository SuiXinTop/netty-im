package com.suixin.common.core.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * @TableName im_role
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImRole implements Serializable {

    /**
     * 自增主键
     */
    private Integer roleId;

    /**
     * 角色key
     */
    private String roleKey;

    /**
     * 角色名
     */
    private String roleName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}