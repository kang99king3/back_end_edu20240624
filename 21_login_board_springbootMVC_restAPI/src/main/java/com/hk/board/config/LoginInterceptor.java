package com.hk.board.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hk.board.dtos.MemberDto;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor{

	//controller로 진입하기 전에 실행하는 메서드
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

//		System.out.println(request.getCookies()[0].getValue());
		HttpSession session=request.getSession();
//		if(session.getAttribute("mdto")==null) {// 로그인X
//			System.out.println("로그인 필요");
//			sendUnauthorizedResponse(response);
//			return false;
//		}
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				System.out.print("cookie:"+cookie.getValue()+"\t");
			}
			
		}else {
			System.out.println("cookie:"+cookies);
		}
		System.out.println("\n"+request.getRequestURL());
		if(session.getAttribute("mdto")==null) {// 로그인X
			System.out.println("로그인 필요");
			
			sendUnauthorizedResponse(response);
			return false;
		}
		else {
			System.out.println("login인터셉터에서 회원임을 인증");
			System.out.println(session.getAttributeNames().hasMoreElements());
			System.out.println(session.getAttributeNames().nextElement());
//			MemberDto mdto=(MemberDto)session.getAttribute("mdto");
//			System.out.println(mdto.getId());
			return true;			
		}
	}
	
	 // 비로그인 상태일 때 JSON 응답을 보내는 메서드
    private void sendUnauthorizedResponse(HttpServletResponse response) 
    		                                        throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value()); // HTTP 401 상태 코드 설정
        response.setContentType("application/json;charset=UTF-8");

        // JSON 응답 생성
        Map<String, String> data = new HashMap<>();
        data.put("message", "로그인이 필요합니다.");

        // JSON 데이터를 응답으로 전송
        // ObjectMapper객체: 객체를 Json으로 변환할때 사용하는 객체
        ObjectMapper mapper = new ObjectMapper();
        //writeValueAsString(): 객체를 json문자열로 변환할때 사용하는 메서드
        response.getWriter().write(mapper.writeValueAsString(data));
        response.getWriter().flush();
    }
}