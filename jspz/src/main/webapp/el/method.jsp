<%@page import="jspz.bean.TestBean"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
List<TestBean> beanList = Arrays.asList(
		new TestBean("Korea", "Seoul", "Kim"),
		new TestBean("Japan", "Tokyo", "Mori"),
		new TestBean("China", "Bajing", "Wang") );

request.setAttribute("beanList", beanList);

%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>method.jsp</title>
</head>
<body>
	${ cities = beanList.stream()
						.map( bean -> bean.city)
						.toList(); '' }
	beanList의 도시들 : ${ cities }<br>

	${ japan = beanList.stream()
						.filter(bean -> bean.city == 'Tokyo')
						.toList(); '' }
						
	${ japan }<br>


	<h3>method call using EL</h3>

	<jsp:useBean id="fi" class="jspz.basic.FindId"/>
	<br><% out.print(fi.findId("")); %>
	<br>${ fi.findId("aaa") }
	<br>${ Math.random() }
	<br>${ Math.max(1, 2) }
	<hr>
	
	<h3>lambda using EL</h3>
	${ result = (x, y) -> x > y ? true : false; '' }
	1 > 2 : ${ result(1, 2) } <br>
	3 > 2 : ${ result(3, 2) }
	<hr>
	
	<h3>stream( ), sum( ) using EL, lambda</h3>
	${ list = [ 1, 2, 3, 4, 5 ]; '' }
	list = [ 1, 2, 3, 4, 5 ]
	합계 : ${ list.stream().sum() }<br>
	
	${ map = { 'a':5, 'b':10, 'c':15 }; '' }
	map = { 'a':5, 'b':10, 'c':15 }
	합계 : ${ map.entrySet()
				.stream()
				.map( entry -> entry.value )
				.toList()
				.stream()
				.sum() }
		
	<h3>filter( ) using EL, lambda</h3>
	list = [ 1, 2, 3, 4, 5 ]
	짝수의 합계 : ${ list.stream()
					   .filter(o -> o % 2 == 0)
					   .sum() }<br>
	
	<br>
	map = { 'a':5, 'b':10, 'c':15 }
	홀수의 합계 : ${ map.entrySet()
					.stream()
					.map( entry -> entry.value )
					.toList()
					.stream()
					.filter(o -> 0 % 2 != 0)
					.sum() }<br>
					

		
		
		
		
</body>
</html>