<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록폼</title>
</head>
<body>
<h1>신규회원입력</h1>
<form action="userInsert.jsp" method="post">
	<table border="1">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="userId"/></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<th>출생년도</th>
			<td><input type="text" name="birthYear"/></td>
		</tr>
		<tr>
			<th>지역</th>
			<td><input type="text" name="addr"/></td>
		</tr>
		<tr>
			<th>휴대폰 국번</th>
			<td><input type="text" name="mobile1"/></td>
		</tr>
		<tr>
			<th>휴대폰 전화번호</th>
			<td><input type="text" name="mobile2"/></td>
		</tr>
		<tr>
			<th>신장</th>
			<td><input type="text" name="height"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="회원입력" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>







