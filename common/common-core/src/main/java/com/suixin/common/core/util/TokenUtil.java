package com.suixin.common.core.util;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson.JSON;
import com.suixin.common.core.constant.TokenConstant;
import com.suixin.common.core.entity.po.ImUser;

import java.util.HashMap;

public class TokenUtil {

    public static HashMap<String, String> createToken(ImUser imUser) {
        return new HashMap<String, String>(3) {
            {
                put(TokenConstant.ACCESS_TOKEN_KEY, creatAccessToken(imUser));
                put(TokenConstant.REFRESH_TOKEN_KEY, creatRefreshToken(imUser));
                put(TokenConstant.PAYLOAD_KEY, JSON.toJSONString(imUser));
            }
        };
    }

    public static String creatAccessToken(ImUser imUser) {
        return JWT.create()
                .setPayload(TokenConstant.PAYLOAD_KEY, imUser)
                .setSigner(TokenConstant.ACCESS_SIGNER)
                .setExpiresAt(DateUtil.offsetHour(new DateTime(), TokenConstant.ACCESS_TOKEN_EXPIRE))
                .sign();
    }

    public static String creatRefreshToken(ImUser imUser) {
        return JWT.create()
                .setPayload(TokenConstant.PAYLOAD_KEY, imUser)
                .setSigner(TokenConstant.REFRESH_SIGNER)
                .setExpiresAt(DateUtil.offsetMonth(new DateTime(), TokenConstant.REFRESH_TOKEN_EXPIRE))
                .sign();
    }

    public static boolean validAccessToken(String token) {
        return JWTUtil.verify(token, TokenConstant.ACCESS_SIGNER);
    }

    public static boolean validRefreshToken(String token) {
        return JWTUtil.verify(token, TokenConstant.REFRESH_SIGNER);
    }

    /**
     * @param token String
     * @return ImUser
     * @apiNote 确保token正确
     */
    public static ImUser getTokenInfo(String token) {
        return (ImUser) JWTUtil.parseToken(token).getPayload(TokenConstant.PAYLOAD_KEY);
    }

}
