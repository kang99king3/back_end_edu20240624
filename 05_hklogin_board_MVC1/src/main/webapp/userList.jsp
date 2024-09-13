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
<script type="text/javascript">
	//등급변경을 위한 회원상세정보조회
	function roleForm(id){
		location.href="userController.jsp?command=roleForm&id="+id;
	}
</script>
</head>
<%
	List<UserDto> list=(List<UserDto>)request.getAttribute("list");
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
			<h2>회원목록조회[등급수정]</h2>
			<div id="userAllList">
				<input type="text" name="search" /><button>검색</button>
				<table  class="table">
					<tr>
						<th>번호</th>
						<th>아이디</th>
						<th>이름</th>
						<th>회원등급</th>
						<th>가입일</th>
					</tr>
					<%
						if(list==null||list.size()==0){
							out.print("<tr>"
									 +"<td colspan='5'>--회원이 존재하지 않습니다.--</td>"	
									 +"</tr>");					
						}else{
							int i=1;
							for(UserDto dto:list){//향상된 for문
								%>
								<tr>
									<td><%=i++%></td>
									<td><%=dto.getTid()%></td>
									<td><%=dto.getTname()%></td>
									<td>
										<%=dto.getTrole()%>
										<%
											if(!(dto.getTid().equals(ldto.getTid()))){
											%>
											<button type="button" onclick="roleForm('<%=dto.getTid()%>')">변경</button>
											<%	
											}
										%>
									</td>
									<td><%=dto.getTregDate()%></td>
								</tr>
								<%
							}
						}
					%>
				</table>
			</div>
		</div>
	</div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>













