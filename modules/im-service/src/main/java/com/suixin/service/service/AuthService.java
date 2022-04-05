package com.suixin.service.service;

import com.suixin.common.core.entity.dto.AuthBody;
import com.suixin.common.core.entity.dto.RegisterBody;
import com.suixin.common.core.entity.dto.RestMsg;

import java.util.HashMap;

public interface AuthService {

    RestMsg<String> register(RegisterBody registerBody);

    RestMsg<HashMap<String, String>> login(AuthBody authBody);

    RestMsg<String> logout();

}
