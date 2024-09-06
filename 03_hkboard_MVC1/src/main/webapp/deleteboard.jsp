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
<body>
<%
	String sseq=request.getParameter("seq");
	int seq=Integer.parseInt(sseq);
	
	HkDao dao=new HkDao();
	boolean isS=dao.delBoard(seq);//삭제실행됨
	
	if(isS){
		%>
		<script type="text/javascript">
			alert("글을 삭제합니다.");
			location.href="boardlist.jsp";
		</script>
		<%
	}else{
		%>
		<script type="text/javascript">
			alert("글 삭제 실패");
			location.href="boarddetail.jsp?seq=<%=seq%>";
		</script>
		<%
	}
%>
</body>
</html>







