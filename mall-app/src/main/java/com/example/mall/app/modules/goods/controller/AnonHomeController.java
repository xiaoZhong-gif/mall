package com.example.mall.app.modules.goods.controller;


import com.example.mall.app.common.result.R;
import com.example.mall.app.service.CacheOperationService;
import com.google.code.kaptcha.Producer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/anonHome")
@Slf4j
@Api(tags = "AnonHomeController")
public class AnonHomeController {


    @Autowired
    CacheOperationService cacheOperationService;

    @Autowired
    Producer producer;

    @GetMapping("/captcha")
    @ApiOperation("生成图片认证码")
    public ResponseEntity<byte[]> captcha(@RequestParam String uuid) throws Exception {
        if (uuid.length() != 36) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        //生成图片
        String code = producer.createText();
        byte[] imageByte = null;
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            BufferedImage bufferedImage = producer.createImage(code);
            ImageIO.write(bufferedImage, "jpg", out);
            imageByte = out.toByteArray();
        }

        //保存Redis
        cacheOperationService.saveCaptchaCode(uuid, code);

        //
        HttpHeaders headers = new HttpHeaders();
        headers.setCacheControl(CacheControl.noCache());
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(imageByte, headers, HttpStatus.OK);
    }
}
