package com.it.config;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class MyBatisConfig {

    /*
    定义MyBatis的核心连接工厂bean，
    等同于<bean class="org.mybatis.spring.SqlSessionFactoryBean">
    参数使用自动装配的形式加载dataSource，
    为set注入提供数据源，dataSource来源于JdbcConfig中的配置
    */
    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean(@Autowired DataSource dataSource) throws IOException {
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ResourcePatternResolver cfgResolver = new PathMatchingResourcePatternResolver();
        Resource[] cfgPath = cfgResolver.getResources("classpath*:mybatis-config.xml");
        ssfb.setConfigLocation(cfgPath[0]);
        //等同于<property name="dataSource" ref="dataSource"/>
        ssfb.setDataSource(dataSource);
        return ssfb;
    }
    /*
    定义MyBatis的映射扫描，
    等同于<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
     */
    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        //等同于<property name="basePackage" value="com.it.dao"/>
        msc.setBasePackage("com.it.mapper");
        return msc;
    }
}