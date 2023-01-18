<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String pw = request.getParameter("pw");

if (pw.equals("1111")) {
	out.println("");
} else {
	out.println("비밀번호가 일치하지 않습니다.");
}
%>