<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
String memo = request.getParameter("memo");


	out.println(memo + " | by " + id);
%>