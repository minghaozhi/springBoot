package com.springboot;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConverter;

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

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {

		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {

				ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
				ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
				ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");

				container.addErrorPages(error401Page, error404Page, error500Page);
			}
		};
	}
}
