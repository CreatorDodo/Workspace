<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/upload/formAction.jsp</title>
</head>
<body>

	
	<h3>SPRING FILE UPLOAD</h3>
	<form action="/upload/formAction" method="post" enctype="multipart/form-data">
	<input type="file" name="uploadFile" multiple="multiple"><hr>
	<input type="submit" value="upload">	
	</form>

</body>
</html>