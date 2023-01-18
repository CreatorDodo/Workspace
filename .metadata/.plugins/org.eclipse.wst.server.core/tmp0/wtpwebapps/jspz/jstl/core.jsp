<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>core.jsp</title>
</head>
<body>
	<h3>JSTL ; JSP Standard Tag Library</h3>
	<c:out value="Hello world!~" />
	<hr>
	<%
	request.setAttribute("data", "<em>12345</em>");
	%>
	${data }
	<br>
	<c:out value="${data }" default="No data" />
	<br>
	<c:out value="${data }" escapeXml="true" />
	<br>
	<c:out value="${data }" escapeXml="false" />
	<br>

	<hr>
	<h3>변수 설정 및 사용</h3>
	<c:set var="x" value="7" />
	<c:set var="y" value="8" />
	x =${x }
	<br> y =
	<c:out value="${y }" />
	<br>


	<hr>
	<h3>자바 빈즈 사용</h3>
	<jsp:useBean id="tb" class="jspz.bean.TestBean" />
	<jsp:setProperty property="country" name="tb" value="Korea" />
	<jsp:getProperty property="country" name="tb" />
	|
	<jsp:getProperty property="city" name="tb" />
	|
	<jsp:getProperty property="name" name="tb" /><br>

	<c:set target="<%=tb%>" property="city" value="Seoul" />
	<c:set target="${tb}" property="name" value="Kim" />
	<c:out value="${tb.country }" />
	|
	<c:out value="${tb.city }" />
	|
	<c:out value="${tb.name }" />
	<br>

	<hr>
	<h3>Map 사용</h3>
	<jsp:useBean id="map" class="java.util.HashMap" />
	<c:set target="${map}" property="key" value="HashMap object" />
	${map.key }

	<hr>
	<h3>Defered Expression</h3>
	<c:set var="m" value="${map }" />
	<c:set var="fontColor" value="${m.fontColor }" />
	fontColor : ${fontColor }
	<br>

	<c:set var="bgColor" value="#{m.bgColor }" />
	bgColor : ${bgColor }
	<br>

	<hr>
	<c:set target="${map}" property="fontColor" value="yellow" />
	<c:set target="${map}" property="bgColor" value="green" />
	fontColor : ${fontColor }
	<br> bgColor : ${bgColor }
	<br>

	<hr>
	<h3>변수 삭제</h3>
	x =${x }
	<br> y =
	<c:out value="${y }" />
	<br>

	<c:remove var="x" />
	<c:remove var="y" />
	x =${x }
	<br> y =
	<c:out value="${y }" />
	<br>

	<hr>
	<h3>if</h3>
	<c:set var="num1" value="5" />
	<c:set var="num2" value="3" />
	num1 == num2 :
	<c:out value="${ num1 == num2 ? true : false }" />
	<br>

	<c:if test="${ num1 eq num2}">
		num1 eq num2 : true
	</c:if>
	<c:if test="${ num1 != num2}">
		num1 eq num2 : false
	</c:if>

	<!-- 세션에 sid가 없으면 '로그인 후 이용해 주세요.' 표시 -->
	<c:if test="${ sid == null || empty sessionScope.sid }">
	로그인 후 이용해 주세요.
	</c:if>

	<%
	session.setAttribute("sid", "admin");
	session.setAttribute("sid", "aaa");
	session.invalidate();
	%>
	<hr>
	<h3>choose - when - otherwise</h3>
	<c:choose>
		<c:when test="${ sid == null || empty sessionScope.sid }">
			로그인 후 이용해 주세요.
		</c:when>

		<c:when test="${ sid == 'admin' }">
			관리자 로그인 중
			
		</c:when>

		<c:otherwise>
			회원 로그인 중
		</c:otherwise>
	</c:choose>

	<hr>
	<h3>forEach</h3>
	<c:forEach begin="1" end="5" var="i" step="2">
		${i }.	Hello!~<br>
	</c:forEach>

	<%
	//문자열 배열 colors에 red, green, blue를 저장하고
	//만들어진 배열을 pageContext 객체의 속성에 저장

	String[] colors = { "red", "green", "blue" };
	pageContext.setAttribute("colors", colors);
	%>
	
	<c:forEach items="${colors }" var="color" varStatus="vs">
		${vs.index } : ${vs.count } : ${color } <br>
	</c:forEach>

	<hr>
	<h3>forTokens</h3>
	<c:forTokens items="&&,//,!,==;>;<;!=" var="op" delims=",">
		${op }
	</c:forTokens>
	<br>
	<c:forTokens items="&&,//,!,==;>;<;!=" var="op" delims=", ;">
		${op }
	</c:forTokens>
	
	<hr>
	<h3>import</h3>
	<c:import url="../basic/top.jsp"/>
	<c:import url="../basic/menu.jsp">
		<c:param name="newMenu" value="blue ocean"/>
	</c:import>

	<hr>
	<h3>url</h3>
	<c:url var="naver" value="https://search.naver.com/search.naver">
		<c:param name="where" value="nexearch"/>
		<c:param name="query" value="bbb"/>	
	</c:url>
	<a href="${naver }" target="_blank">네이버에서 bbb 검색</a>
	
	<hr>
	<h3>catch</h3>
	<c:catch var="e">
	<c:set var="num1" value="O"/>
	<c:out value="${num1 / 3 }"/>
	</c:catch>
	
	<c:out value="${e }"/><br>
	<c:out value="${e.message }"/>
	
	<hr>
	<h3>redirect</h3>
	<c:redirect url="../basic/menu.jsp">
	<c:param name="newMenu" value="red ocean"/>
	</c:redirect>
</body>
</html>