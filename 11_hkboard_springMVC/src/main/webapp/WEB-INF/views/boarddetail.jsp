
<%@page import="com.hk.board.dtos.HkDto"%>
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
<%
	//   dto --> Object -->dto
	HkDto dto=(HkDto)request.getAttribute("dto");
%>
<body>
<h1>게시판 상세보기</h1>
<table border="1">
	<tr>
		<th>작성자(ID)</th>
		<td><%=dto.getId()%></td>
	</tr>
	<tr>
		<th>글제목</th>
		<td><%=dto.getTitle()%></td>
	</tr>
	<tr>
		<th>글내용</th>
		<td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getContent()%></textarea></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" onclick="updateForm(<%=dto.getSeq()%>)" value="수정폼이동" />
			<input type="button" onclick="delBoard(<%=dto.getSeq()%>)" value="삭제" />
			<input type="button" value="글목록"
			       onclick="location.href='boardlist.do'" />
		</td>
	</tr>
</table>
<script type="text/javascript">
	//수정폼으로 이동
	function updateForm(seq){
		location.href="boardupdateform.do?seq="+seq;
	}
	//글 삭제하기
	function delBoard(seq){
		if(confirm("삭제하시겠습니까?")){
			location.href="muldel.do?chk="+seq;			
		}
	}
</script>
</body>
</html>




