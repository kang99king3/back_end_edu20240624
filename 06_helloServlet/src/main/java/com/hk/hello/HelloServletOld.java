package com.hk.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HelloServletOld extends HttpServlet{

	@Override
	public void init() throws ServletException {
		System.out.println("init():servlet객체가 생성되면 최초에 한번 실행되는 메서드");
	}
	
	//ServletConfig객체의 사용
	//init()메서드에서 파라미터로 얻을 수 있다.
	@Override
	public void init(ServletConfig config) throws ServletException {
		//web.xml에 정의된 init 값을 가져오기
		String name=config.getInitParameter("name");
		
		//ServletContext객체 얻어오기(jsp에서 scope객체중 application객체를 의미함)
		ServletContext application=config.getServletContext();
		application.setAttribute("id", "id");//객체 저장
		
		//web.xml에 값을 정의해놓고 가져올 수 도 있다.
		String driver=application.getInitParameter("driver");
		System.out.println("application객체에 저장된 값:"+driver);
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
//		req.setCharacterEncoding("utf-8");
//		resp.setContentType("text/html;charset=utf-8");
		
		//Session객체 사용
		HttpSession session=req.getSession();
		session.setAttribute("id", "id값");
		
		//파라미터를 받는다
		String param=req.getParameter("param");
		
		//java에서 HTML로 응답하기
//		PrintWriter out=resp.getWriter();
//		out.print("<h1>서블릿개념</h1>");
//		out.print("<h2>서블릿기본내용알아보기</h2>");
//		out.print("<h2>서블릿에서 받은 파라미터:"+param+"</h2>");
//		out.print("<h3><a href='index.jsp'>index</a></h3>");
		
		//서블릿에서 흐름제어
		//sendRedirect
		resp.sendRedirect("test.jsp?param="+param);
		//forward
//		req.getRequestDispatcher("test.jsp").forward(req, resp);
		
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy():더이상 요청이 없을 경우 서블릿을 소멸시킴");
	}
}



















