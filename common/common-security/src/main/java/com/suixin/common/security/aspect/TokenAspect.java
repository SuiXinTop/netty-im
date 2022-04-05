package com.suixin.common.security.aspect;

import com.suixin.common.core.constant.HttpConstant;
import com.suixin.common.core.entity.dto.RestMsg;
import com.suixin.common.core.exception.ForbiddenException;
import com.suixin.common.core.exception.UnauthorizedException;
import com.suixin.common.core.util.RequestUtil;
import com.suixin.common.core.util.TokenUtil;
import com.suixin.common.redis.service.impl.RedisServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.el.parser.Token;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author xxx
 * @create 2021-10-16
 */
@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class TokenAspect {
    private final HttpServletRequest request;

    /**
     * 定义一个切点
     */
    @Pointcut("@annotation(com.suixin.common.security.annotation.PreAuth)")
    private void advicePointcut() {
    }

    /**
     * Around增强型,可以有返回值以及修改传参
     *
     * @return the string
     */
    @Before(value = "advicePointcut()")
    public RestMsg<Object> tokenAdvice() {
        String accessToken = request.getHeader("access_token");
        if (TokenUtil.validAccessToken(accessToken)) {
            return RestMsg.success(HttpConstant.SUCCESS, "已通过", null);
        }

        String refreshToken = request.getHeader("refresh_token");
        if (TokenUtil.validRefreshToken(refreshToken)) {
            accessToken = TokenUtil.creatAccessToken(TokenUtil.getTokenInfo(refreshToken));
            return RestMsg.success(HttpConstant.ACCEPTED, "已刷新access_token", accessToken);
        }

        throw new UnauthorizedException("请重新登录");
    }

}
