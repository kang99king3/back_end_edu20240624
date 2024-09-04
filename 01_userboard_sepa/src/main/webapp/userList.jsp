<%@page import="com.hk.board.dtos.UserDto"%>
<%@page import="java.util.List"%>
<%@page import="com.hk.board.daos.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록 조회</title>
</head>
<%//java 실행부
   //DB에 접근하려면 어떤 객체가 필요할까???
   UserDao dao=new UserDao();// DAO객체: DB에 접근해서 작업하는 객체
   List<UserDto> lists=dao.getAllUser();//회원목록 가져오기
%>
<body>
<h1>회원 조회 결과</h1>
<table border="1">
	<tr>
		<th>아이디</th><th>이름</th><th>가입일</th><th>수정</th><th>삭제</th>
	</tr>
	<%
		for(int i=0;i<lists.size();i++){
			UserDto dto=lists.get(i);//list[dto,dto....]-> dto한개 가져옴
		%>
			<tr>
				<td><%=dto.getUserID()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getmDate()%></td>
				<td><a href="userUpdateForm.jsp?userId=<%=dto.getUserID()%>">수정</a></td>
				<td><a href="#">삭제</a></td>
			</tr>
		<%
		}
	%>
	<tr>
		<td colspan="5">
			<a href="index.jsp">초기화면</a>
		</td>
	</tr>
</table>
</body>
</html>













