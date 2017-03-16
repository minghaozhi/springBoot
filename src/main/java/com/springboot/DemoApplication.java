package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *使用@SpringBootApplication指定这是一个spring boot 的应用程序
 */
@SpringBootApplication
public class DemoApplication {
	/**
	 * 在main方法中启动应用程序
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
