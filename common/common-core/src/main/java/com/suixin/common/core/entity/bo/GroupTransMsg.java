package com.suixin.common.core.entity.bo;


import com.suixin.common.core.entity.dto.TransMsg;
import com.suixin.common.core.entity.po.GroupMsg;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupTransMsg  extends TransMsg implements Serializable {

    private GroupMsg groupMsg;

}
