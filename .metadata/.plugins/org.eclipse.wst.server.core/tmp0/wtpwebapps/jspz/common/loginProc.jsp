<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	
<!-- 	2.액션 태그를 이용하여 전달 받은 로그인 파라미터 데이터들을 MemberVO 객체 mvo에 저장 -->
<%-- 	<jsp:setProperty property="*" name="mvo"/> --%>

<%	//loginProc.jsp
	//로그인 성공 시
		request.setCharacterEncoding("UTF-8");						//수신 데이터 한글 처리
		response.setContentType("text/html; charset=UTF-8");		//송신 데이터 한글 처리
		
	
	String id = request.getParameter("userid");
	String pw = request.getParameter("userpw");
	
	if( id == "abc@naver.com" && pw == "0000") {	 //입력받은 아이디와 비밀번호가 member 테이블의 값과 일치하면
		session.setAttribute("sid", id);	//세션의 sid 속성에 로그인 아이디를 저장하고
		response.sendRedirect("messages.jsp?msg=login");	//messages.jsp 페이지로 리다이렉트
	}else { //그렇지 않으면
		response.sendRedirect("messages.jsp?msg=loginNot");	//로그인 화면으로 이동
	}
	
%>






<%-- <%@page import="java.lang.ProcessBuilder.Redirect"%> --%>
<%-- <%@page import="market.vo.MemberVO"%> --%>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%--     pageEncoding="UTF-8"%> --%>

	
<!-- <!-- 	2.액션 태그를 이용하여 전달 받은 로그인 파라미터 데이터들을 MemberVO 객체 mvo에 저장 --> -->
<%-- 	<jsp:useBean id="mdao" class="market.dao.MemberDAO"/> --%>
<%-- 	<jsp:useBean id="mvo" class="market.vo.MemberVO"/> --%>
<%-- 	<jsp:setProperty property="*" name="mvo"/> --%>

<%-- <%	//loginProc.jsp --%>
// 	//로그인 성공 시
// 	if( mdao.isMember(mvo) == true ) {	 //입력받은 아이디와 비밀번호가 member 테이블의 값과 일치하면
// 		session.setAttribute("sid", mvo.getUserid());	//세션의 sid 속성에 로그인 아이디를 저장하고
// 		response.sendRedirect("messages.jsp?msg=login");	//messages.jsp 페이지로 리다이렉트
// 	}else { //그렇지 않으면
// 		response.sendRedirect("login.jsp?msg=loginFail");	//로그인 화면으로 이동
// 	}
	
<%-- %> --%>