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
			<span><%=ldto.getId()%>[<%=ldto.getRole()%>]님이 로그인 함</span> |
			<span><a href="getAllUserList.user">회원전체조회</a></span> |
			<span><a href="getUserList.user">회원정보[등급]수정</a></span> |
			<span><a href="logout.user">로그아웃</a></span>
		</div>
		<div class="contents">
			<h1>관리자 페이지</h1>
			<div style="height: 500px;"></div>
		</div>
	</div>
</div>
</body>
</html>
<%@include file="footer.jsp" %>







