<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forwardAction.jsp</title>
</head>
<body>
	<jsp:forward page="../basic/top.jsp"/>
	<hr>
	<h3>forward action tag</h3>
	<hr>
	<jsp:forward page="../basic/menu.jsp">
		<jsp:param value="green potato"
					name="newMenu"/>
	</jsp:forward>

</body>
</html>