<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<% // //0.한글 인코딩 처리

// request.setCharacterEncoding("UTF-8");						
// response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sqlInsert.jsp</title>
</head>
<body>
	<h3>JSTL SQL - SELECT</h3>
	

	
	<h4>BOOK ADD</h4>
	<form action="sqlInsertProc.jsp" method="post">
	BOOK ID 　　<input type="number" name="bookid"><br>
	BOOK NAME <input type="text" name="bookname"><br>
	PUBLISHER 　<input type="text" name="publisher"><br>
	PRICE 　　　<input type="number" name="price"><hr>
			<input type="submit" value="등록">
	</form>
	
</body>
</html>