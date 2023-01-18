<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getPost.jsp</title>
</head>
<body>
	<h3>get vs. Post</h3>
	<form action="/jspz/Hello.do" method="get">
	이름 <input type="text" name="name" size="10"><br>
	나이 <input type="text" name="age" size="10"> <input type="submit" value="GET">
	</form>
	<hr>
	<form action="/jspz/Hello.do" method="post">
	이름 <input type="text" name="name" size="10"><br>
	나이 <input type="text" name="age" size="10"><input type="submit" value="POST">
	</form>
	<hr>
	<form action="request.jsp" method="post">
	이름 <input type="text" name="name" size="10"><br>
	나이 <input type="text" name="age" size="10"><br>
	성별 <input type="radio" name="gender" value="남자">남자
		<input type="radio" name="gender" value="여자">여자<br>
	혈액형<select name="type">
			<option>A</option>
			<option>B</option>
			<option>O</option>
			<option>AB</option>
		</select><br>
	좋아하는 계절
		<input type="checkbox" name="season" value="봄">봄
		<input type="checkbox" name="season" value="여름">여름
		<input type="checkbox" name="season" value="가을">가을
		<input type="checkbox" name="season" value="겨울">겨울
		<input type="submit" value="POST">
	</form>
</body>
</html>