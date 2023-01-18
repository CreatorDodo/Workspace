<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.addHeader("Cache-Control", "no-store");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>responseNew.jsp</title>
</head>
<body>
	<h3>new response page</h3>
	<!-- 요청 객체의 code 속성의 값을 화면에 출력 -->
	code : <%=request.getAttribute("code") %> <br>
	
	<!-- 요청 객체의 code 파라미터의 값을 화면에 출력 -->
	code : <%=request.getParameter("code") %> <br>

	<hr>
	이 페이지는 5초마다 새로고침 됩니다.<br>
	
<%	response.setIntHeader("Refresh", 5);
	out.print(new java.util.Date());
%>

</body>
</html>