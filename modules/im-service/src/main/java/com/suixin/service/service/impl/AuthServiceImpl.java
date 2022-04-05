package com.suixin.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.suixin.common.core.enmu.DeleteFlag;
import com.suixin.common.core.enmu.StateType;
import com.suixin.common.core.entity.dto.AuthBody;
import com.suixin.common.core.entity.dto.RegisterBody;
import com.suixin.common.core.entity.dto.RestMsg;
import com.suixin.common.core.entity.po.ImUser;
import com.suixin.common.core.exception.user.UserBlockedException;
import com.suixin.common.core.exception.user.UserDeleteException;
import com.suixin.common.core.exception.user.UserNotExistsException;
import com.suixin.common.core.exception.user.UserPasswordNotMatchException;
import com.suixin.common.core.util.TokenUtil;
import com.suixin.service.mapper.UserMapper;
import com.suixin.service.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Objects;

@Component
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public RestMsg<String> register(RegisterBody registerBody) {
        return null;
    }

    @Override
    public RestMsg<HashMap<String, String>> login(AuthBody authBody) {
        LambdaQueryWrapper<ImUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ImUser::getUserId, authBody.getUserId());
        ImUser imUser = userMapper.selectOne(queryWrapper);

        if (imUser == null) {
            throw new UserNotExistsException();
        }

        if (imUser.getDeleteFlag() == DeleteFlag.delete) {
            throw new UserDeleteException();
        }

        if (imUser.getUserState() == StateType.exception) {
            throw new UserBlockedException();
        }

        if (Objects.equals(authBody.getPassword(), imUser.getPassword())) {
            return RestMsg.success(TokenUtil.createToken(imUser));
        }

        throw new UserPasswordNotMatchException();

    }

    @Override
    public RestMsg<String> logout() {
        return null;
    }

}
