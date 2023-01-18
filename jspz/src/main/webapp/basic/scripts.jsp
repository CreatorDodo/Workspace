<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scripts.jsp</title>
</head>
<body>
	<h3>JSP 스크립트 요소</h3>
	<ul><li>선언문declaration &lt;%! ... %&gt;<br>
		<li>스크립트릿scriptlet &lt;% ... %&gt;<br>
		<li>표현식expression &lt;%= ... %&gt;<br>
		<li>주석comment &lt;%-- ... --%&gt;<br>
	</ul>
<%! String name = "Kim"; %>	
<% String userid = "aaa"; %>	
<%=name %>
<% out.println(name); %>

<%--String userid = "aaa"; --%>
</body>
</html>