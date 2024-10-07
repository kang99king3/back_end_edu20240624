<%@page import="com.hk.board.dtos.UserDto"%>
<%@include file="header.jsp" %>
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
<div id="container">
	<div class="main">
		<div class="lead">
			<span>${ldto.id}[${ldto.role}]님이 로그인하였습니다.</span>
			<span><a href="userinfo.user?id=${ldto.id}">나의정보</a></span>
			<span><a href="logout.user">로그아웃</a></span>
		</div>
	</div>
</div>

</body>
</html>
<%@include file="footer.jsp" %>







