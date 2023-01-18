<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>basic.jsp</title>
</head>
<body>
	<h3>Expression Language</h3>

<%	
//이름만 명시하는 경우 page > request > session > application 순서로 찾음
pageContext.setAttribute("msg", "Hello pageContext");
request.setAttribute("msg", "Hello request");
session.setAttribute("msg", "Hello session");
application.setAttribute("msg", "Hello application");
Cookie cookies = new Cookie("msg", "HelloCookie");
response.addCookie(cookies);



%>
	<br>${msg }
	<br>${pageScope.msg }
	<br>${requestScope.msg }
	<br>${sessionScope.msg }
	<br>${applicationScope.msg }
	<br>${cookie.msg.value }<br>
	
	<br>${param.msg }
	<br>${param["msg"] }
	<br>${param['msg'] }<br>
	
	<br>${paramValues.type[0] }
	<br>${paramValues.type[1] }
	<br>${paramValues.type[2] }<br>
	
	<br>${header.host }
	<br>${header["User-Agent"] }
	<br>${headerValues.Accept }
	<br>${headerValues.Accept[0] }<br>
	
	<br>${initParam.adminEmail }
	<br>${pageContext.request.requestURI }
<hr>
<br>type 파라미터의 값 : 
<%-- <% String[] types = request.getParameterValues("type"); --%>
// 	out.print(types[0] + " " + types[1] + " " + types[2]);
<%-- %> --%>
<br>표현식 msg : <%= request.getAttribute("msg") %>
<br>스크립트릿 msg :	<% out.print(request.getAttribute("msg")); %>



</body>
</html>