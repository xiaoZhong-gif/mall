package com.example.mall.app.configure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author
 */
@ConfigurationProperties
public class SwaggerProperties {


    /**
     * 登录token
     */
    @Getter
    @Setter
    private String token;


}
