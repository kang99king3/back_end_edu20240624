<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입폼</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- <link rel="stylesheet" href="css/layout.css"> -->
</head>
<body>
<!-- <nav class="navbar"> -->
<!-- 	<div id="navbar"> -->
<!-- 		<ul class="navbar-nav"> -->
<!-- 			<li><a href="index.jsp">HOME</a></li> -->
<!-- 			<li>ABOUT</li> -->
<!-- 			<li>CONTECT</li> -->
<!-- 		</ul> -->
<!-- 	</div> -->
<!-- </nav> -->
<div>
	<h1>회원가입</h1>
	<form action="userController.jsp" method="post" onsubmit="return isPW(this)">
		<input type="hidden" name="command" value="adduser"/>
		<input type="text" name="id" placeholder="ID" required="required" />
		<a href="#" onclick="idChk()">중복체크</a>
		<input type="text" name="name" placeholder="이름" required="required" />
		<input type="password" name="password" placeholder="PASSWORD" required="required" />
		<input type="password" name="password2" placeholder="PASSWORD확인" required="required" />
		<input type="text" name="address" placeholder="ADDRESS" required="required" />
		<input type="text" id="sample5_address" placeholder="주소">
		<input type="email" name="email" placeholder="EMAIL" required="required" />
		<button type="submit">가입완료</button>
		<button type="button" onclick="location.href='index.jsp'">메인</button>
	</form>
</div>
<!-- <div class="footer"> -->
<!-- 	Copyright 1999-2024. 한경닷컴 All rights reserved. -->
<!-- </div> -->
<script type="text/javascript">
	//아이디 중복체크
	function idChk(){
		var id=document.getElementsByName("id")[0].value;
		if(id==""){
			alert("아이디를 입력하세요");
		}else{
			// open(url,title,attribute)
			window.open("userController.jsp?command=idchk&id="+id,
					    "아이디 확인","width=300px,height=300px");
		}
	}


	//회원가입시 패스워드 확인하여 가입진행하는 기능 구현
	function isPW(formEle){// 파라미터는 form 엘리먼트 전달 받음
// 		var formEle=document.getElementsByTagName("form")[0];
		if(formEle.password.value!=formEle.password2.value){
			alert("비밀번호를 확인하세요");
			formEle.password.value="";//비밀번호 초기화
			formEle.password2.value="";
			formEle.password.focus();//비밀번호를 바로 입력할 수 있도록 유도.. 커서넣기
			return false;// false 반환해줘야 submit 취소할 수 있다.
		}
		return true;
	}
</script> 
</body>
</html> 
<%@include file="footer.jsp" %>





