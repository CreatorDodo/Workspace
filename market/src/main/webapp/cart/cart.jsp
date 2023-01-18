<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="market.vo.ProductVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cart.jsp</title>
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
			<h1 class="display-4">장바구니</h1>
		</div>
	</div>
	<!-- 메인 ------------------------------------------------- -->

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
			<div class="col">
				<!-- 화면 상단 버튼 -->
				<a href="../cart/cartClearProc.jsp"><input type="button" class="btn btn-danger" value="장바구니 비우기"></a>
			</div>
			<div class="col text-right">
				<a href="deliveryInfo.jsp"><input type="button"
					class="btn btn-success" value="주문하기"></a>
			</div>
		</div>


		<div>
			<!-- 장바구니 리스트 테이블 -->


			<br><br>
			<table class="table">
				<thead>
					<tr>
						<th>상품</th>
						<th>수량</th>
						<th>가격</th>
						<th>소계</th>
						<th>비고</th>
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
						<td><a href="../cart/cartRemoveProc.jsp?pid=<%=cartPvo.getPid()%>"><span class="badge badge-danger">삭제</span></a></td>
					</tr>
				 <% 	} //END for %>
				<!-- END 상품 하나씩 출력하기 -->
					<tr
						style="cursor: pointer;">
						<td scope="row"></td>
						<td></td>
						<td class="font-weight-bold" style="">총계</td>
						<td class="font-weight-bold"><fmt:formatNumber value="<%=total%>"/></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<!-- END 설문 목록 표시 테이블 -->
		</div>
		<a href="/market/product/productList"><input type="button" class="btn btn-secondary continueBtn" value="쇼핑 계속하기"></a>
	</div>


<%

}

%>

	<!-- 화면 하단 footer --------------------------------------- -->
	<%@ include file="../includes/footer.jsp"%>
</body>
</html>


