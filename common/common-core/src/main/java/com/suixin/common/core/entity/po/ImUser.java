package com.suixin.common.core.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.suixin.common.core.enmu.DeleteFlag;
import com.suixin.common.core.enmu.GenderType;
import com.suixin.common.core.enmu.StateType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName im_user
 */
@Data
@NoArgsConstructor
public class ImUser implements Serializable {

    /**
     * uuid
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String userId;

    /**
     * 昵称
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别：男（1）、女（0）
     */
    private GenderType userSex;

    /**
     * 头像
     */
    private String userImage;

    /**
     * 地址
     */
    private String userAddress;

    /**
     * 二维码
     */
    private String qrCode;

    /**
     * 状态：封禁（0）、正常（1）
     */
    private StateType userState;

    /**
     * 注销标记
     */
    private DeleteFlag deleteFlag;

    /**
     * 注册时间
     */
    private Date registerTime;

    /**
     * 权限
     */
    private Integer roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}