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
<h1>파일업로드</h1>
<form action="fileupload.file" method="post" 
							   enctype="multipart/form-data">
	<table border="1">
		<tr>
			<th>파일:</th>
			<td><input type="file" name="filename"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="업로드"/></td>
		</tr>
	</table>
</form>
</body>
</html>







