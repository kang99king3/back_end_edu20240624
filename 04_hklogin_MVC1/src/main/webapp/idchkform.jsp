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
<%
	String resultId=(String)request.getAttribute("resultId");
%>
<div>
	<span><%=resultId==null?"사용가능한 아이디입니다.":"중복된 아이디입니다."%></span>
	<span><button onclick="confirmId('<%=resultId%>')">확인</button></span>
</div>
<script type="text/javascript">
	function confirmId(resultId){
		//id입력박스객체
		var parentInputId=opener.document.getElementsByName("id")[0];
		if(resultId=='null'){
			opener.document.getElementsByName("name")[0].focus();
		}else{
			parentInputId.focus();
		}
		
		self.close();//현재 창을 닫는다.
	}
</script>
</body>
</html>








