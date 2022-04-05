package com.suixin.common.core.constant;

import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;

import java.nio.charset.StandardCharsets;

public class TokenConstant {

    public final static String ACCESS_TOKEN_PREFIX = "access_token:";

    /**
     * 令牌过期时间 hour
     */
    public final static int ACCESS_TOKEN_EXPIRE = 12;

    public final static String REFRESH_TOKEN_PREFIX = "refresh_token:";

    public final static String ACCESS_TOKEN_KEY = "access_key";

    public final static JWTSigner ACCESS_SIGNER = JWTSignerUtil.hs256(ACCESS_TOKEN_KEY.getBytes(StandardCharsets.UTF_8));
    /**
     * 令牌有效期 month
     */
    public final static int REFRESH_TOKEN_EXPIRE = 1;

    public final static String REFRESH_TOKEN_KEY = "refresh_key";

    public final static JWTSigner REFRESH_SIGNER = JWTSignerUtil.hs256(REFRESH_TOKEN_KEY.getBytes(StandardCharsets.UTF_8));

    public final static String PAYLOAD_KEY = "user_info";
}
