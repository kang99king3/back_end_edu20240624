<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=UTF-8"); %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글추가하기</title>
</head>
<body>
<h1>글 추가하기</h1>
<form action="hkController.jsp" method="post">
<input type="hidden" name="command" value="insertboard"/>
	<table border="1">
		<tr>
			<th>작성자(ID)</th>
			<td><input type="text" name="id" required="required"/></td>
		</tr>
		<tr>
			<th>글제목</th>
			<td><input type="text" name="title" required="required"/></td>
		</tr>
		<tr>
			<th>글내용</th>
			<td><textarea rows="10" cols="60" name="content"
											  required="required"></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="글 등록" />
				<input type="button" value="글목록"
				       onclick="location.href='hkController.jsp?command=boardlist'" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>






