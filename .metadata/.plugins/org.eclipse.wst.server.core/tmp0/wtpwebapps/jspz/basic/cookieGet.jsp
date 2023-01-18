<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookieGet.jsp</title>
</head>
<body>
	<h3>get cookie</h3>
<%
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie : cookies){
		out.print(cookie.getName() + " : " +
				  cookie.getValue() + "<br>");
	}
%>	쿠키 개수 : <%=cookies.length %>
	<hr>
	<a href="cookieSet.jsp">cookieSet.jsp</a>
	<a href="cookieDel.jsp">cookieDel.jsp</a>
</body>
</html>