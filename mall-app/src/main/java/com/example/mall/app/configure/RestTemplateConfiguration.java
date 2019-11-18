package com.example.mall.app.configure;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    /**
     * @param restTemplateBuilder
     * @return
     */
    @Bean
    public RestTemplate restTemplate(ObjectProvider<RestTemplateBuilder> restTemplateBuilder) {
        RestTemplateBuilder builder = restTemplateBuilder.getIfUnique();
        return builder.build();
    }

}
