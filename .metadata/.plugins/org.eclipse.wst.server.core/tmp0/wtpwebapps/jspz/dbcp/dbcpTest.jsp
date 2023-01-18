<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dbcpTest.jsp</title>
</head>
<body>
	<h3>DBCP ; DataBase Connection Pool test</h3>
	<%
	//application 객체의 con 속성에서 Connection 객체 받아오기
	Connection con = (Connection) application.getAttribute("con");
	//Statement 객체 stmt 생성
	PreparedStatement stmt;
	String query = "SELECT * FROM book";
	stmt = con.prepareStatement(query);
	//쿼리 실행 결과를 ResultSet으로 저장
	ResultSet rs = stmt.executeQuery();
	%>
	<table border="1" width="500">
		<caption>BOOK LIST</caption>
		<thead>
			<tr>
				<th>No.</th>
				<th>책 id</th>
				<th>책 제목</th>
				<th>출판사</th>
			</tr>
		</thead>
		<tbody>
			<%
			while (rs.next()) {
			%>
			<tr>
				<td></td>
				<td><%=rs.getInt("bookid")%></td>
				<td><%=rs.getString("bookname")%></td>
				<td><%=rs.getString("publisher")%></td>
			</tr>
			<%
			}
			rs.close();
			stmt.close();
			%>
		</tbody>

	</table>


</body>
</html>