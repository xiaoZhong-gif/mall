package com.example.mall.app.configure;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;


/**
 * 生成验证码配置
 */
@Configuration
public class KaptchaConfiguration {

    @Bean
    public Producer producer() {
        Properties properties = new Properties();
        properties.put(Constants.KAPTCHA_BORDER, "no");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "13,13,13");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "4");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, "5");
        properties.put(Constants.KAPTCHA_IMAGE_WIDTH, "120");
        properties.put(Constants.KAPTCHA_IMAGE_HEIGHT, "40");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "30");
        properties.put(Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING, "0123456789");
        properties.put(Constants.KAPTCHA_OBSCURIFICATOR_IMPL, "com.google.code.kaptcha.impl.ShadowGimpy");
        Config config = new Config(properties);
        return config.getProducerImpl();
    }

}
