<%
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 0L);
%>
<%@page import="com.hk.dtos.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/layout.css">
</head>
<%
	//현재 path 확인해보기
	System.out.println(request.getRequestURI());
	System.out.println(request.getRequestURI().substring(
				request.getContextPath().length()
			));

	UserDto ldto=null;
	
	String requestPath=
	request.getRequestURI().substring(request.getContextPath().length());
	
	if(!requestPath.equals("/registform.jsp")){
		ldto=(UserDto)session.getAttribute("ldto");
	
		//로그인 정보가 없는 경우(로그아웃한 경우) 화면처리 
		if(ldto==null){
			pageContext.forward("index.jsp");
		}		
	}
// 	hkcontroller.jsp/admin/*    --> 로그인정보확인해서 볼수 있는 페이지
// 	hkcontroller.jsp/user/login --> 로그인정보확인해서 볼수 있는 페이지
// 	hkcontroller.jsp/user/regist--> 로그인정보확인X
%>
<body>
<nav class="navbar">
	<div id="navbar">
		<ul class="navbar-nav">
			<%
				if(ldto==null){
					%>
					<li><a href="index.jsp">HOME</a></li>
					<%
				}else if(ldto.getTrole().equals("ADMIN")){
					%>
					<li><a href="admin_main.jsp">HOME</a></li>
					<%
				}else if(ldto.getTrole().equals("USER")){
					%>
					<li><a href="user_main.jsp">HOME</a></li>
					<%
				}
			%>
			<li>ABOUT</li>
			<li>CONTECT</li>
		</ul>
	</div>
</nav>
</body>
</html>












