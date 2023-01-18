<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>includeAction.jsp</title>
</head>
<body>
	<jsp:include page="../basic/top.jsp"/>
	<hr>
	<h3>include action tag</h3>
	<hr>
	<jsp:include page="../basic/menu.jsp">
		<jsp:param value="green potato"
					name="newMenu"/>
	</jsp:include>

</body>
</html>