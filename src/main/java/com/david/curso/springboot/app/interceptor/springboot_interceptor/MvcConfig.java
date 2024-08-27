package com.david.curso.springboot.app.interceptor.springboot_interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("TimeInterceptor")
    private HandlerInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor).addPathPatterns("/app/bar", "/app/foo");
        // registry.addInterceptor(timeInterceptor).includePathPatterns("/app**");
        // con los ** todos los métodos que inicien con /app
        // registry.addInterceptor(timeInterceptor).excludePathPatterns("/app/bar",
        // "/app/foo");
    }

}
