<%@page import="java.net.URLDecoder"%>
<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="market.vo.ProductVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>orderInfo.jsp</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<style>
td:not(:first-child), th:not(:first-child) {text-align: center;}
</style>
<body>
	<!-- 화면 상단 header -------------------------------------------- -->
	<%@ include file="/includes/header.jsp"%>
	<!-- 메인 타이틀 ----------------------------------------- -->
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-4">주문 정보</h1>
		</div>
	</div>
	<!-- 메인 ------------------------------------------------- -->
	<div class="container col-9 border p-3 shadow-sm">
		<!-- 그렇지 않을 때 -->
<%
	
//0.한글 인코딩 처리
request.setCharacterEncoding("UTF-8");						
response.setContentType("text/html; charset=UTF-8");

String cartId = "", rname = "", deliveryDate = "", phone = "";
String zipNo = "", addr1 = "", addr2 = "", addr3 = "";

	//쿠키의 배송 정보를 화면에 표시
	Cookie[] cookies = request.getCookies();
for(Cookie cookie : cookies){
	switch(cookie.getName()){
	case "cartId" : cartId = cookie.getValue(); break;
	case "rname" : rname = cookie.getValue(); break;
	case "deliveryDate" : deliveryDate = cookie.getValue(); break;
	case "phone" : phone = cookie.getValue(); break;
	case "zipNo" : zipNo = cookie.getValue(); break;
	case "addr1" : addr1 = URLDecoder.decode( cookie.getValue(), "UTF-8" ); break;
	case "addr2" : addr2 = URLDecoder.decode( cookie.getValue(), "UTF-8" ); break;
	case "addr3" : addr3 = URLDecoder.decode( cookie.getValue(), "UTF-8" ); break;
	}
}
	

%>
			<form action="productAddProc.jsp" method="post" id="prodRegFrm" class="form-horizontal">
			<br>
			<div class="row">
				<label class="col-sm-2 font-weight-bold">수령인</label>
				<div class="col-sm-3"><%=rname%></div></div>
			
			<div class="row">
				<label class="col-sm-2 font-weight-bold">배송희망일</label>
				<div class="col-sm-3"><%=deliveryDate%></div></div>
			
			<div class="row">
				<label class="col-sm-2 font-weight-bold">연락처</label>
				<div class="col-sm-3"><%=phone%></div></div>
			
			<div class="row">
				<label class="col-sm-2 font-weight-bold">우편번호</label>
				<div class="col-sm-3"><%=zipNo%></div></div>
			
			<div class="row">
				<label class="col-sm-2 font-weight-bold">도로명 주소</label>
				<div class="col-sm-3"><%=addr1%></div></div>
			
			<div class="row">
				<label class="col-sm-2 font-weight-bold">상세 주소</label>
				<div class="col-sm-3"><%=addr3%> <%=addr2%></div></div>

			
</form>
<!-- 세션의 주문 정보를 화면에 표시 -->
<jsp:useBean id="pdao" class="market.dao.ProductDAO" />
<%
List<ProductVO> cartList = (ArrayList<ProductVO>) session.getAttribute("cartList");


if (cartList == null || cartList.size() == 0) {
%>	<div class="container">
	<!-- 장바구니가 비었을 때 -->
	<p class="alert alert-danger"
		style="text-align: center; height: 100px; padding: 40px;">장바구니에
		담긴 상품이 없습니다.</p>
	<a href="/market/product/productList"><input type="button" class="btn btn-secondary continueBtn" value="쇼핑 계속하기"></a>
	</div>
	

<%	
} else { //7.그렇지 않으면
	

%>


	

	<div class="container">
		<!-- 그렇지 않을 때 -->
		<div class="row">
		</div>


		<div>
			<!-- 장바구니 리스트 테이블 -->


			<table class="table">
				<thead>
					<tr>
						<th>주문상품</th>
						<th>수량</th>
						<th>가격</th>
						<th>소계</th>
					</tr>
				</thead>
				<tbody>
				<!-- 상품 하나씩 출력하기 -->
				
<%				int total = 0;
				for (ProductVO cartPvo : cartList) {
					int sum = cartPvo.getQuantity() * cartPvo.getPrice();	//소계
					total += sum; %><tr onClick="location.href='contactInfo.html'"
						style="cursor: pointer;">
						<td><%=cartPvo.getPid()%> - <%=cartPvo.getPname()%></td>
						<td><fmt:formatNumber value="<%=cartPvo.getQuantity()%>"/></td>
						<td><fmt:formatNumber value="<%=cartPvo.getPrice()%>"/></td>
						<td><fmt:formatNumber value="<%=sum%>"/></td>
											</tr>
				 <% 	} //END for %>
				<!-- END 상품 하나씩 출력하기 -->
					<tr
						style="cursor: pointer;">
						<td scope="row"></td>
						<td></td>
						<td class="font-weight-bold" style="">총액</td>
						<td class="font-weight-bold"><fmt:formatNumber value="<%=total%>"/></td>
						
					</tr>
				</tbody>
			</table>
			<!-- END 설문 목록 표시 테이블 -->
		</div>
		<div class="row">
		<div class="col text-right">
				<input type="button" class="btn btn-secondary backBtn" value="이전으로">
				<a href="orderDone.jsp"><input type="submit" class="btn btn-info delRegBtn" value="주문완료"></a>
				<a href="orderCancel.jsp"><input type="button" class="btn btn-warning" value="취소"></a>
				</div>	</div>
				</div>
</div>

<%

}

%>

	<!-- 화면 하단 footer --------------------------------------- -->
	<%@ include file="../includes/footer.jsp"%>
</body>
</html>