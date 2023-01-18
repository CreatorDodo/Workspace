<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cookieDel.jsp</title>
</head>
<body onload="window.open('popup.jsp', '_blank', 'width=300, height=250, left=500, top=300')">
	<h3>delete cookie</h3>
<%
Cookie[] cookies = request.getCookies();
	//쿠키 이름이 level 지우기
	for(Cookie cookie : cookies) {
		if(cookie.getName().equals("level")){
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		}
	}
%>
	<script>
// 		window.open('popup.jsp', ''
// 					'width=250,height=200,left=500,top=300');
	
	</script>
</body>
</html>