<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Date" %>
<%@page import="java.util.Calendar"
		import="java.util.*, java.io.*" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pageDirective.jsp</title>
</head>
<body>
<%
	java.util.Date today = new Date();
	out.print(today.toLocaleString());
	
	Calendar cal = Calendar.getInstance();
%>
	<hr>
	<%=cal.get(Calendar.HOUR_OF_DAY) %> :
	<%=cal.get(Calendar.MINUTE) %> :
	<%=cal.get(Calendar.SECOND) %>
</body>
</html>