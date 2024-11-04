
<%@page import="com.hk.board.dtos.HkDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%
response.setContentType("text/html;charset=UTF-8");
%>  
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
<form action="boardupdate.do" method="post">
	<input type="hidden" name="seq" value="<%=dto.getSeq()%>"/>
	<table border="1">
		<tr>
			<th>작성자(ID)</th>
			<td><%=dto.getId()%></td>
		</tr>
		<tr>
			<th>글제목</th>
			<td><input type="text" name="title" required="required"
												value="<%=dto.getTitle()%>"/></td>
						
		</tr>
		<tr>
			<th>글내용</th>
			<td><textarea rows="10" cols="60" name="content"
									required="required"><%=dto.getContent()%></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정완료" />
				<input type="button" value="글목록"
				 onclick="location.href='boardlist.do'" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>







