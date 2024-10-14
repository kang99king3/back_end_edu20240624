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
<%-- <% String msg=request.getParameter("msg"); %> --%>
<body>
<h1>시스템 오류</h1>
<h2>오류메시지:${msg}</h2>
<h3><a href="/">main으로 돌아가기</a></h3>
</body>
</html>







