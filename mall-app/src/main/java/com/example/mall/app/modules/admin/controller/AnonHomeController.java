package com.example.mall.app.modules.admin.controller;


import com.example.mall.app.common.result.R;
import com.example.mall.app.service.CacheOperationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@Slf4j
@Api(tags = "AnonHomeController")
public class AnonHomeController {


    @Autowired
    CacheOperationService cacheOperationService;

    @PostMapping("/test")
    @ApiOperation("测试")
    public R retrievePassword() {

        return R.ok("sssssss");
    }
}
