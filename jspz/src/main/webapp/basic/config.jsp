<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>config.jsp</title>
</head>
<body>
	<h3>내장 객체 config</h3>
	- 서블릿이 초기화될 때 파라미터 값 저장 및 전달<br>
	- init parameter codeOne : <%=config.getInitParameter("codeOne") %>
	<br>
	- context parameter adminEmail : <%=application.getInitParameter("adminEmail") %>
	
	
	
</body>
</html>