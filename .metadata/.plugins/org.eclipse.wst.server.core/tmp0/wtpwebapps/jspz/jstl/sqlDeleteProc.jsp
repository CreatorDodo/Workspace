<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% //sqlDeleteProc.jsp
////0.한글 인코딩 처리

//request.setCharacterEncoding("UTF-8");						
//response.setContentType("text/html; charset=UTF-8");

	//액션 태그를 이용하여 파라미터로 전달된 값을 BookVO 객체 bvo에 저장
%>

<%-- 	<jsp:useBean id="bvo" class="jspz.bean.BookVO"/> --%>
<%-- 	<jsp:setProperty property="*" name="bvo"/> --%>



	
	
	
	<sql:setDataSource 
			var="dataSource"
			driver="oracle.jdbc.OracleDriver"
			url="jdbc:oracle:thin:@localhost:1521:xe"
			user="madang"
			password="1111" />
			
	<sql:update var="result" dataSource="${dataSource }">
	DELETE book where bookid=?
		<sql:param value="${param.bookid }"/>
	</sql:update>
	result : ${result }
<%
	session.setAttribute("msg", "책 삭제 완료");
	response.sendRedirect("sqlSelect.jsp");
%>