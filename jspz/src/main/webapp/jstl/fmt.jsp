<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*, java.text.*" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fmt.jsp</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>
	<fmt:requestEncoding value="UTF-8"/>
	
	
	<h3>JSTL formatting</h3>
	<%	Locale locale = request.getLocale(); %>
	<br>country : <%=locale.getCountry() %>
	<br>display country : <%=locale.getDisplayCountry() %>
	<br>language : <%=locale.getLanguage() %>
	<br>display language : <%=locale.getDisplayLanguage() %>
	
	<hr>
	<% locale = Locale.UK; %>
	<b>change locale to UK</b>
	<br>country : <%=locale.getCountry() %>
	<br>display country : <%=locale.getDisplayCountry() %>
	<br>language : <%=locale.getLanguage() %>
	<br>display language : <%=locale.getDisplayLanguage() %>
	
	<hr>
	<% locale = Locale.JAPAN; %>
	<b>change locale to JAPAN</b>
	<br>country : <%=locale.getCountry() %>
	<br>display country : <%=locale.getDisplayCountry() %>
	<br>language : <%=locale.getLanguage() %>
	<br>display language : <%=locale.getDisplayLanguage() %>
	
	<hr>
<%  response.setHeader("Content-Language", "en"); 
	Date now = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy. mm. dd. hh:mm:ss");

	out.print(now + "<br>");
	out.print(sdf.format(now));


%>
	<hr>
	<h2>문자열 ↔ 날짜</h2>
	<c:set var="d" value="<%=new Date() %>"/>
	${d }
	<hr>
	<h3>type</h3>
	<fmt:formatDate value="${d }"/><br>
	<fmt:formatDate value="${d }" type="date"/><br>
	<fmt:formatDate value="${d }" type="time"/><br>
	<fmt:formatDate value="${d }" type="both"/><br>
	
	<hr>
	<h3>dateStyle</h3>
	<fmt:formatDate value="${d }" type="date" dateStyle="short"/><br>
	<fmt:formatDate value="${d }" type="date" dateStyle="medium"/><br>
	<fmt:formatDate value="${d }" type="date" dateStyle="Long"/><br>
	<fmt:formatDate value="${d }" type="date" dateStyle="full"/><br>
	
	<hr>
	<h3>timeStyle</h3>
	<fmt:formatDate value="${d }" type="time" timeStyle="short"/><br>
	<fmt:formatDate value="${d }" type="time" timeStyle="medium"/><br>
	<fmt:formatDate value="${d }" type="time" timeStyle="Long"/><br>
	<fmt:formatDate value="${d }" type="time" timeStyle="full"/><br>

	<hr>
	<h3>dateStyle & timeStyle</h3>
	<fmt:formatDate value="${d }" type="both" dateStyle="short" timeStyle="short"/><br>
	<fmt:formatDate value="${d }" type="both" dateStyle="medium" timeStyle="medium"/><br>
	<fmt:formatDate value="${d }" type="both" dateStyle="Long" timeStyle="Long"/><br>
	<fmt:formatDate value="${d }" type="both" dateStyle="full" timeStyle="full"/><br>

	<hr>
	<h3>pattern</h3>
	<fmt:formatDate value="${d }" type="date" pattern="yyyy/MM/dd"/><br>
	<fmt:formatDate value="${d }" type="date" pattern="yyyy/MM/dd (E)"/><br>
	<fmt:formatDate value="${d }" type="time" pattern="hh:mm:ss"/><br>
	<fmt:formatDate value="${d }" type="time" pattern="(a) hh:mm:ss"/><br>
	
	<hr>
	<c:set var="str" value="20221122001122"/>
	${str }<br>
	<fmt:parseDate value="${str }" pattern="yyyyMMddHHmmss"/>

	<hr>
	<fmt:formatDate value="${d }" type="both" dateStyle="full" timeStyle="full"/><br>
	<fmt:timeZone value="Europe/London">
	<fmt:formatDate value="${d }" type="both" dateStyle="full" timeStyle="full"/><br>
	</fmt:timeZone>
	
	<fmt:setTimeZone value="America/New_York"/>
	<fmt:formatDate value="${d }" type="both" dateStyle="full" timeStyle="full"/><br>

	<hr>
	<h2>문자열 ↔ 숫자</h2>
	<c:set var="num" value="123456789.09876"/>
	${num }<br>
	
	<fmt:formatNumber value="${num }"/><br>
	<fmt:formatNumber value="${num }" type="number"/><br>
	<fmt:formatNumber value="0.1"    type="percent"/><br>
	<fmt:formatNumber value="${num }" type="currency"/><br>
	<fmt:formatNumber value="${num }" type="currency" currencySymbol="$"/><br>
	
	<fmt:formatNumber value="${num }" pattern="#,###.##"/><br>
	<fmt:formatNumber value="${num }" pattern="0,000.00"/><br>
	
	<hr>
	<fmt:parseNumber var="f" value="123.456"/>
	<fmt:parseNumber var="i" value="123.456" integerOnly="true"/>
	${f }<br>
	${i }
	<br>
	
	<hr>
	msg 파리미터의 값 : <%=request.getParameter("msg")%>
	

</body>
</html>