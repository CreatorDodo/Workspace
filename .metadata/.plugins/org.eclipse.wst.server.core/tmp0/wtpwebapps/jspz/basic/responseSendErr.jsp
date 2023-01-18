<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>responseSendErr.jsp</title>
</head>
<body>
	<h3>response.sendError( )</h3>
	<% response.sendError(404, "해당 페이지 X"); %>
</body>
</html>