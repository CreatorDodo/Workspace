<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session.jsp</title>
</head>
<body>
	<h3>내장 객체 session</h3>
	- 클라이언트 상태 관련 정보 저장 및 요청 처리<br>
	- 브라우저 접속 시 생성되어, 브라우저를 닫거나 유효시간 경과시 세션 종료
	
	<hr>
<%	Date sessionTime = new Date(session.getCreationTime());
	Date lastAccessTime = new Date(session.getLastAccessedTime());

	if(session.isNew()){
		out.print("세션이 새로 생성됨!!");
	}
%>	
	<br>세션 아이디 : <%= session.getId() %>
	<br>세션 생성 시간 : <%= sessionTime.toLocaleString() %>
	<br>세션 마지막 접속 시간 :  <%= lastAccessTime.toLocaleString() %>
	
	<br>세션 유효시간 : <%= session.getMaxInactiveInterval() %>
	<br>세션 유효시간을 1분으로 설정  <% session.setMaxInactiveInterval(60); %>
	<br>세션 유효시간 : <%= session.getMaxInactiveInterval() %>
	<hr>
	<br>요청 객체의 code 파라미터 값 : <%=request.getParameter("code") %>
	<br>요청 객체의 code 속성 값 : <%=request.getAttribute("code") %>
	<br>세션 객체의 code 속성 값 : <%=session.getAttribute("code") %>
	<br>세션 무효화	<% //session.invalidate(); %>
	<br>세션의 code 속성 삭제 <% //session.removeAttribute("code"); %>
	<br>요청 객체의 code 파라미터 값 : <%=request.getParameter("code") %>
	<br>요청 객체의 code 속성 값 : <%=request.getAttribute("code") %>
	<br>세션 객체의 code 속성 값 : <%=session.getAttribute("code") %>
</body>
</html>