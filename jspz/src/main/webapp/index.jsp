<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<%-- <%= 3 + 4 %> --%>
	<h3>INDEX PAGE</h3>
	<!-- 1. 쿼리스트링을 이용하여 요청 객체의 파라미터 code에 1111을 저장하여
	 		session.jsp 페이지로 이동하는 링크 작성
	 	 2. 요청 객체의 code 속성에 2222를 저장
	 	 3. 세션 객체의 code 속성에 3333을 저장 -->
	<a href="basic/session.jsp?code=1111">code 1111</a>
	<%  request.setAttribute("code", 2222);
		session.setAttribute("code", 3333); %>
	<jsp:forward page="basic/session.jsp">
		<jsp:param value="1111" name="code"/>
	</jsp:forward>
</body>
</html>