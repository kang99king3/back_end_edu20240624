<%@page import="java.util.List"%>
<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("utf-8"); %>
<% response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<%
	UserDto dto=(UserDto)request.getAttribute("dto");
%>
<body>
<div id="container">
	<div class="main">
		<div class="lead">
			<span><%=ldto.getTid()%>[<%=ldto.getTrole()%>]님이 로그인 함</span> |
			<span><a href="userController.jsp?command=getAllUserList">회원전체조회</a></span> |
			<span><a href="userController.jsp?command=getUserList">회원정보[등급]수정</a></span> |
			<span><a href="userController.jsp?command=logout">로그아웃</a></span>
		</div>
		<div class="contents">
			<h1>관리자 페이지</h1>
			<h2>회원등급수정</h2>
			<div id="userAllList">
				<form action="userController.jsp" method="post">
					<input type="hidden" name="command" value="userUpdateRole"/>
					<input type="hidden" name="id" value="<%=dto.getTid()%>"/>
					<table  class="table">
						<tr>
							<th>아이디</th>
							<td><%=dto.getTid()%></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><%=dto.getTname()%></td>
						</tr>
						<tr>
							<th>등급</th>
							<td>
								<select name="role">
									<option value="ADMIN"  <%=dto.getTrole().equals("ADMIN")?"selected":""%> >관리자</option>
									<option value="MANAGER" <%=dto.getTrole().equals("MANAGER")?"selected":""%>>정회원</option>
									<option value="USER" <%=dto.getTrole().equals("USER")?"selected":""%>>일반회원</option>
								</select>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<button type="submit">수정</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>













