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
<title>sqlUpdate.jsp</title>
</head>
<body>



	<h3>JSTL SQL - UPDATE</h3>
	
	<sql:setDataSource  
			var="dataSource" 		driver="oracle.jdbc.OracleDriver" 
			url="jdbc:oracle:thin:@localhost:1521:xe" 
			user="madang" 
 			password="1111" /> 
			
	<sql:query var="rs" dataSource="${dataSource }"> 
	SELECT * FROM book WHERE bookid=?
		<sql:param value="${param.bookid }"/> 
	</sql:query> 

	
	<h4>BOOK MODIFY</h4>
	<c:forEach items="${rs.rows }" var="row"> 
	<form action="sqlUpdateProc.jsp" method="post">
	BOOK ID 　　<input type="number" name="bookid" value="${row.bookid }" readonly="readonly"><br>
	BOOK NAME <input type="text" name="bookname" value="${row.bookname }"><br>
	PUBLISHER 　<input type="text" name="publisher" value="${row.publisher }"><br>
	PRICE 　　　<input type="number" name="price" value="${row.price }"><hr>
			<input type="submit" value="수정">
			<input onclick="removeChk('${row.bookid}')" type="button" value="삭제">
	</form>
	</c:forEach> 

<script>
function removeChk(bookid) {
	if(confirm('정말 삭제하시겠습니까?')) {
		location.href = 'sqlDeleteProc.jsp?bookid=' + bookid;
	}


}
</script>

</body>
</html>