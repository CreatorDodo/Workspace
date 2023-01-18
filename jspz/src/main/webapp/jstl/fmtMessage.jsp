<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fmtMessage.jsp</title>
</head>
<body>
	<h3>JSTL formatting message</h3>
	name | greeting<br>
	--------------------------<br>
	<fmt:bundle basename="jspz.bundle.message">
		<fmt:message key="name"/>	|
		<fmt:message key="greeting"/>
	</fmt:bundle>
	
	<br>
	<fmt:setLocale value="en"/>
		<fmt:bundle basename="jspz.bundle.message">
		<fmt:message key="name"/>	|
		<fmt:message key="greeting"/>
	</fmt:bundle>
</body>
</html>