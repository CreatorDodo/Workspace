<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useBeanInput.jsp</title>
</head>
<body>
	<h3>useBean action tag</h3>
	<form action="useBeanProc.jsp">
	출신 국가 : <input type="text" name="country" size="10"><br>
	출신 도시 : <input type="text" name="city" size="10"><br>
	이름 : <input type="text" name="name" size="10">
	<input type="submit" value="전송">
	</form>
</body>
</html>