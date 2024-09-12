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
<!-- 		<input type="text" name="address" placeholder="ADDRESS" required="required" /> -->
		
		<fieldset>
			<input type="text"  name="addr1" id="sample6_postcode" placeholder="우편번호">
			<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
			<input type="text" name="addr2" id="sample6_address" placeholder="주소"><br>
			<input type="text" name="addr3" id="sample6_detailAddress" placeholder="상세주소">
			<input type="text" name="addr4" id="sample6_extraAddress" placeholder="참고항목">		
		</fieldset>
		
		<input type="email" name="email" placeholder="EMAIL" required="required" />
		<button type="submit">가입완료</button>
		<button type="button" onclick="location.href='index.jsp'">메인</button>
	</form>
</div>
<!-- <div class="footer"> -->
<!-- 	Copyright 1999-2024. 한경닷컴 All rights reserved. -->
<!-- </div> -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	function sample6_execDaumPostcode() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	            var addr = ''; // 주소 변수
	            var extraAddr = ''; // 참고항목 변수
	
	            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                addr = data.roadAddress;
	            } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                addr = data.jibunAddress;
	            }
	
	            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	            if(data.userSelectedType === 'R'){
	                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraAddr += data.bname;
	                }
	                // 건물명이 있고, 공동주택일 경우 추가한다.
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                if(extraAddr !== ''){
	                    extraAddr = ' (' + extraAddr + ')';
	                }
	                // 조합된 참고항목을 해당 필드에 넣는다.
	                document.getElementById("sample6_extraAddress").value = extraAddr;
	            
	            } else {
	                document.getElementById("sample6_extraAddress").value = '';
	            }
	
	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
	            document.getElementById('sample6_postcode').value = data.zonecode;
	            document.getElementById("sample6_address").value = addr;
	            // 커서를 상세주소 필드로 이동한다.
	            document.getElementById("sample6_detailAddress").focus();
	        }
	    }).open();
	}
	
	onload=function(){
		var inputs=document.querySelectorAll("input[name]");
		for(var i=2; i< inputs.length;i++){
			inputs[i].onfocus=function(){
				var isIdchk=localStorage.getItem("idchk");
				console.log(isIdchk);
				if(isIdchk==null||isIdchk==='n'){//중복체크여부 확인
					alert("아이디 중복체크를 먼저 확인하세요");
					inputs[1].focus();//ID 입력박스로 이동
				}				
			}
		}
	}
	

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
		
		localStorage.removeItem("idchk");//storage의 값을 삭제한다.
		return true;
	}
</script> 
</body>
</html> 
<%@include file="footer.jsp" %>












