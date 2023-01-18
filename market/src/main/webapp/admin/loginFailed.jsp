<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//	/admin/login.jsp로 이동
	response.sendRedirect("../admin/login.jsp?msg=loginFail");
%>