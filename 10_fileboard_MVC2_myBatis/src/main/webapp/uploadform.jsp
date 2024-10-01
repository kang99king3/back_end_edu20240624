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
<!-- 			<td><input type="file" name="filename" multiple="multiple"/></td> -->
			<td>
				<input type="file" name="filename"/>
			</td>
		</tr>
		<tr>
			<th>다운로드:</th>
			<td><a href="downloadlist.file">파일목록</a></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="업로드"/></td>
		</tr>
	</table>
</form>
<form action="filemultiupload.file" method="post" 
							   enctype="multipart/form-data">
	<table border="1">
		<tr>
			<th>파일:</th>
<!-- 			<td><input type="file" name="filename" multiple="multiple"/></td> -->
			<td>
				<input type="file" name="filename1"/>
				<input type="file" name="filename2"/>
				<input type="file" name="filename3"/>
			</td>
		</tr>
		<tr>
			<th>다운로드:</th>
			<td><a href="downloadlist.file">파일목록</a></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="업로드"/></td>
		</tr>
	</table>
</form>
</body>
</html>







