<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");

if (id.equals("admin")) {
	out.println("관리자 로그인 성공");
} else {
	out.println("일반 사용자");
}
%>