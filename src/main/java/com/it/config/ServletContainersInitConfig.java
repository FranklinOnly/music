package com.it.config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.MultipartConfig;


public class ServletContainersInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*
    加载Spring配置类中的信息，
    初始化Spring容器
   */
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }
    /*
    加载Spring MVC配置类中的信息，
    初始化Spring MVC容器
     */
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }
    //配置DispatcherServlet的映射路径
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


    //设置文件上传中的MultipartFile核心配置
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        //设置允许上传的单个文件大小 10M
        long maxFileSize = 10 * 1024 * 1024;
        //设置允许上传的总文件大小 20M
        long maxRequestSize = 20 * 1024 * 1024;
        //设置文件上传阈值
        int fileSizeThreshold = 0;
        registration.setMultipartConfig(
                new MultipartConfigElement(null, maxFileSize, maxRequestSize, fileSizeThreshold));
    }

}
