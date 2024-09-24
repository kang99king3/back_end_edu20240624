package com.hk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hk.daos.HkDao;
import com.hk.dtos.HkDto;

@WebServlet("*.board")
public class HkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		//인코딩처리 -> filter에서 구현함
		
		//command 구현
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
//		String pathInfo=request.getPathInfo();
//		StringBuffer requestURL=request.getRequestURL();
		
//		System.out.println(requestURI+"\n"
//				          +contextPath+"\n"
//				          +pathInfo+"\n"
//				          +requestURL.toString());
		
		String command=requestURI.substring(contextPath.length());
		System.out.println("command:"+command);
		
		HkDao dao=new HkDao();
		
		if(command.equals("/boardlist.board")) {
			List<HkDto> lists=dao.getAllList();
			request.setAttribute("lists", lists);
			request.getRequestDispatcher("boardlist.jsp")
				   .forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}




