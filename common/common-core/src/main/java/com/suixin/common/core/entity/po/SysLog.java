package com.suixin.common.core.entity.po;

import com.suixin.common.core.enmu.BusinessState;
import com.suixin.common.core.enmu.BusinessType;
import com.suixin.common.core.enmu.OperatorType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class SysLog implements Serializable {

    /** 操作模块 */
    private String title;

    /** 业务类型 */
    private BusinessType businessType;

    /** 请求方式 */
    private String requestMethod;

    /**
     * 用户uuid
     */
    private Integer uuid;

    /** 操作人员 */
    private String operaName;

    /** 操作类别（0其它 1后台用户 2一般用户） */
    private OperatorType operatorType;

    /** 请求url */
    private String operaUrl;

    /** 操作地址 */
    private String operaIp;

    /** 操作状态（0正常 1异常） */
    private BusinessState operaStatus;

    /** 操作时间 */
    private String operaTime;

}
