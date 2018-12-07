package com.springboot.core.db;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * 数据源切面配置
 * @description
 * @author cjx
 * @date 2018年5月25日
 */
@Configuration
@Aspect
@Order(-1)//比事务切面先启动
public class MultipleDataSourceAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(MultipleDataSourceAspect.class);
	
	private static final String AOP_POINTCUT_EXPRESSION = "execution(* com.springboot.service.*.*Impl.*(..))";
	
	@Bean
	public MultipleDataSourceAdvice getAdvice(){
		System.out.println("==========我要创建一个对象============");
		return new MultipleDataSourceAdvice();
	}
	
	@Bean(name = "multipleDataSourceAdvisor")
	public Advisor multipleDataSourceAdvisor() {
		logger.info("===============================创建multipleDataSourceAdvisor===================================");
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
		return new DefaultPointcutAdvisor(pointcut, getAdvice());
	}
}
