package com.suixin.common.core.entity.bo;

import com.suixin.common.core.entity.dto.TransMsg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BindTransMsg extends TransMsg implements Serializable {

    private String userId;

}
