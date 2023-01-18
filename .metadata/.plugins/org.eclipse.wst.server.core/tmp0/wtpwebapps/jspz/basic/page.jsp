<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info="PAGE DIRECTIVE INFO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page.jsp</title>
</head>
<body>
	<h3>내장 객체 page</h3>
	- JSP 자체를 나타내는 객체
	<br> - 클라이언트에게 응답을 보내거나 포워딩이 발생하면 없어짐
	<br> - this 키워드로 자기 자신 참조 가능
	<br> - page 영역에 존재하는 참조 객체들은 pageContext 객체에 저장
	<br> - page 지시자의 info 속성 값 :
	<%=this.getServletInfo()%><br> - flag 파라미터의 값 :
	<%=request.getParameter("flag")%><br>
	<%
	if (request.getParameter("flag").equals("t")) {
		pageContext.include("top.jsp");
	} else {
		pageContext.forward("menu.jsp");
	}
	%>


	<!-- flag가 t이면 top.jsp를 인클루드
		그렇지 않으면 menu.jsp로 포워드 -->

</body>
</html>