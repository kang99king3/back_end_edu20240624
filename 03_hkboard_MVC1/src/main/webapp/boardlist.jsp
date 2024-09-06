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
	th{
		background-color: blue;
		color:white;
	}
	
	tr:nth-child(even) {
		background-color: orange;
	}
</style>
</head>
<%
//  requestScope에 저장될때는 Object타입으로 자동 변환됨
//  --> 다운캐스팅이 필요함
// 	Object obj=request.getAttribute("lists");
// 	List<HkDto> lists=(List<HkDto>)obj;

	List<HkDto> lists=(List<HkDto>)request.getAttribute("lists");
%>
<body>
<h1>게시판</h1>
<h2>글목록</h2>
<table>
	<col width="50px">
	<col width="100px">
	<col width="300px">
	<col width="200px">
	<tr>
		<th>번호</th><th>작성자</th><th>제목</th><th>작성일</th>
	</tr>
	<%
		for(HkDto dto:lists){
			%>
			<tr>
				<td><%=dto.getSeq()%></td>
				<td><%=dto.getId()%></td>
				<td><a href="hkController.jsp?command=boarddetail&seq=<%=dto.getSeq()%>"><%=dto.getTitle()%></a></td>
				<td><%=dto.getRegDate()%></td>
			</tr>
			<%
		}
	 %>
	 <tr>
	 	<td colspan="4">
	 		<button onclick="insertBoardForm()">글추가</button>
	 	</td>
	 </tr>
</table>
<script type="text/javascript">
	function insertBoardForm(){
		location.href="insertboardform.jsp";
	}
</script>
</body>
</html>







