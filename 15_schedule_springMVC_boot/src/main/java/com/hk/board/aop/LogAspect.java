package com.hk.board.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// @Component:객체 등록의 공통적인 방법
// @controller, @service, @repository : 클래스를 구분하기 위한 세부적인 표현

@Component // 내가 만든 클래스를 등록
@Aspect   // AOP로 사용할 객체 선언
public class LogAspect {
	
	//로그 관리를 수행할 객체 생성
	Logger logger=LoggerFactory.getLogger(getClass());
	
	//pointcut 정의
	//execution(): 메서드단위로 설정한다.
	//within(): 클래스단위로 설정한다.- (com.hk.board.controller.*)
	@Pointcut(value = "within(com.hk.board.controller.*)")
//	@Pointcut(value = "execution(com.hk.board.controller.CalController.*Board(..))")
	public void controller() {}
	
	//before
	@Before(value="controller()")
	public void before(JoinPoint join) {
		// info("메시지")
		// info("로그설명{}","메시지"): "로그설명메시지" 출력
		logger.info("before메서드실행:{}",join.getSignature().getName());
	}
	//afterReturning
	//returning속성: 메서드에 정의한 파라미터에 반환값을 보내줌
	@AfterReturning(pointcut = "controller()",returning = "returnVal")
	public void afterReturning(JoinPoint join,Object returnVal) {
		logger.info("afterReturning메서드실행:{}",join.getSignature().getName());
		if(returnVal==null) {
			return;
		}else {
			logger.info("리턴값:{}",returnVal);
		}
	}
	//afterThrowing
	@AfterThrowing(pointcut = "controller()", throwing = "e")
	public void afterThrowing(JoinPoint join, Exception e) {
		logger.info("afterThrowing메서드실행:{}",join.toShortString());
		logger.info("오류내용:{}",e.getMessage());
	}
	//Around : 메서드 실행 전과 후 모두 적용
}










