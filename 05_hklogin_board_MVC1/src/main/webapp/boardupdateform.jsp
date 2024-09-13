<%@page import="com.hk.dtos.HkDto"%>
<%@page import="com.hk.daos.HkDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=UTF-8"); %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 수정하기 폼</title>
</head>
<%
	HkDto dto=(HkDto)request.getAttribute("dto");
%>
<body>
<h1>글 수정하기</h1>
<form action="hkController.jsp" method="post">
	<input type="hidden" name="command" value="boardupdate"/>
	<input type="hidden" name="seq" value="<%=dto.getTseq()%>"/>
	<table border="1">
		<tr>
			<th>작성자(ID)</th>
			<td><%=dto.getTid()%></td>
		</tr>
		<tr>
			<th>글제목</th>
			<td><input type="text" name="title" required="required"
												value="<%=dto.getTtitle()%>"/></td>
						
		</tr>
		<tr>
			<th>글내용</th>
			<td><textarea rows="10" cols="60" name="content"
									required="required"><%=dto.getTcontent()%></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정완료" />
				<input type="button" value="글목록"
				 onclick="location.href='hkController.jsp?command=boardlist'" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>







