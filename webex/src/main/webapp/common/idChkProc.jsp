<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");

if (id.equals("admin")) {
	out.println("이미 사용 중인 아이디입니다.");
} else {
	out.println("사용 가능한 아이디입니다.");
}
%>