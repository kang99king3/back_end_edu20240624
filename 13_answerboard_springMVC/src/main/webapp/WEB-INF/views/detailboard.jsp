<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=UTF-8"); %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세보기</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<style type="text/css">
 	#container{ 
 		width:1200px; 
 		margin:100px auto; 
 	} 
 	
/*  답글 폼 안보이게 처리하자 */
	#replyForm{
		display: none;
	}
</style>
<script type="text/javascript">
	$(function(){ //onload 기능
		$("#replyBtn").click(function(){
			$("#replyForm").slideToggle();
			document.getElementsByTagName("form")[0].reset();//form요소 초기화
		});
	});
</script>
</head>
<body>
<h1>답변형 게시판</h1>
<div id="container">
	<h1>글 상세보기</h1>
	<table class="table">
		<tr>
			<th>작성자(ID)</th>
			<td>${dto.id}</td>
		</tr>
		<tr>
			<th>글제목</th>
			<td>${dto.title}</td>
		</tr>
		<tr>
			<th>글내용</th>
			<td><textarea class="form-control" rows="10" cols="60" name="content"
						  readonly="readonly">${dto.content}</textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<button class="btn btn-primary" type="button" id="replyBtn">답글</button>
				<button class="btn btn-primary" type="button">수정</button>
				<button class="btn btn-primary" type="button">삭제</button>
<!-- 				<button class="btn btn-primary" type="button" -->
<!-- 				        onclick="location.href='boardlist.board?pnum=1'">목록</button> -->
				<button class="btn btn-primary" type="button"
				        onclick="location.href='boardlist.do'">목록</button>
			</td>
		</tr>
	</table>
	
	<div id="replyForm">
		<h1>답글 작성하기</h1>
		<form action="replyboard.do" method="post">
			<input type="hidden" name="seq" value="${dto.seq}"/>
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
						<input class="btn btn-primary" type="submit" value="답글등록" />
<!-- 						<input class="btn btn-primary" type="button" value="글목록" -->
<!-- 						       onclick="location.href='boardlist.board?pnum=1'" /> -->
						<input class="btn btn-primary" type="button" value="글목록"
						       onclick="location.href='boardlist.do'" />
					</td>
				</tr>
			</table>
		</form>
		
	</div>
</div>
</body>
</html>







