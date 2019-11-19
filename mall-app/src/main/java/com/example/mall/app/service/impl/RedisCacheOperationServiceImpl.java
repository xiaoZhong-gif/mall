package com.example.mall.app.service.impl;

import com.example.mall.app.common.constant.TokenConstant;
import com.example.mall.app.service.CacheOperationService;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisCacheOperationServiceImpl implements CacheOperationService {

    /***
     *token的保存
     */
    private static String OAUTH2_TOKEN = "oauth2:token";
    /**
     * 图形认证码
     */
    private static String CAPTCHA_CODE = "captcha:code";

    /**
     * 用:合并
     *
     * @param key
     * @return
     */
    private static String join(String... key) {
        return StringUtils.join(key, ":");
    }

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public void saveUserToken(String userId, String tokenId, String token) {
        //保存到Redis里面
        stringRedisTemplate.opsForValue().set(join(OAUTH2_TOKEN, tokenId), token, TokenConstant.OAUTH_EXPIRES_SECONDS, TimeUnit.SECONDS);
    }

    @Override
    public boolean hasToken(String tokenId) {
        Boolean result = stringRedisTemplate.hasKey(join(OAUTH2_TOKEN, tokenId));
        return BooleanUtils.isTrue(result);
    }

    @Override
    public void saveCaptchaCode(String uuid, String code) {
        String redisKey = join(CAPTCHA_CODE, uuid);
        stringRedisTemplate.opsForValue().set(redisKey, code, 10 * 60, TimeUnit.SECONDS);
    }

    @Override
    public boolean existsCaptchaCode(String uuid, String code) {
        String redisKey = join(CAPTCHA_CODE, uuid);
        String codeRedis = stringRedisTemplate.opsForValue().get(redisKey);
        stringRedisTemplate.delete(redisKey);
        boolean result = StringUtils.isNoneEmpty(codeRedis) && codeRedis.equalsIgnoreCase(code);
        return result;
    }
}
