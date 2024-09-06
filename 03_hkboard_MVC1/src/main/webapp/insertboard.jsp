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
<body>
<%
	//insertboardform.jsp에서 전송된 파라미터 받는다.
	//파라미터: id=00 , title=00, content=00
	String id=request.getParameter("id");
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	
	//java코드에서 유효값 처리를 할수있긴함..
// 	if(id==null||title==null||content==null){
// 		//글추가 페이지로 돌아가게 처리 코드작성
// 	}else{
// 		//DB 작업 코드
// 	}
	
	HkDao dao=new HkDao();
	boolean isS=dao.insertBoard(new HkDto(id,title,content));
	
//  생성자를 이용해서 초기화 작업을 안할 경우...
// 	HkDto dto=new HkDto();
// 	dto.setId(id);
// 	dto.setTitle(title);
// 	dto.setContent(content);
// 	boolean isS=dao.insertBoard(dto);

	if(isS){
		response.sendRedirect("boardlist.jsp");
	}else{
		%>
		<script type="text/javascript">
			alert("글추가 실패");
			location.href="boardlist.jsp";
		</script>
		<%
	}
%>
</body>
</html>








