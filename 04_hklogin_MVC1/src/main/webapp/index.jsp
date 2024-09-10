<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html;charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/loginpage1.css">
</head>
<body>
<% String msg=request.getParameter("msg"); %>
<form action="userController.jsp" method="post">
	<input type="hidden" name="command" value="login"/>
	<h1>Login</h1>
	<input type="text" name="id" placeholder="ID" required="required" />
	<input type="password" name="password" placeholder="password" 
											  required="required" />
	<input type="checkbox" value="remember-me"/><label>아이디 저장</label>
	<label style="color:red;"><small><%=msg==null?"":msg%></small></label>	
	<button type="submit">Sign in</button>
	<button type="button" onclick="registForm()">Sign up</button>
</form>
<script type="text/javascript">
	function registForm(){
		location.href="userController.jsp?command=registform";
	}
</script>
</body>
</html>





