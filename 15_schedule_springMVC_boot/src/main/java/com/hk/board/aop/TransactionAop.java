package com.hk.board.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.TransactionInterceptor;

//등록된 빈을 스프링컨테이너에 제공하는 클래스를 선언하는 의미
@Configuration //환경설정 클래스 선언
public class TransactionAop {

	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Bean //객체선언 및 등록
	public TransactionInterceptor transactionAdvice() {
		//rollback 규칙 작성
		List<RollbackRuleAttribute> rollbackRules =
				new ArrayList<RollbackRuleAttribute>();
		rollbackRules.add(new RollbackRuleAttribute(Exception.class));
		
		//모든 메서드에 규칙을 적용하는 트랜젝션 속성 정의
		RuleBasedTransactionAttribute transactionAttribute
		=new RuleBasedTransactionAttribute();
		transactionAttribute.setRollbackRules(rollbackRules);
		transactionAttribute.setName("*");
		
		//정의된 트랜젝션속성을 적용한 트랜젝션 소스 객체 정의
		MatchAlwaysTransactionAttributeSource attributeSource
		=new MatchAlwaysTransactionAttributeSource();
		attributeSource.setTransactionAttribute(transactionAttribute);
		
		//트랜젝션 인터셉터객체에 트랜젝션 메니져 객체를 등록하고, 정의된 속성객체 적용
		TransactionInterceptor interceptor=new TransactionInterceptor();
		interceptor.setTransactionManager(transactionManager);
		interceptor.setTransactionAttributeSource(attributeSource);
		
		return interceptor; //정의한 인터셉터 객체 반환
	}
	
	@Bean
	public Advisor transactionAdvisor() {
		//포인트컷 객체 생성
		AspectJExpressionPointcut pointcut 
		= new AspectJExpressionPointcut();
		
		//포인트컷에 실행위치 적용
		pointcut.setExpression(EXECUTION);
		//advisor객체 = 포인트컷 + 트랜젝션 어드바이스 정의
		return new DefaultPointcutAdvisor(pointcut,transactionAdvice());
	}
}










