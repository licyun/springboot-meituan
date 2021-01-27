package com.licyun.meituan.food.config;

import com.licyun.meituan.food.handle.LoginInterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webResourceConfig implements WebMvcConfigurer {

    /**
     * 配置静态资源的映射
     * @param register
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry register){
        register.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        register.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/");
    }



    /**
     * 对管理页面进行拦截
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/admin/**")          //拦截管理页面
                .excludePathPatterns("/admin/exit"); //排除退出页面
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("forward:index.html");
    }
}
