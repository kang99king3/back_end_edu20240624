<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=UTF-8"); %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>업로드 파일 목록</h1>
<table border="1">
	<tr>
		<th>seq</th>
		<th>원본명</th>
		<th>저장명</th>
		<th>사이즈</th>
		<th>업로드날짜</th>
	</tr>
	<c:choose>
		<c:when test="${empty list}">
			<tr>
				<td colspan="5">---업로드 파일이 존재하지 않습니다.---</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${requestScope.list}" var="dto">
				<tr>
					<td>${dto.seq}</td>
					<td><a href="download.file?seq=${dto.seq}">${dto.origin_name}</a></td>
					<td>${dto.stored_name}</td>
					<td>${dto.file_size}</td>
					<td><fmt:formatDate value="${dto.f_regdate}" pattern="yyyy-MM-dd"/></td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
</body>
</html>






