package com.example.mall.app.configure;

import com.example.mall.app.modules.admin.token.TokenFilter;
import org.springframework.boot.web.servlet.DelegatingFilterProxyRegistrationBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.filter.OrderedFilter;
import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.filter.DelegatingFilterProxy;

import java.util.Arrays;

/**
 * Filter配置
 */
@Configuration
public class FilterConfiguration {

    /**
     *
     */
    public static final int FILTER_DEFAULT_ORDER = OrderedFilter.REQUEST_WRAPPER_FILTER_MAX_ORDER + 100;


    /**
     * 跨域资源共享过滤器,较早过滤
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.addAllowedOrigin("*");
        source.registerCorsConfiguration("/**", config);

        //
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(OrderedRequestContextFilter.REQUEST_WRAPPER_FILTER_MAX_ORDER - 105 + 1);
        return bean;
    }

    /**
     * @return
     */
    @Bean
    public TokenFilter tokenFilter() {
        TokenFilter tokenFilter = new TokenFilter();
        return tokenFilter;
    }

    /**
     * 前置判断
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean<DelegatingFilterProxy> tokenFilterRegistrationBean() {
        FilterRegistrationBean<DelegatingFilterProxy> registration = new FilterRegistrationBean<>();
        registration.setFilter(new DelegatingFilterProxy("tokenFilter"));
        registration.setName("tokenFilter");
        registration.addUrlPatterns("/admin/*");
        registration.setOrder(FILTER_DEFAULT_ORDER + 102);
        return registration;
    }

    /**
     * shiro授权
     *
     * @return
     */
    @Bean
    public DelegatingFilterProxyRegistrationBean shiroFilterRegistration() {
        DelegatingFilterProxyRegistrationBean bean = new DelegatingFilterProxyRegistrationBean("shiroFilter", new ServletRegistrationBean[0]);
        bean.setOrder(FILTER_DEFAULT_ORDER + 1000);
        bean.setUrlPatterns(Arrays.asList("/*"));
        bean.addInitParameter("targetFilterLifecycle", "true");
        return bean;
    }

}
