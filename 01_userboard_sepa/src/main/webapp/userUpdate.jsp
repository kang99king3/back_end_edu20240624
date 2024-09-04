<%@page import="com.hk.board.dtos.UserDto"%>
<%@page import="com.hk.board.daos.UserDao"%>
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
<%
	// 전송된 parameter: name,birthYear,addr, mobile1......
	String userId=request.getParameter("userId");//input태그의 name값
	String name=request.getParameter("name");
	String birthYear=request.getParameter("birthYear");
	int birthYearInt=Integer.parseInt(birthYear);//String->int
	String addr=request.getParameter("addr");
	String mobile1=request.getParameter("mobile1");
	String mobile2=request.getParameter("mobile2");
	String height=request.getParameter("height");
	int heightInt=Integer.parseInt(height);//String -> int
	
	UserDao dao=new UserDao();
	boolean isS=dao.updateUser(new UserDto(
		userId,name,birthYearInt,addr,mobile1,mobile2,heightInt));
	
	if(isS){
		//javascript를 활용해서 이동해보기
		%>
		<script type="text/javascript">
			alert("회원정보를 수정했습니다.");
			location.href="userUpdateForm.jsp?userId=<%=userId%>";
		</script>
		<%
	}else{
		response.sendRedirect("error.jsp");
	}
%>
</body>
</html>






