package com.atguigu.gmall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {
    @Bean
    public CorsWebFilter corsWebFilter() {

        //cors跨域对象
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); //设置允许访问的网络
        corsConfiguration.setAllowCredentials(true); //设置是否从服务器获取 cookie
        corsConfiguration.addAllowedMethod("*"); //设置请求方法 * 表示任意
        corsConfiguration.addAllowedHeader("*"); // 所有请求头信息

        //配置元对象
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

        //cors 过滤器对象
        return new CorsWebFilter(corsConfigurationSource);
    }
}
