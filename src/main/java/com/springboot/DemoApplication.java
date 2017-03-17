package com.springboot;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 *使用@SpringBootApplication指定这是一个spring boot 的应用程序
 */
@SpringBootApplication
public class DemoApplication {
/**
 * 使用@Bean注入httpMessageConverters
 */
     @Bean
	 public HttpMessageConverters fastJsonHttpMessageConverters(){
		 //定义一个convert转换消息的对象
		 FastJsonHttpMessageConverter fastJsonHttpMessageConverter=new FastJsonHttpMessageConverter();
		 //添加fastJson的配置信息
		 FastJsonConfig fastJsonConfig=new FastJsonConfig();
		 fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		 //把配置信息添加到convert
		 fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
		 HttpMessageConverter<?> converter=fastJsonHttpMessageConverter;
		 return  new HttpMessageConverters(converter);
	 }



	/**
	 * 在main方法中启动应用程序
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
