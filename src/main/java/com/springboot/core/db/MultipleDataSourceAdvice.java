package com.springboot.core.db;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * 多数据源切面逻辑
 * @description
 * @author cjx
 * @date 2018年5月24日
 */
public class MultipleDataSourceAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		DataSourceContextHolder.clearDataSourceType();
	}
	
	/**
	 * 配置切换数据源逻辑
	 */
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		/**
		 * 下面方式在service处使用@DataSourceType(name=DataSourceType.DATASOURCE_B)注解切换数据源
		 *
		 */
		if (target.getClass().isAnnotationPresent(DataSource.class)) {
			DataSource datasource = target.getClass().getAnnotation(DataSource.class);
			DataSourceContextHolder.setDataSourceType(datasource.name());
		} else {
			DataSourceContextHolder.setDataSourceType(DataSource.DATASOURCE_A);
		}
		
		/**
		 * 使用临时方法：直接切换
		 */
//		DataSourceContextHolder.setDataSourceType(DataSourceType.DATASOURCE_B);
		
	}
}
