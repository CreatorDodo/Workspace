<%@page import="java.lang.ProcessBuilder.Redirect"%>
<%@page import="market.vo.ProductVO"%>
<%@page import="market.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"%>
<%@page import="com.oreilly.servlet.MultipartRequest,
    		com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<%	//productRemoveProc.jsp

	//0.한글 인코딩 처리
	request.setCharacterEncoding("UTF-8");						
	response.setContentType("text/html; charset=UTF-8");

%>
	
	<jsp:useBean id="pdao" class="market.dao.ProductDAO"/>

	<sql:setDataSource 
			var="dataSource"
			driver="oracle.jdbc.OracleDriver"
			url="jdbc:oracle:thin:@localhost:1521:xe"
			user="madang"
			password="1111" />
			
	<sql:update var="result" dataSource="${dataSource }">
	DELETE product where pid=?
		<sql:param value="${param.pid }"/>
	</sql:update>
	result : ${result }
<%
	session.setAttribute("msg", "상품 삭제 완료");
	response.sendRedirect("productEdit.jsp?edit=remove");
%>


<%-- <% --%>
// 	//상품 등록 성공 시
// 	if( pdao.insertProduct(p) == true ) {
// 		//응답 객체를 이용하여 상품 목록 페이지로 리다이렉트
// 		response.sendRedirect("productEdit.jsp?edit=remove");
// 	}
<%-- %> --%>
		
<%-- <% } %>	 --%>

<!--  %> -->




