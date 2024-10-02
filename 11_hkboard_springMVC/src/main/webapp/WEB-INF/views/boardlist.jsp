<%@page import="com.hk.board.dtos.HkDto"%>
<%@page import="java.util.List"%>
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
	List<HkDto> lists=(List<HkDto>)request.getAttribute("list");
%>
<body>
<h1>게시판</h1>
<h2>글목록</h2>
<form action="muldel.board" method="post" onsubmit="return isAllCheck();">
<!-- <input type="hidden" name="command" value="muldel" /> -->
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
				<td><a href="boarddetail.board?seq=<%=dto.getSeq()%>"><%=dto.getTitle()%></a></td>
				<td><%=dto.getRegDate()%></td>
			</tr>
			<%
		}
	 %>
	 <tr>
	 	<td colspan="5">
	 		<button type="button" onclick="insertBoardForm()">글추가</button>
	 		<button type="submit">글삭제</button>
	 	</td>
	 </tr>
</table>
</form>
<script type="text/javascript">
	function insertBoardForm(){
		location.href="insertboardform.board";
	}
	//전체선택 체크박스 기능 구현
	function allSel(bool){
		var chks=document.getElementsByName("chk");//[chk,chk,chk..]
		for (var i = 0; i < chks.length; i++) {
			chks[i].checked=bool;//true:체크, false:체크해제
		}
	}
	
	function isAllCheck(){
		if(confirm("정말 삭제할꺼야?")){
			var count=0;
// 			var chks=document.getElementsByName("chk");//[chk,chk...]
// 			for (var i = 0; i < chks.length; i++) {
// 				if(chks[i].checked){//체크여부확인: 체크되면 true반환
// 					count++;
// 					break;
// 				}
// 			}
// 			if(count==0){
// 				alert('최소 하나이상 체크하세요');
// 			}
// 			return  count>0?true:false;
			
			//CSS의 셀렉터 표현식을 활용해서 DOM 탐색
			var chks=document.querySelectorAll("input[name=chk]:checked");
// 			alert(chks.length);
			if(chks.length==0){
				alert("하나이상 체크하세요");
				return false;
			}else{
				return true;
			}
		}
		return false;//취소버튼 클릭했을 경우 전송되면 안되니깐 false반환
	}
</script>
</body>
</html>







