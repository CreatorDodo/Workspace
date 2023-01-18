<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="mdao" class="market.dao.MemberDAO"/>

<%
String id = request.getParameter("id");

if (mdao.memberCheck(id)) {
	out.println("이미 사용 중인 아이디입니다.");
} else {
	out.println("사용 가능한 아이디입니다.");
}
%>