<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jspz.bean.TestBean" %>	
<%
//	useBeanProc.jsp

//	파라미터로 전달되는 country, city, name 값을 받아서
	String country  = request.getParameter("country");
	String city 	= request.getParameter("city");
	String name 	= request.getParameter("name");

//	TestBean 객체 tb1에 저장
	//1.스크립트릿
	TestBean tb1 = new TestBean();
	tb1.setCountry(country);
	tb1.setCity(city);
	tb1.setName(name);
	request.setAttribute("tb1", tb1);
	//요청객체의 tb1 속성에 tb1 객체 저장
	request.setAttribute("tbb", "test");


	System.out.println(tb1);

	//2.액션 태그
%>	
<%-- 	<jsp:useBean id="tb2" class="jspz.bean.TestBean" scope="request"/> --%>
<%-- 	<jsp:setProperty property="country" name="tb2"/> --%>
<%-- 	<jsp:setProperty property="city" name="tb2"/> --%>
<%-- 	<jsp:setProperty property="name" name="tb2"/> --%>
	
<%-- 	<jsp:useBean id="tb3" class="jspz.bean.TestBean"/> --%>
<%-- 	<jsp:setProperty property="*" name="tb3"/> --%>
	
	
	
<%-- <%  System.out.println(tb2); --%>
<%-- 	System.out.println(tb3); %> --%>
	
	<jsp:forward page="useBeanOutput.jsp"/>