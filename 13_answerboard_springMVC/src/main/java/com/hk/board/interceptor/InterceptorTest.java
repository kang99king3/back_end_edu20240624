package com.hk.board.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//해당 클래스를 인터셉터로 설정할경우 HandlerInterceptor를 구현한다.
public class InterceptorTest implements HandlerInterceptor{

	// slf4j는 로그 형식을 정의 -> log4j는 실제 로그 출력을 수행
	Logger logger = LoggerFactory.getLogger(getClass());
	
	//컨트롤러 실행 전에 호출된다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session=request.getSession(false);
		/*
		Object obj=session.getAttribute("ldto");//로그인 정보
		
		//요청 url로 구별해서 처리 분기
		if(request.getRequestURI().contains("/boardlist.do")) {
			logger.info(request.getRequestURI()+"요청함");
			return true;//true를 반환하면 컨트롤러로 정상 진입
//			return false;//false를 반환하면 컨트롤러로 진입 못함
		}else if(request.getRequestURI().contains("/boarddetail.do")) {
			if(obj==null) {
				logger.info("로그인없이 상세조회 요청함");
				System.out.println("로그인이 안됨");
//				response.sendRedirect("index.jsp");
//				return false;
				return true;//상세조회 확인해야 되니깐 true로 다시 수정
			}
		}
		*/
		if(session == null || session.getAttribute("ldto")==null) {
			logger.info("로그인이 필요함");
			response.sendRedirect("index.jsp");
			return false;//controller로 진입 못함
		}
		return true;
	}
	
	//컨트롤러를 실행 후 DispatcherServlet이 뷰로 보내기 전에 호출된다.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("인터셉터:posthandle실행");
	}
	
	//컨트롤러에서 뷰까지 실행이 완료된 후 호출됨
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("인터셉터:afterCompletion실행");
	}
	
}




