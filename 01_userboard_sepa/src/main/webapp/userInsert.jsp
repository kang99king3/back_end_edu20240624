<%@page import="com.hk.board.dtos.UserDto"%>
<%@page import="com.hk.board.daos.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//userInsertForm.jsp에서 전달된 파라미터를 받기
	//request객체: userId:id, name:이름, ......
	String userId=request.getParameter("userId");//input태그의 name값
	String name=request.getParameter("name");
	String birthYear=request.getParameter("birthYear");
	int birthYearInt=Integer.parseInt(birthYear);//String->int
	String addr=request.getParameter("addr");
	String mobile1=request.getParameter("mobile1");
	String mobile2=request.getParameter("mobile2");
	String height=request.getParameter("height");
	int heightInt=Integer.parseInt(height);//String -> int
	System.out.println("주소:"+addr);
	UserDao dao=new UserDao();
	boolean isS=dao.insertUser(new UserDto(userId,
										   name,
										   birthYearInt,
										   addr,
										   mobile1,
										   mobile2,
										   heightInt));
	if(isS){
		//회원 등록하고 초기화면으로 돌아가기
		//흐름제어: forward(), sendRedirect()
		response.sendRedirect("index.jsp");
	}else{
		//회원 등록 실패하면 error페이지로 가기
		response.sendRedirect("error.jsp");
	}
%>
</body>
</html>







