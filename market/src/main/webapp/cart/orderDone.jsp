<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String cartId = "", deliveryDate = "";

	//쿠키의 배송 정보를 화면에 표시
	Cookie[] cookies = request.getCookies();
for(Cookie cookie : cookies){
	switch(cookie.getName()){
	case "cartId" : cartId = cookie.getValue(); break;
	case "deliveryDate" : deliveryDate = cookie.getValue(); break;
	}
}	

%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>orderDone.jsp</title>
</head>
<body>
	<!-- 화면 상단 header -------------------------------------------- -->
	<%@ include file="/includes/header.jsp"%>




	<!-- 메인 타이틀 ----------------------------------------- -->
	<div class="jumbotron">
		<div class="container">
			<h3 class="display-4">주문 완료</h3>
		</div>
	</div>
	<!-- 메인 ------------------------------------------------- -->

	<div class="container">
	<div class="row">
		<div class="col">
		<p class="alert alert-danger p-3 text-center">주문해주셔서 감사합니다.</p></div></div>
		<p>주문하신 상품은 <%=deliveryDate%>에 배송될 예정입니다.</p>
		<p>주문번호 : <%=cartId%></p>
		<div class="row">
		<div class="col">
			<a href="/market/product/productList.jsp" class="btn btn-info">상품목록
				&raquo;</a>
		</div>



	</div>

	</div>
	<!-- 화면 하단 footer --------------------------------------- -->
	<%@ include file="../includes/footer.jsp"%>
	
<%	//쿠키 지우기
	for(Cookie cookie : cookies){
		switch(cookie.getName()){
		case "cartId" : cookie.setMaxAge(0); break;
		case "rname" : cookie.setMaxAge(0); break;
		case "deliveryDate" : cookie.setMaxAge(0); break;
		case "phone" : cookie.setMaxAge(0); break;
		case "zipNo" : cookie.setMaxAge(0); break;
		case "addr1" : cookie.setMaxAge(0); break;
		case "addr2" : cookie.setMaxAge(0); break;
		case "addr3" : cookie.setMaxAge(0); break;
		}
		response.addCookie(cookie);
	}


%>
</body>
</html>