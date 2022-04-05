package com.suixin.common.core.entity.po;

import com.suixin.common.core.enmu.RequestState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupRequest implements Serializable {

    /**
     * 自增主键
     */
    private Integer requestId;

    /**
     * 发送者
     */
    private Integer senderId;

    /**
     * 接收者
     */
    private Integer groupId;

    /**
     * 请求状态。0：未通过；1：通过；2：未处理
     */
    private RequestState requestState;

    /**
     * 请求创建时间
     */
    private Date requestDate;

    /**
     * 请求操作时间
     */
    private Date operateDate;

    private static final long serialVersionUID = 1L;

}
