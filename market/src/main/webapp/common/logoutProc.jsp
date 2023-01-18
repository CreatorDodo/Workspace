<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	//logoutProc.jsp

	//세션 무효화
	session.invalidate();

	//messages.jsp 페이지로 리다이렉트
	response.sendRedirect("messages.jsp?msg=logout");



%>
