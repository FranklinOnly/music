package com.it.config;


import com.it.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;

import javax.servlet.annotation.MultipartConfig;
import java.io.IOException;


@Configuration
//等同于<context:component-scan base-package="com.it.controller"/>
@ComponentScan({"com.it.controller"})
/*@Import({MyWebMvcConfig.class})*/
@EnableWebMvc

public class SpringMvcConfig  implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/user/login");
    }


    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .maxAge(3600)
                .allowCredentials(true)
                .allowedOrigins("*")
                .allowedMethods("*")
        ;
    }
//    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/static/");
    }
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/static/");
//    }

//    @Bean(name = "multipartResolver")
//    public MultipartResolver multipartResolver() {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setMaxUploadSize(10485760); // 例如：10MB
//        return resolver;
//    }
    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver() throws IOException {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(10485760); // 例如：10MB
        resolver.setMaxUploadSizePerFile(10485760); // 例如：10MB
        resolver.setDefaultEncoding("UTF-8");
        resolver.setUploadTempDir(new FileSystemResource("/static/uploads"));
        System.out.println("..multipart.........");
        return resolver;
    }

}




