<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	//0.한글 인코딩 처리
// 	request.setCharacterEncoding("UTF-8");						
// 	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sqlSelect.jsp</title>
</head>
<body>
	<h3>JSTL SQL - SELECT</h3>
	

	<sql:setDataSource 
			var="dataSource"
			driver="oracle.jdbc.OracleDriver"
			url="jdbc:oracle:thin:@localhost:1521:xe"
			user="madang"
			password="1111" />
			
	<sql:query var="rs" dataSource="${dataSource }">
		SELECT * FROM book
	</sql:query>
	
<!-- 	<table border="1" width="500"> -->
<%-- 	<caption>BOOK INFO</caption> --%>
<!-- 	<thead> -->
<!-- 	<tr> -->
<%-- 		<c:forEach items="${rs.columnNames }" var="colNm"> --%>
<%-- 			<th><c:out value="${ colNm}"/></th> --%>
<%-- 		</c:forEach> --%>
<!-- 	</tr> -->
<!-- 	</thead> -->
<!-- 	<tbody> -->
<%-- 		<c:forEach items="${rs.rowsByIndex }" var="row"> --%>
<%-- 		<tr><c:forEach items="${row }" var="colVal"> --%>
<%-- 			<td><c:out value="${colVal}"/></td> --%>
<%-- 			</c:forEach> --%>
<!-- 		</tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</tbody> -->
	
<!-- 	</table> -->
	
<!-- 	<hr> -->
	
	
<!-- 	<table border="1" width="500"> -->
<%-- 	<caption>BOOKVO INFO</caption> --%>
<!-- 	<thead> -->
<!-- 	<tr> -->
<!-- 		<th>No.</th> -->
<!-- 		<th>책 id</th> -->
<!-- 		<th>책 제목</th> -->
<!-- 		<th>출판사</th> -->
<!-- 	</tr> -->
<!-- 	</thead> -->
<!-- 	<tbody> -->
<%-- 		<c:forEach items="${rs.rows }" var="bvo" varStatus="i"> --%>
<!-- 		<tr> -->
<%-- 			<td><c:out value="${i.count}"/></td> --%>
<%-- 			<td><c:out value="${bvo.bookid}"/></td> --%>
<%-- 			<td><c:out value="${bvo.bookname}"/></td> --%>
<%-- 			<td><c:out value="${bvo.publisher}"/></td> --%>
<!-- 		</tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</tbody> -->
	
<!-- 	</table> -->
	
	<table border="1" width="500">
	<caption>BOOKVO INFO</caption>
	<thead>
	<tr>
		<th>No.</th>
		<th>책 id</th>
		<th>책 제목</th>
		<th>출판사</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach items="${rs.rows }" var="bvo" varStatus="i">
		<tr>
			<td><a style="text-decoration: none;" href="sqlUpdate.jsp?bookid=${bvo.bookid}&bookname=${bvo.bookname}&publisher=${bvo.publisher}&price=${bvo.price}">
			<c:out value="${bvo.bookid}"/></a></td>
			<td><a style="text-decoration: none;" href="sqlUpdate.jsp?bookid=${bvo.bookid}&bookname=${bvo.bookname}&publisher=${bvo.publisher}&price=${bvo.price}">
			<c:out value="${bvo.bookname}"/></a></td>
			<td><a style="text-decoration: none;" href="sqlUpdate.jsp?bookid=${bvo.bookid}&bookname=${bvo.bookname}&publisher=${bvo.publisher}&price=${bvo.price}">
			<c:out value="${bvo.publisher}"/></a></td>
			<td><a style="text-decoration: none;" href="sqlUpdate.jsp?bookid=${bvo.bookid}&bookname=${bvo.bookname}&publisher=${bvo.publisher}&price=${bvo.price}">
			<c:out value="${bvo.price}"/></a></td>
		</tr>
		</c:forEach>
	</tbody>
	
	</table>
	
	<a href="sqlInsert.jsp">책 등록</a>
	
	<!-- 세션의 msg 속성 값이 있으면 경고창으로 출력 후,
		 세션에서 삭제 -->
		 
		 <c:if test="${!empty msg || msg != null }">
		 <script>
		 	alert("${msg}");
		 </script>
		 </c:if>
		 <%session.removeAttribute("msg"); %>
		 
	
	
	
	
	
	
	
	
</body>
</html>