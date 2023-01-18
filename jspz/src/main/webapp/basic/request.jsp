<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"%>
<% request.setCharacterEncoding("UTF-8");						//수신 데이터 한글 처리
	response.setContentType("text/html; charset=UTF-8");		//송신 데이터 한글 처리 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request.jsp</title>
</head>
<body>
	<h3>내장 객체 request</h3>
	- 클라이언트와 서버 관련 정보 읽기<br>
	- 클라이언트가 전송한 데이터 가져오기<br>
	- 속성 객체 처리
	<hr>
	<h3>클라이언트 / 서버  관련 정보</h3>
	server name : <%=request.getServerName() %><br>
	server address : <%=request.getLocalAddr() %><br>
	server port : <%=request.getServerPort() %><br>
	<br>
	client address : <%=request.getRemoteAddr() %><br>
	client port : <%=request.getRemotePort() %><br>
	<br>
	request URL : <%=request.getRequestURL() %><br>
	request URI : <%=request.getRequestURI() %><br>
	<br>
	context path : <%=request.getContextPath() %><br>
	servlet path : <%=request.getServletPath() %><br>
	real servlet path :
		<%=request.getRealPath(request.getServletPath()) %><br>
		<%=application.getRealPath(request.getServletPath()) %><br>
	
	<hr>
	<h3>클라이언트 전송 데이터</h3>
	msg 파라미터의 값 : <%=request.getParameter("msg")%>	<br>
	query string : <%=request.getQueryString()%>	<br>
	client browser : <%=request.getHeader("User-Agent") %><br>
	accept file type :  <%=request.getHeader("Accept") %><br>
	
	<hr>
	<h3>요청 헤더 정보</h3>
<%	//헤더이름 : 헤더값
	Enumeration<String> en = request.getHeaderNames();
	while(en.hasMoreElements()) {
		String key = en.nextElement();
		out.print(key + " : " +
					request.getHeader(key) + "<br>");
	}
%>
	<hr>
	<h3>요청 파라미터 처리</h3>

	이름 : <%=request.getParameter("name") %><br>
	나이 : <%=request.getParameter("age") %><br>
	성별 : <%=request.getParameter("gender") %><br>
	혈액형 : <%=request.getParameter("type") %><br>
	좋아하는 계절 : <%=request.getParameter("season") %><br>
	좋아하는 계절들 :
<%
	String[] seasons = request.getParameterValues("season");
	for(String season : seasons) {
		out.print(season + " ");
	}
%>
</body>
</html>