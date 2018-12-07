package com.springboot;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.springboot.dao")
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
	}
}