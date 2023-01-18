<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exceptionTry.jsp</title>
</head>
<body>
	<h3>make exceptions</h3>
<%	
	
		try {
			throw new NullPointerException();	//NullPointerException 발생 시키기
// 			throw new ArrayIndexOutOfBoundsException(); //ArrayIndexOutOfBoundsException 발생 시키기
// 		Integer.parseInt("일");	//NumberFormatException 발생 시키기
	} catch(Exception e) {	//try catch로 잡기
		//예외가 발생하면
		request.setAttribute("e", e.getClass().getName());//요청객체의 e 속성에 발생한 예외의 이름을 저장하고,
		pageContext.forward("exceptionCatch.jsp");//pageContext 객체를 이용하여 exceptionCatch.jsp로 전송하기
	}
	


%>
</body>
</html>