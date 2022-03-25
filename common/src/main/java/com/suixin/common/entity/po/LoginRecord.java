package com.suixin.common.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @TableName login_record
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRecord implements Serializable {
    /**
     * 自增时间
     */
    private Integer loginId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 登录ip
     */
    private String loginIp;

    /**
     * 登陆时间
     */
    private Date loginDate;

    private static final long serialVersionUID = 1L;

}