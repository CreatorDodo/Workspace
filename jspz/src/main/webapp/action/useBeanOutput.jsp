<%@page import="jspz.bean.TestBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jspz.bean.TestBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>useBeanOutput.jsp</title>
</head>
<body>
	<h3>useBean action tag</h3>
	1.스크립트릿으로 요청 객체의 tb1 속성 값 받아오기<br>
<%
	TestBean tb1 = (TestBean) request.getAttribute("tb1");
%>	출신 국가 : <%=tb1.getCountry() %><br>
	출신 도시 : <%=tb1.getCity() %><br>
	이름 : <%=tb1.getName() %><br>
	tbb : <%= request.getAttribute("tbb") %>
	
	<hr>	
	
	<!-- 액션태그를 이용하여 TestBean 클래스의 객체 tb2 생성 -->
	2.액션태그를 이용<br>
	<jsp:useBean id="tb2" class="jspz.bean.TestBean" scope="request"/>
	출신 국가 : <jsp:getProperty property="country" name="tb2"/><br>
	출신 도시 : <jsp:getProperty property="city" name="tb2"/><br>
	이름 : <jsp:getProperty property="name" name="tb2"/><br>
</body>
</html>