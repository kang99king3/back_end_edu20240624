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
<form action="hkController.jsp" method="post">
<input type="hidden" name="command" value="muldel"/>
<!-- 삭제버튼 클릭 - chkbox:체크된 박스들만 chk=seq,chk=seq,chk=seq -->
<table>
	<col width="50px">
	<col width="50px">
	<col width="100px">
	<col width="300px">
	<col width="200px">
	<tr>
		<th><input type="checkbox" name="all" onclick="allSel(this.checked)"/></th>
		<th>번호</th><th>작성자</th><th>제목</th><th>작성일</th>
	</tr>
	<%
		for(HkDto dto:lists){
			%>
			<tr>
				<td><input type="checkbox" name="chk" value="<%=dto.getSeq()%>"/></td>
				<td><%=dto.getSeq()%></td>
				<td><%=dto.getId()%></td>
				<td><a href="hkController.jsp?command=boarddetail&seq=<%=dto.getSeq()%>"><%=dto.getTitle()%></a></td>
				<td><%=dto.getRegDate()%></td>
			</tr>
			<%
		}
	 %>
	 <tr>
	 	<td colspan="5">
	 		<button onclick="insertBoardForm()">글추가</button>
	 		<button type="submit">글삭제</button>
	 	</td>
	 </tr>
</table>
</form>
<script type="text/javascript">
	function insertBoardForm(){
		location.href="hkController.jsp?command=insertboardform";
	}
	//전체선택 체크박스 기능 구현
	function allSel(bool){
		var chks=document.getElementsByName("chk");//[chk,chk,chk..]
		for (var i = 0; i < chks.length; i++) {
			chks[i].checked=bool;//true:체크, false:체크해제
		}
	}
</script>
</body>
</html>







