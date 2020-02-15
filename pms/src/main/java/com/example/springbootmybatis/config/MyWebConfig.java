package com.example.springbootmybatis.config;


import com.example.springbootmybatis.component.MyLocalResolver;
import com.example.springbootmybatis.interceptor.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration

public class MyWebConfig implements WebMvcConfigurer {

    //注册拦截器
    @Autowired
    LoginHandlerInterceptor loginHandlerInterceptor;

    //视图映射
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){

        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {

                registry.addViewController("/").setViewName("login");
                registry.addViewController("/dashboard").setViewName("dashboard");
                registry.addViewController("/changePassword").setViewName("changePsw");
                registry.addViewController("/homePage").setViewName("homePage");
            }
        };
        return webMvcConfigurer;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/","/loginPage","/asserts/**","/webjars/**","/memInfo","/homePage");

    }
}
