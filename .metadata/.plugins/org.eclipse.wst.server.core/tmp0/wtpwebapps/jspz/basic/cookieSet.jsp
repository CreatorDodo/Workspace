<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookieSet.jsp</title>
</head>
<body>
<%
	Cookie code = new Cookie("code", "5678");
	Cookie level = new Cookie("level", "A");
	
	code.setMaxAge(60); 	 //유효시간 1분
	level.setMaxAge(60 * 3); //유효시간 3분
	level.setValue("B");	 //값 변경
	
	
	
	response.addCookie(code);
	response.addCookie(level);
	response.sendRedirect("cookieGet.jsp");
%>
</body>
</html>