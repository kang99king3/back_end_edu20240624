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
			<span><%=ldto.getTid()%>[<%=ldto.getTrole()%>]님이 로그인 함</span> |
			<span><a href="userController.jsp?command=getAllUserList">회원전체조회</a></span> |
			<span><a href="userController.jsp?command=getUserList">회원정보[등급]수정</a></span> |
			<span><a href="userController.jsp?command=logout">로그아웃</a></span>
		</div>
		<div class="contents" style="height: 700px;">
			<h1>관리자 페이지</h1>
		</div>
	</div>
</div>
</body>
</html>
<%@include file="footer.jsp" %>







