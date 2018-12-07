package com.springboot.core.db;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**
 * 根据durid官网配置多个数据源
 * @description
 * @author cjx
 * @date 2018年5月25日
 */
@Configuration
public class MultipleDataSourceConfig {
	
	@Bean(destroyMethod = "close", name = com.springboot.core.db.DataSource.DATASOURCE_A)
	@ConfigurationProperties("spring.datasource.druid.one")
	public DataSource dataSourceOne(){
		return DruidDataSourceBuilder.create().build();
	}
	
	@Bean(destroyMethod = "close", name = com.springboot.core.db.DataSource.DATASOURCE_B)
	@ConfigurationProperties("spring.datasource.druid.two")
	public DataSource dataSourceTwo(){
		return DruidDataSourceBuilder.create().build();
	}
}
