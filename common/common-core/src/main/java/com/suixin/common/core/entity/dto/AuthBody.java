package com.suixin.common.core.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthBody {

    Integer userId;

    String password;

}
