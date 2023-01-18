<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%-- menu.jsp --%>
<strong>TODAY'S SPECIAL</strong><br>
- orange juice<br>
- apple coffee<br>
- white cocoa


<%
	String newMenu = request.getParameter("newMenu");

	if(newMenu != null) {
		out.print("<br>- " + newMenu);
	}
%>	
<hr>
<%
	java.util.Date today = new Date();
	out.print(today.toLocaleString());
%>


<hr>
		<br>요청 객체의 code 파라미터 값 : <%=request.getParameter("code") %>
	<br>요청 객체의 code 속성 값 : <%=request.getAttribute("code") %>
	<br>세션 객체의 code 속성 값 : <%=session.getAttribute("code") %>
