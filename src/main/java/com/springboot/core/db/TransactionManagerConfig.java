package com.springboot.core.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * 事务方法切入配置
 * 
 * @author YTGHTGHS
 * @date 2018年4月12日
 * @description
 */
@Aspect
@Configuration
public class TransactionManagerConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionManagerConfig.class);

	private static final int TX_METHOD_TIMEOUT = 5;
//	private static final String AOP_POINTCUT_EXPRESSION = "(execution(* com.silverbox.shopper.service.*.impl.*Impl.*(..))) or (execution(* com.silverbox.waimai.service.*.impl.*Impl.*(..))))";
	private static final String AOP_POINTCUT_EXPRESSION = "(execution(* com.springboot.service.*.*Impl.*(..)))";
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	/**
	 * TransactionAttributeSource有五个实现类
	 * 使用MethodMapTransactionAttributeSource实现切人方法来加入事务
	 * @return
	 */
	@Bean
	public TransactionInterceptor txAdvice() {
		NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
		
		/* 只读事务，不做更新操作 */
		RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
		readOnlyTx.setReadOnly(true);
		readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		
		/* 当前存在事务就使用当前事务，当前不存在事务就创建一个新的事务 */
		RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();
		//什么异常需要回滚
		requiredTx.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
		requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		requiredTx.setTimeout(TX_METHOD_TIMEOUT);
		
		Map<String, TransactionAttribute> methodMap = new HashMap<>();
		
		//可以提及事务或回滚事务的方法
		methodMap.put("add*", requiredTx);
		methodMap.put("save*", requiredTx);
		methodMap.put("update*", requiredTx);
		methodMap.put("modify*", requiredTx);
		methodMap.put("edit*", requiredTx);
		methodMap.put("insert*", requiredTx);
		methodMap.put("delete*", requiredTx);
		methodMap.put("remove*", requiredTx);
		methodMap.put("repair*", requiredTx);
		methodMap.put("batch*", requiredTx);
		
		//其他方法无事务，只读
		methodMap.put("*", readOnlyTx);
		source.setNameMap(methodMap);
		
		TransactionInterceptor txAdvice = new TransactionInterceptor(transactionManager, source);
		return txAdvice;
	}

	@Bean(name = "txAdviceAdvisor")
	public Advisor txAdviceAdvisor() {
		logger.info("===============================创建txAdviceAdvisor===================================");
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
		return new DefaultPointcutAdvisor(pointcut, txAdvice());
	}
}
