package com.springboot.commom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan("com.springboot.controller")//controller路径
public class SwaggerConfig {
	
	@Bean
	public Docket buildDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//扫描写了了注解的
                .paths(PathSelectors.any())
                .build();
    }
	
	private ApiInfo getApiInfo(){
        return new ApiInfoBuilder()
                .title("springboot接口")
                .termsOfServiceUrl("http://www.blibao.com/home/jypay.html")
                .description("springboot接口服务")
                .contact(new Contact("springboot", "http://www.blibao.com/home/jypay.html", "hr@blibao.cn"))
                .version("1.0.0")
                .build();

    }
}
