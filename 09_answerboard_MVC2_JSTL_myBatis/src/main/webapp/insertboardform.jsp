<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=UTF-8"); %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글추가하기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<style type="text/css">
 	#container{ 
 		width:1200px; 
 		margin:100px auto; 
 	} 
	
</style>
</head>
<body>
<h1>답변형 게시판</h1>
<div id="container">
	<h1>글 추가하기</h1>
	<form action="insertboard.board" method="post">
		<table class="table">
			<tr>
				<th>작성자(ID)</th>
				<td><input class="form-control" type="text" 
						   name="id" required="required"
						   pattern="^[a-zA-Z]+$" /></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input class="form-control" type="text" name="title" required="required"/></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td><textarea class="form-control" rows="10" cols="60" name="content"
												  required="required"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input class="btn btn-primary" type="submit" value="글 등록" />
					<input class="btn btn-primary" type="button" value="글목록"
					       onclick="location.href='boardlist.board'" />
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>






