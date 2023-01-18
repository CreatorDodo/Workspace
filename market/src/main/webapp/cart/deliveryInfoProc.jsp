<%@page import="java.net.URLEncoder"%>
<%@page import="javax.websocket.Session"%>
<%@page import="java.util.*"%>
<%@page import="market.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="pdao" class="market.dao.ProductDAO" />
<%
//deliveryInfoProc.jsp--------------------------------------

	//0.한글 인코딩 처리
	request.setCharacterEncoding("UTF-8");						
	response.setContentType("text/html; charset=UTF-8");

	//배송 정보를 쿠키에 저장하고
	Cookie cartId = new Cookie("cartId", session.getId());
	Cookie rname = new Cookie("rname", request.getParameter("rname"));
	Cookie deliveryDate = new Cookie("deliveryDate", request.getParameter("deliveryDate"));
	Cookie phone = new Cookie("phone", request.getParameter("phone"));
	Cookie zipNo = new Cookie("zipNo", request.getParameter("zipNo"));
	Cookie addr1 = new Cookie("addr1", URLEncoder.encode(request.getParameter("addr1"), "UTF-8"));
	Cookie addr2 = new Cookie("addr2", URLEncoder.encode(request.getParameter("addr2"), "UTF-8"));
	Cookie addr3 = new Cookie("addr3", URLEncoder.encode(request.getParameter("addr3"), "UTF-8"));
	
	//쿠키의 유효기간은 1년으로 설정한 후
	cartId.setMaxAge(60 * 60 * 24 * 365);
	rname.setMaxAge(60 * 60 * 24 * 365);
	phone.setMaxAge(60 * 60 * 24 * 365);
	zipNo.setMaxAge(60 * 60 * 24 * 365);
	addr1.setMaxAge(60 * 60 * 24 * 365);
	addr2.setMaxAge(60 * 60 * 24 * 365);
	addr3.setMaxAge(60 * 60 * 24 * 365);
	deliveryDate.setMaxAge(60 * 60 * 24 * 365);
	
	response.addCookie(cartId);
	response.addCookie(rname);
	response.addCookie(phone);
	response.addCookie(zipNo);
	response.addCookie(addr1);
	response.addCookie(addr2);
	response.addCookie(addr3);
	response.addCookie(deliveryDate);
	
	response.sendRedirect("orderInfo.jsp");	//orderInfo.jsp로 이동
%>