<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/sample/uploadEX.jsp</title>
</head>
<body>

	
	<h3>FILE UPLOAD in SPRING</h3>
	<form action="/sample/uploadEX" method="post" enctype="multipart/form-data">
	1 : <input type="file" name="files"><br>
	2 : <input type="file" name="files"><br>
	3 : <input type="file" name="files"><br>
	<input type="submit" value="전송">	
	</form>
	
	
	
</body>
</html>