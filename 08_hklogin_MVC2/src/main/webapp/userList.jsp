<%@page import="java.util.List"%>
<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("utf-8"); %>
<% response.setContentType("text/html; charset=utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//등급변경을 위한 회원상세정보조회
	function roleForm(id){
		location.href="roleForm.user?id="+id;
	}
</script>
</head>
<body>
<div id="container">
	<div class="main">
		<div class="lead">
			<span>${ldto.id}[${ldto.role}]님이 로그인 함</span> |
			<span><a href="getAllUserList.user">회원전체조회</a></span> |
			<span><a href="getUserList.user">회원정보[등급]수정</a></span> |
			<span><a href="logout.user">로그아웃</a></span>
		</div>
		<div class="contents">
			<h1>관리자 페이지</h1>
			<h2>회원목록조회[등급수정]</h2>
			<div id="userAllList">
				<input type="text" name="search" /><button>검색</button>
				<table  class="table">
					<tr>
						<th>회원번호</th>
						<th>아이디</th>
						<th>이름</th>
						<th>회원등급</th>
						<th>가입일</th>
					</tr>
					<c:choose>
						<c:when test="${empty list}">
							<tr>
								<td colspan='5'>--회원이 존재하지 않습니다.--</td>
							</tr>	
						</c:when>
						<c:otherwise>
							<c:forEach items="${list}" var="dto" >
								<tr>
									<td>${dto.seq}</td>
									<td>${dto.id}</td>
									<td>${dto.name}</td>
									<td>
										${dto.role}
										<c:if test="${ dto.id ne ldto.id }">
											<button type="button" onclick="roleForm('${dto.id}')">변경</button>
										</c:if>
									</td>
									<td>${dto.regDate}</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>
			</div>
		</div>
	</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>













