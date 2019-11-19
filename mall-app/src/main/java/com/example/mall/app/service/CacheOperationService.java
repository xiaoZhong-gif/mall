package com.example.mall.app.service;

public interface CacheOperationService {
    //token
    public void saveUserToken(String userId, String openId, String token);

    //判断token
    public boolean hasToken(String openId);

    //图形验证码
    public void saveCaptchaCode(String uuid, String code);

    /**
     * 是否存在图形认证码,只能对比一次
     */
    public boolean existsCaptchaCode(String uuid, String code);

}
