<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.hk.dtos.HkDto"%>
<%@page import="java.util.List"%>
<%@page import="com.hk.daos.HkDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=UTF-8"); %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글목록 조회</title>
<style type="text/css">
/* 	th{ */
/* 		background-color: #5ABEF5; */
/* 		color:white; */
/* 	} */
	
/* 	tr:nth-child(even) { */
/* 		background-color: orange; */
/* 	} */

</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<%
	HkDao dao=new HkDao();
	List<HkDto> lists=dao.getAllList();
%>
<body>
<div class="container mt-4">
<h1 class="text-center">게시판</h1>
<h2 class="mb-4">글목록</h2>
<table  class="table table-hover table-striped align-middle">
<!-- 	<col width="50px"> -->
<!-- 	<col width="100px"> -->
<!-- 	<col width="300px"> -->
<!-- 	<col width="200px"> -->
<thead class="table-success">
	<tr>
		<th>번호</th><th>작성자</th><th>제목</th><th>작성일</th>
	</tr>
</thead>
<tbody>
	<%
		for(HkDto dto:lists){
			%>
			<tr>
				<td><%=dto.getSeq()%></td>
				<td><%=dto.getId()%></td>
				<td><a href="boarddetail.jsp?seq=<%=dto.getSeq()%>"><%=dto.getTitle()%></a></td>
				<td><%=dto.getRegDate()%></td>
			</tr>
			<%
		}
	 %>

	 <tr>
	 	<td colspan="4" class="text-end">
	 		<button class="btn btn-success" onclick="insertBoardForm()">글추가</button>
	 	</td>
	 </tr>
</tbody>
</table>
</div>
<script type="text/javascript">
	function insertBoardForm(){
		location.href="insertboardform.jsp";
	}
</script>
</body>
</html>







