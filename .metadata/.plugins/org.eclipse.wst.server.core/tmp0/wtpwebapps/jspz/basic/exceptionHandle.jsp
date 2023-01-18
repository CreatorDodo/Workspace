<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exceptionHandle.jsp</title>
</head>
<body>
	<h3>예외 발생</h3>
	페이지 처리 중 문제가 발생했습니다.<br>
	관리자에게 문의해주세요.
	<hr>
	<br>[예외 객체] <%=exception %>
	<br>[예외 타입] <%=exception.getClass().getName() %>
	<br>[예외 메시지] <%=exception.getMessage() %>
	<br>[예외 메시지] <%=request.getAttribute("javax.servlet.error.status_code") %>
	<br>[예외 발생 위치] <%=request.getAttribute("javax.servlet.error.request_uri") %>
</body>
</html>