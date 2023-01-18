<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% //sqlUpdateProc.jsp
//0.한글 인코딩 처리
// request.setCharacterEncoding("UTF-8");						
// response.setContentType("text/html; charset=UTF-8");
	//액션 태그를 이용하여 파라미터로 전달된 값을 BookVO 객체 bvo에 저장
%>

	<jsp:useBean id="bvo" class="jspz.bean.BookVO"/>
	<jsp:setProperty property="*" name="bvo"/>



	
	
	
	<sql:setDataSource 
			var="dataSource"
			driver="oracle.jdbc.OracleDriver"
			url="jdbc:oracle:thin:@localhost:1521:xe"
			user="madang"
			password="1111" />
			
	<sql:update var="result" dataSource="${dataSource }">
	UPDATE book SET bookname=?, publisher=?, price=? where bookid=?
		<sql:param value="${bvo.bookname }"/>
		<sql:param value="${bvo.publisher }"/>
		<sql:param value="${bvo.price }"/>
		<sql:param value="${bvo.bookid }"/>
	</sql:update>
	result : ${result }
<%
	//세션의 msg 속성에 '책 수정 성공'을 저장하고
	session.setAttribute("msg", "책 수정 성공");
	//책 목록으로 리다이렉트
	response.sendRedirect("sqlSelect.jsp");
%>
	