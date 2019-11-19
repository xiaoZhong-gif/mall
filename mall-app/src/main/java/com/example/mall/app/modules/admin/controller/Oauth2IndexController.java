package com.example.mall.app.modules.admin.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.mall.app.common.constant.TokenConstant;
import com.example.mall.app.common.result.R;
import com.example.mall.app.entity.Admin;
import com.example.mall.app.entity.User;
import com.example.mall.app.modules.admin.form.LoginForm;
import com.example.mall.app.service.AdminService;
import com.example.mall.app.service.CacheOperationService;
import com.example.mall.app.service.UserService;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/oauth2")
@Slf4j
@Api(tags = "Oauth2IndexController")
public class Oauth2IndexController {

    @Autowired
    CacheOperationService cacheOperationService;
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;

    @ApiOperation("管理员登录")
    @PostMapping("/login")
    public R login(@Validated @RequestBody LoginForm loginForm, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            throw new BindException(result);
        }
        Admin admin = adminService.getAdmin(loginForm.getUserName());
        if (admin == null) {
            return R.error(5100, "用户名或者密码错误");
        }
        return R.ok(saveRedisAndBuildMap(admin.getId()));
    }

    /**
     * 签名把数据返回
     *
     * @return
     */
    private Map<String, Object> saveRedisAndBuildMap(String id) {
        String userId = id;
        String tokenId = UUID.randomUUID().toString();
        Date nowTime = new Date();
        String token = JWT.create().withClaim(TokenConstant.OAUTH_TOKEN_ID, tokenId).withClaim(TokenConstant.OAUTH_USER_ID, userId)
                .withExpiresAt(DateUtils.addSeconds(nowTime, TokenConstant.OAUTH_EXPIRES_SECONDS)).sign(Algorithm.HMAC256(TokenConstant.OAUTH_SECRET));


        //保存token到redis里面
        cacheOperationService.saveUserToken(userId, tokenId, token);

        //返回给前端
        Map<String, Object> map = Maps.newHashMap();
        map.put("token", token);
        map.put("createTime", nowTime.getTime());
        map.put("expire", TokenConstant.OAUTH_EXPIRES_SECONDS);
        return map;
    }

    @PostMapping("/getUser")
    public R getUser() {
        return R.ok("sda");
    }
}
