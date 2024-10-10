package com.hk.board.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogExecute {
	/*
	 * JoinPoint에서 제공하는 메서드
	 * 		  - getTarget():대상 객체를 반환
	 * 		  - getArgs():메서드의 아규먼트를 반환
	 * 		  - toLongString():메서드의 모든 정보를 반환
	 * 		  - getSignature():호출되는 메서드에 대한 정보를 담고 있는 객체 반환
	 * 				-getName():메서드의 이름 구함
	 *  			-toLongName():메서드의 풀네임(리턴타입, 파라미터타입 모두 표시)
	 *  			-toShortName(): 메서드를 축약해서 표현(메서드의 이름나 표시)
	 */
	
	//target 메서드가 실행되기전에 수행될 기능을 정의
	public void before(JoinPoint join) {//target 메서드의 정보를 JoinPoint로 전달
		Logger log=LoggerFactory.getLogger(join.getClass()+"");
		log.info("before실행(info):시작:"+join.getSignature().getName());
		log.debug("before실행(debug):시작:"+join.toLongString());
	}
	
	//target메서드가 실행된 후 값을 성공적으로 리턴했다면 수행될 기능을 정의
	public void afterReturning(JoinPoint join) {
		Logger log=LoggerFactory.getLogger(join.getClass()+"");	
		log.info("afterReturning실행(info):시작:"+join.getSignature().getName());
		log.debug("afterReturning실행(debug):시작:"+join.toLongString());
		Object[] args=join.getArgs();
		log.debug("전달 파라미터:"+Arrays.toString(args));
	}
	
	//target메서드에서 오류가 발생했을때 수행될 기능을 정의
	public void daoError(JoinPoint join) {
		Logger log=LoggerFactory.getLogger(join.getClass()+"");
		log.info("daoError실행(info):시작:"+join.getSignature().getName());
		log.debug("daoError실행(debug):시작:"+join.toLongString());
		log.debug("debug실행:오류발생");
	}
}










