<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uploadForm.jsp</title>
</head>
<body>
	<h3>FILE UPLOAD with cos.jar</h3>
	<form action="uploadResult.jsp" method="post" enctype="multipart/form-data">
	이름 : <input type="text" name="usernm"><br>
	첨부파일 : <input type="file" name="userfile" multiple="multiple"><hr>
	<input type="submit" value="전송">	
	</form>

</body>
</html>