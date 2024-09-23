package com.hk.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServletOld extends HttpServlet{

	@Override
	public void init() throws ServletException {
		System.out.println("init():servlet객체가 생성되면 최초에 한번 실행되는 메서드");
	}
	
	//service()를 구현함
	//클라이언트에서 요청하는 방식에 따라서 처리하는 메서드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get방식 요청");
		doPost(req, resp);
		test(req);
	}
	
	//request 같은 객체는 새롭게 생성하지 않고, 받은 객체를 바로 쓰거나, 전달해서 사용
	public void test(HttpServletRequest req) {
		req.getParameter("id");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//인코딩처리
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//파라미터를 받는다
		String param=req.getParameter("param");
		
		//java에서 HTML로 응답하기
		PrintWriter out=resp.getWriter();
		out.print("<h1>서블릿개념</h1>");
		out.print("<h2>서블릿기본내용알아보기</h2>");
		out.print("<h2>서블릿에서 받은 파라미터:"+param+"</h2>");
		out.print("<h3><a href='index.jsp'>index</a></h3>");
	}
}



















