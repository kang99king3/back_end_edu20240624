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
<!-- <link rel="stylesheet" href="css/layout.css"> -->
<style type="text/css">
	*{
	margin:0px;
	padding:0px;
}

#navbar{
	background-color: darkblue;
	height: 60px;
}

.navbar ul{
	width:800px ;
	margin-left:100px;
}

.navbar li{
	display: inline-block ;
	margin-top:15px;
	font-size: 20px;
	color:white;
	margin-left:15px;
}

.navbar a{
	color:white;
	text-decoration: none;
}

.footer{
	position: fixed;
	left:0px;
	right:0px;
	bottom:0px;
	text-align: center;
	color:white;
	background-color: darkblue;
	line-height: 50px;
	height: 50px;
}

form{
	width:800px;
	margin:5% auto;
	background-color: honeydew;
	padding: 20px;
}

input{
	border:1px solid rgb(192,192,192);
	width: 780px;
	height: 40px;
	border-radius: 5px;
	padding-left: 10px ;
}

input,button{
	margin:4px;
}

button{
	border: 1px solid cornflowerblue;
	background-color:black;
	border-radius:5px;
	width:300px;
	height: 40px;
	color:darkorchid;
	font-weight: bold;	
	margin-left:60px;
}

form > a{
	text-decoration: none;
}

fieldset > #sample6_postcode,fieldset > input[type=button]{
	width:380px;
}

fieldset > #sample6_detailAddress,fieldset > #sample6_extraAddress{
	width:375px;
}
fieldset{
	margin:10px auto;
	border-radius: 5px;
}

.main{
	width:1200px;
	margin:50px auto;
}

td, th{
	padding: 10px;
}

tr:nth-child(odd){
	background-color: azure ;
}

tr:nth-child(1){
	background-color:deepskyblue ;
}

table button{
	width:100px;
}
</style>
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
			<li><a href="index.jsp">HOME</a></li>
			<li>ABOUT</li>
			<li>CONTECT</li>
		</ul>
	</div>
</nav>
</body>
</html>












