<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>out.jsp</title>
</head>
<body>
	<h3>내장 객체 out</h3>
	클라이언트로 컨텐츠를 전송하기 위해 사용하는 출력 스트림<br>
	- JspWriter 타입<br>
	- 자동 버퍼링<br>
	default buffer size : <%=out.getBufferSize() %><br>
	remain buffer size : <%=out.getRemaining() %><br>
	autoFlush : <%=out.isAutoFlush() %><br>
	<% out.print("내장 객체 out"); %>
</body>
</html>