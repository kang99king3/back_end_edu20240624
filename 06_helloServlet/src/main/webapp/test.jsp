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
<h1>서블릿개념</h1>
<h2>서블릿기본내용알아보기</h2>
<h2>서블릿에서 받은 파라미터:${param.param}</h2>
<%-- 						${requestScope.dto.id} --%>
<%-- 						${sessionScope.ldto.id} --%>
<h3><a href='index.jsp'>index</a></h3>
</body>
</html>








