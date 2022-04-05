package com.suixin.common.core.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SingleMsg extends ImMsg implements Serializable {

    /**
     * 接收者
     */
    private String receiverId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}