<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
//cartClearProc.jsp--------------------------------------

//1.세션에서 cartList 속성 지우기
session.removeAttribute("cartList");

//2.장바구니 페이지로 이동
response.sendRedirect("cart.jsp");
%>		
