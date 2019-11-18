package com.example.mall.app.service;

public interface CacheOperationService {

    public void saveUserToken(String userId, String openId, String token);

    public boolean hasToken(String openId);


}
