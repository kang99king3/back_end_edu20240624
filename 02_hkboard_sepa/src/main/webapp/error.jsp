<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		font-family: Arial, sans-serif;
		padding: 30px;
		background: #fafafa;
	}
	
	.error-box {
		max-width: 600px;
		margin: auto;
		background: #fff;
		padding: 20px;
		border-radius: 10px;
		          /*오른쪽  아래  번짐 색상*/
 		box-shadow: 0 2px 8px rgba(200, 20, 200, 0.1); 
	}
	
 	h2 { 
 		color: #d9534f; 
 	} 
	
	p {
		margin: 5px 0;
	}
	
	.code {
		font-weight: bold;
		color: #333;
	}
</style>
</head>
<body>
<div class="error-box">
	<h2>시스템오류입니다.관리자에게 문의하세요(02-1111-2345)</h2>
	<%
        // 상태 코드 & 요청 URI
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String requestUri  = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) requestUri = "알 수 없음";

        // 예외 정보
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");

        if (throwable != null) {
    %>
        <p><strong>예외 타입:</strong> <%= throwable.getClass().getName() %></p>
        <p><strong>에러 메시지:</strong> <%= throwable.getMessage() %></p>
    <%
        } else {
    %>
        <p><strong>에러 코드:</strong> <span class="code"><%= statusCode %></span></p>
        <p><strong>요청한 주소:</strong> <%= requestUri %></p>
    <%
        }
    %>

    <hr>
    <p>불편을 드려 죄송합니다. 잠시 후 다시 시도해 주세요.</p>
	<a href="index.jsp">메인으로 돌아가기</a>
</div>

</body>
</html>