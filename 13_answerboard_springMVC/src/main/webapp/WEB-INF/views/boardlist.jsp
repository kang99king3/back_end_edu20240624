<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=UTF-8"); %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<style type="text/css">
 	#container{ 
 		width:1200px; 
 		margin:100px auto; 
 	} 
	
</style>
</head>
<body>
<jsp:useBean id="util" class="com.hk.board.util.Util" />
<h1>답변형 게시판</h1>
<div id="container">
	<h2>글목록 조회</h2>
	<table  class="table">
<%-- 		<col width="50px" /> --%>
<%-- 		<col width="100px" /> --%>
<%-- 		<col width="300px" /> --%>
<%-- 		<col width="100px" /> --%>
<%-- 		<col width="150px" /> --%>
<%-- 		<col width="50px" /> --%>
<%-- 		<col width="50px" /> --%>
<%-- 		<col width="50px" /> --%>
<%-- 		<col width="50px" /> --%>
		<thead class="table-light">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>조회수</th>
			<th>작성일</th>
			<th>삭제여부</th>
			<th>refer</th>
			<th>step</th>
			<th>depth</th>
		</tr>
		</thead>
		<c:choose>
			<c:when test="${empty list}">
				<tr>
					<td colspan="9">--작성된 글이 없습니다.--</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.seq}</td>
						<td>${dto.id}</td>
						<td>
							<c:forEach begin="1" end="${dto.depth}" var="i" step="1">
								&nbsp;&nbsp;&nbsp;&nbsp;
								<c:if test="${i==dto.depth}">
									<img src="img/arrow.png" />
								</c:if>
							</c:forEach>
<%-- 							<jsp:setProperty property="arrowNbsp" name="util" value="${dto.depth}"/> --%>
<%-- 							<jsp:getProperty property="arrowNbsp" name="util"/>	 --%>
							<a href="boarddetail.board?review=y&seq=${dto.seq}">
								${fn:length(dto.title)>10?fn:substring(dto.title,0,10)+='...':dto.title}
							</a>
						</td>
						<td>${dto.readCount}</td>
						<td><fmt:formatDate value="${dto.regDate}" pattern="yyyy년MM월dd일"/> </td>
						<td>${dto.delflag}</td>
						<td>${dto.refer}</td>
						<td>${dto.step}</td>
						<td>${dto.depth}</td>
					</tr>
				</c:forEach>
			</c:otherwise>		
		</c:choose>
		<tr>                        
			<td colspan="9" >
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center">
				 	<li class="page-item"><a class="page-link" href="boardlist.board?pnum=${pMap.prePageNum}">Previous</a></li>
					<c:forEach begin="${pMap.startPage}" end="${pMap.endPage}" var="i" step="1">
						<li class="page-item ${sessionScope.pnum == i ? "active":"" }"><a class="page-link" href="boardlist.do?pnum=${i}">${i}</a></li>
					</c:forEach>
					<li class="page-item"><a class="page-link" href="boardlist.board?pnum=${pMap.nextPageNum}">Next</a></li>
				</ul>
			</nav>
			</td>
		</tr>
		<tr>
			<td colspan="9">
				<button type="button" class="btn btn-primary"
				     onclick="location.href='insertform.board'">글추가</button>
				<button class="btn btn-danger">삭제</button>
			</td>
		</tr>
	</table>
</div>
</body>
</html>