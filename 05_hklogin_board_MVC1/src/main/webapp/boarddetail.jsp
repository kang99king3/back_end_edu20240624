<%@include file="header.jsp" %>
<%@page import="com.hk.dtos.HkDto"%>
<%@page import="com.hk.daos.HkDao"%>
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
<table border="1" class="board_table">
	<tr>
		<th>작성자(ID)</th>
		<td><%=dto.getTid()%></td>
	</tr>
	<tr>
		<th>글제목</th>
		<td><%=dto.getTtitle()%></td>
	</tr>
	<tr>
		<th>글내용</th>
		<td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getTcontent()%></textarea></td>
	</tr>
	<tr>
		<td colspan="2">
			<%
				//로그인한 회원 자신의 글일 경우만 수정,삭제 기능 사용
				if(ldto.getTid().equals(dto.getTid())){
					%>
					<input type="button" onclick="updateForm(<%=dto.getTseq()%>)" value="수정폼이동" />
					<input type="button" onclick="delBoard(<%=dto.getTseq()%>)" value="삭제" />					
					<%
				}
			%>
			<input type="button" value="글목록"
			       onclick="location.href='hkController.jsp?command=boardlist'" />
		</td>
	</tr>
</table>
<script type="text/javascript">
	//수정폼으로 이동
	function updateForm(seq){
		location.href="hkController.jsp?command=boardupdateform&seq="+seq;
	}
	//글 삭제하기
	function delBoard(seq){
		location.href="hkController.jsp?command=deleteboard&seq="+seq;
	}
</script>
</body>
</html>
<%@include file="footer.jsp" %>



