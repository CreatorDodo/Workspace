<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dataType.jsp</title>
</head>
<body>
	<h3>EL data type</h3>
	<br>${12345 }
	<br>${123.45 }
	<br>${true }
	<br>${false }
	<br>${"Hello" }
	<br>${'Hello' }
	<br>${null }
	
	<h3>EL operator</h3>
	${ 1 + 2 }
	<br>${ "1" + 2 }
	<br>${ "1" + '2' }
	<br>
	<br>${ "1" += 2 }
	<br>${ "1" += '2' }
	<br>
	<br>${ 5 / 2 }
<%-- 	<br>${ 5 div 2 } --%>
	<br>
	<br>${ 5 % 2 }
	<br>${ 5 mod 2 }
	<br>
	<br>${ 5 == 2 }
	<br>${ 5 eq 2 }
	<br>${ 5 eq 2 ? '같다' : '다르다'	}
	<br>
	<br>data is null : ${ data == null ? 'O' : 'X' }
	<br>data is empty : ${ empty data ? 'O' : 'X' }
	<hr>
	<!-- 세션에 sid 속성이 들어 있으면 로그아웃 표시
		 그렇지 않으면 로그인 표시 -->
	<br>${!empty sessionScope.sid ? '로그아웃' : '로그인' }
	<br>${ empty sessionScope.sid ? '로그인' : '로그아웃' }
	<br>
	<br>${a=1; b=2; c=a+b }
	<br>${c }
	<hr>

<%
	String starArr[] = {"sun", "moon", "Earth"};
	List<String> starList = Arrays.asList("해", "달", "별");
	Map<String, String>	starMap = new HashMap<>();
	starMap.put("one", "화성");
	starMap.put("two", "목성");
	starMap.put("sam", "토성");
	
	request.setAttribute("starArr", starArr);
	request.setAttribute("starList", starList);
	request.setAttribute("starMap", starMap);
%>

	<jsp:useBean id="tb" class="jspz.bean.TestBean"/>
	 <jsp:setProperty property="country" name="tb" value="Korea"/>
	 <jsp:setProperty property="city" name="tb" value="Seoul"/>
	 <jsp:setProperty property="name" name="tb" value="Lee"/>

	<h3>배열 출력</h3>
	${starArr }<br>
	${starArr[0] }<br>
	${starArr[1] }<br>
	${starArr[2] }<br>
	
	<h3>List 출력</h3>
	${starList }<br>
	${starList[0] }<br>
	${starList[1] }<br>
	${starList[2] }<br>
	
	<h3>Map 출력</h3>
	${starMap }<br>
	${starMap["one"] }<br>
	${starMap['two'] }<br>
	${starMap.sam }<br>
	
	<h3>자바빈즈 출력</h3>
	${tb }<br>
	${tb["country"] }<br>
	${tb['city'] }<br>
	${tb.name }<br>
	
	<h3>List 및 Map 객체 생성</h3>
	${list = [3, 6, 9] } : ${list[0] }	<br>
	${list = [3, 6, 9];'' } : ${list[2] } <br>
	${map = {'a' : 'apple',
			 'b' : 'banana',
			 'c' : 'carrot' } }	${map['b'] }<br>
	${map = {'a' : 'apple',
			 'b' : 'banana',
			 'c' : 'carrot' };'' } ${map.a }<br>
			 
</body>
</html>