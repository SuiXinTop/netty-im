package com.suixin.common.core.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @TableName group_msg
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupMsg extends ImMsg implements Serializable {

    /**
     * 群id
     */
    private Integer groupId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}