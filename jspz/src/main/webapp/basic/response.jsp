<%@page import="java.net.URLEncoder"%>
<%@page import="javax.tools.DocumentationTool.Location"%>
<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response.jsp</title>
</head>
<body>
	<h3>내장 객체 response</h3>
	- 클라이언트에게 응답을 제공<br>
	- 응답 헤더 설정 : setHeader( )<br>
	- 다른 페이지로 리다이렉트 : sendRedirect( )<br>
	- 쿠키 추가 : addCookie( ) <br>
	<!-- 요청 객체의 code 속성에 1234를 저장하고-->
			
<!-- 			responseNew.jsp로 리다이렉트 -->
	<% request.setAttribute("code", 1234);
// 	   response.sendRedirect("responseNew.jsp");
// 	   response.sendRedirect("responseNew.jsp?code=1234");
	   
	   String keyword = "JSP프로그래밍";
	   String url = "https://search.naver.com/search.naver?where=nexearch&query=";
// 	   keyword = URLEncoder.encode(keyword, "EUC-KR");
	   keyword = URLEncoder.encode(keyword, "UTF-8");
	   response.sendRedirect(url + keyword);
	   %>
	
<!-- 	responseNew.jsp 페이지로 포워딩 -->
<%-- 	<jsp:forward page="responseNew.jsp"/> --%>
	
</body>
</html>