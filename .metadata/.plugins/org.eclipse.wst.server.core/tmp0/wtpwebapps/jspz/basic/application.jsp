<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application.jsp</title>
</head>
<body>
	<h3>내장 객체 application</h3>
	- 컨텍스트가 초기화될 때 파라미터 값 저장 및 전달<br>
	- init parameter codeOne : <%=config.getInitParameter("codeOne") %>
	<br>
	- context parameter adminEmail : <%=application.getInitParameter("adminEmail") %>
	
	<hr>
	server info : <%=application.getServerInfo() %><br>
	context path : <%=application.getContextPath() %><br>
	real path : <%=application.getRealPath(".") %><br>
</body>
</html>