<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- errorPage="exceptionHandle.jsp" -->
<!DOCTYPE html><!-- ↑ 1.page 지시자를 이용하여
						예외를 처리할 페이지 지정 -->
<html>
<head>
<meta charset="UTF-8">
<title>exception.jsp</title>
</head>
<body>
	<h3>make arithmetic exception</h3>
	<%=10/0 %>
</body>
</html>