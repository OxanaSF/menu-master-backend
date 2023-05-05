package com.menumaster.springbootlibrary.config;

import com.menumaster.springbootlibrary.services.SpoonacularService;
import com.menumaster.springbootlibrary.services.SpoonacularServiceImpl;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.menumaster.springbootlibrary.services")
public class AppConfig {

    @Bean
    public DispatcherServletPath dispatcherServletPath() {
        return () -> "/";
    }

    @Bean
    public SpoonacularService spoonacularService(RestTemplate restTemplate) {
        return new SpoonacularServiceImpl(restTemplate);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CorsFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
