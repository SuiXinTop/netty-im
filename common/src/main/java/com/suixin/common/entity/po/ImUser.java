package com.suixin.common.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName im_user
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImUser implements Serializable {
    /**
     * 自增主键
     */
    private Integer userId;

    /**
     * uuid
     */
    private String userUuid;

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
    private Integer userSex;

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
    private Integer userState;

    /**
     * 注销标记
     */
    private Integer deleteFlag;

    /**
     * 注册时间
     */
    private Date registerTime;

    /**
     * 权限
     */
    private Integer roleId;

    private static final long serialVersionUID = 1L;

}