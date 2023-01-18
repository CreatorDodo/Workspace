<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exceptionCatch.jsp</title>
</head>
<body>
	<div style="text-align: center;">
	<h2>TOTAL exception handle page</h2>
	<img src="../resources/imgs/try.png" style="width: 600px; height: 300px;"><br>
<%
	String e = (String) request.getAttribute("e");//요청 객체의 e 속성 값 가져와서 해당 메시지 표시하기
	String msg = "";
	
			
	switch(e){
	case "java.lang.NumberFormatException" :
		msg = "NumberFormatException이 발생했습니다."; break;
	
	case "java.lang.ArrayIndexOutOfBoundsException" :
		msg = "배열에 벗어나는 예외가 발생했습니다."; break;
	
	default : msg = "예외가 발생했습니다."; break;
	}
%>	<%=msg %>
	
	
	
	



	
	</div>
</body>
</html>