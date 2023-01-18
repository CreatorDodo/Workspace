<%@page import="java.security.Principal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>securityProgramming.jsp</title>
</head>
<body>
	<h3>프로그래밍적 시큐리티 </h3>
	사용자명 : <%=request.getRemoteUser() %><br>
	인증방법 : <%=request.getAuthType() %><br>
	인증 사용자 role1 : <%=request.isUserInRole("role1") %><br>
	인증 사용자 tomcat : <%=request.isUserInRole("tomcat")%>
	<hr>
	<% Principal p = request.getUserPrincipal(); %>
	<%=p %><br>
	<%=p.getName() %>
</body>
</html>