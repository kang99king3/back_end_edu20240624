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
<a href="boardlist.board?pnum=1">글목록</a>
<p>
	1.글목록에서 예를 들면 3페이지를 요청한뒤 상세내용을 확인 후 다시 글목록으로 이동했을때
	  3페이지 목록으로 돌아가도록 구현
	  
	2.조회수 올릴때 글목록에서 상세내용 요청할때만 조회수가 올라가도록 구현
	  ( 이때 상세조회 페이지에서 새로고침시 조회수가 올라가면 안됨) 
	
	3.수정, 삭제(여러글삭제 포함) 구현하기
</p>
</body>
</html>








