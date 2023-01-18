<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%! String greetingUpper = "WELCOME to WEB SHOPPING MALL"; %>
<% String greetingLower = "welcome TO web market!"; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MARKET</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<!-- 화면 상단 header -------------------------------------------- -->
<%@ include file="includes/header.jsp" %>

<!-- 메인 타이틀 ----------------------------------------- -->
<div class="jumbotron">
	<div class="container">
		<h1 class="display-4"><%=greetingUpper %></h1></div>
</div>

<!-- 메인 ------------------------------------------------- -->
<div class="container">
	<div class="text-center">
		<h3><% out.print(greetingLower); %></h3>
	</div>
</div>	

<!-- 화면 하단 footer --------------------------------------- -->
<%@ include file="includes/footer.jsp" %>
</body>
</html>
