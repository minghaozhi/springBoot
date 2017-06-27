package com.springboot.jpaDemo.com.springboot.jpaDemo.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/6/27.
 */
@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:config/source.properties")
public class BeanConfig {

    @Autowired
    private Environment env;


    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setDriverClassName(env.getProperty("source.driverClassName").trim());
        druidDataSource.setUrl(env.getProperty("source.url").trim());
        druidDataSource.setUsername(env.getProperty("source.username").trim());
        druidDataSource.setPassword(env.getProperty("source.password").trim());
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
}